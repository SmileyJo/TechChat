#!/usr/bin/env python

#root@localhost: eteyzgFG5B%k

import socket;
import sys;
import sqlite3;
import time;
import signal;
from threading import Lock;
from thread import *;
#proper command line start: ./tcserver.py <port>
if(len(sys.argv) < 2):
    print 'Usage: python tcserver.py <port>';
    sys.exit(0);


#right now its hosted on local host, so on a tech ip, it should
#be accessable to any user
HOST = '';   # Symbolic name meaning all available interfaces
PORT = int(sys.argv[1]); # Arbitrary non-privileged port
true = True;
false = False;
#database semaphores
dbLock  =   Lock();    #allows only 1 thread to use the database at any given time=


s = socket.socket(socket.AF_INET, socket.SOCK_STREAM);
print 'Socket created';

try:
    s.bind((HOST, PORT));
except socket.error , msg:
    print 'Bind failed. Error Code : ' + str(msg[0]) + ' Message ' + msg[1];
    sys.exit();
     
print 'Socket bind complete';


end = 1;



def dieQuietly(_signo, _stackframe):
    s.close();
    sys.exit(0);

signal.signal(signal.SIGTERM, dieQuietly);

def status(data, db):
    #query the db for login info matching
    #the inputted username and pw
    c = db.cursor();
    return None;

def exit(data, db):
    #query the db for login info matching
    #the inputted username and pw
    return None;

def send(data, db):
    c = db.cursor();
    #query the db for login info matching
    #the inputted username and pw
    #Send Message:from:to:msg
    if(len(data) != 4):
        conn.send('Illegal Argument Exception: 4 arguments expected');
    #we need to write the procedure for the server to execute
    #because sqlite3 doesn't support procedures
    sender = data[1].strip();
    reciever = data[2].strip();
    msg = data[3].strip();

    #user table cs is different
    #to keep user table unlocked
    dbLock.acquire(true);
    #"select * from people where name_last=:who and age=:age", {"who": who, "age": age}
    senderR = c.execute('select User_ID from Users where Username="'+sender+'";').fetchall();
    recieverR = c.execute('select User_ID from Users where Username="'+reciever+'";').fetchall();
    #critical section
    
    conversations = c.execute('select c_ID from Conversation where (u_One=' + str(senderR[0][0])
        + ' and u_Two=' + str(recieverR[0][0]) + ') or (u_One=' + str(recieverR[0][0]) + ' and u_Two='+str(senderR[0][0])+');').fetchall();
    #multiple conversations found, throw an error
    if(len(conversations) > 1):
        print('Unexpected return value from Comversation table');
    #no conversations found, add a new conversation and then insert relpy
    elif(len(conversations) == 0):
        c.execute('insert into Conversation(u_One, u_Two) values('+str(senderR[0][0])+', '+str(recieverR[0][0])+ ');');
        conversations = c.execute('select c_ID from Conversation where (u_One=' + str(senderR[0][0])
            + ' and u_Two=' + str(recieverR[0][0]) + ') or (u_One=' + str(recieverR[0][0]) + ' and u_Two='+str(senderR[0][0])+');').fetchall();
        conver = conversations[0][0];
        c.execute('insert into Reply(c_fk_ID, user_fk_ID, reply) values('+str(conver)+', '+str(senderR[0][0])+', "'+msg+'");');
    #one conversation found, insert reply
    else:
        conver = conversations[0][0];
        c.execute('insert into Reply(c_fk_ID, user_fk_ID, reply) values('+str(conver)+', '+str(senderR[0][0])+', "'+msg+'");');
    
    db.commit();
    dbLock.release();
    return None;
    #end critical section

def recieve(data, db):
    #query the db for login info matching
    #the inputted username and pw
    #input format:  Message Request:user
    #using test user
    #return format:     sender:reciever:message
    try:
        dbLock.acquire(true);
        c = db.cursor();
        print(c.execute('select User_ID from Users where Username="chicken"').fetchall());
        response = {};
        user = data[1].strip(); #eventually will be replaced with an argument from data
        #get all conversations this user is in
        cmd = 'select User_ID from Users where Username="{}"'.format(user);
        luid = c.execute(cmd);
        uid = luid.fetchall()[0][0];
        cmd = "select c_ID, u_One, u_Two from Conversation where u_One={} or u_Two={}".format(str(uid),str(uid));
        conversations = c.execute(cmd).fetchall();
        strings = 0;#size of response array
        for i in range (0, len(conversations)):
            #get all messages in a given conversation
            cmd = "select reply,user_fk_ID from Reply where c_fk_ID={}".format(str(conversations[i][0]));
            msgs = c.execute(cmd).fetchall();
            print(str(msgs));
            for j in range (0, len(msgs)):
                #get sender id and reciever id
                senderid = msgs[j][1];
                msg = msgs[j][0];
                recieverid = 0;
                if(senderid != uid):
                    recieverid = uid;
                else:
                    if(conversations[i][1] != uid):
                        recieverid = conversations[i][1];
                    else:
                        recieverid = conversations[i][2];

                #get user names
                cmd = "select Username from Users where User_ID={}".format(str(senderid));
                sender = c.execute(cmd).fetchall()[0][0];
                cmd = "select Username from Users where User_ID={}".format(str(recieverid));
                reciever = c.execute(cmd).fetchall()[0][0];

                #add message to the response array
                response[strings] = "{}:{}:{}\n".format(sender,reciever,msg);
                strings=strings+1;

        dbLock.release();
        return response;
    except sqlite3.Error,msg:
        print(msg);
        dbLock.realease();



def new_user(data, db):
    #creates a new user and stores it into the database
    #command syntax: Add User:email:username:password
	
	if(len(data) == 4):
		try:
			email = data[1].strip();
			username = data[2].strip();
			password = data[3].strip();
			newUser = (str(username), str(password), str(email))
			c = db.cursor();
			dbLock.acquire(true,);
			c.execute("insert into Users(Username, Password, Email) VALUES(?, ?, ?)", newUser);
			db.commit();
		except sqlite3.IntegrityError:
			conn.send('Username already exists.\n');
			db.rollback();
			dbLock.release();
			return 'fal';
			
		dbLock.release();
		return 'ack';

def conversation(data, db):
    #Syntax: Conversation Request:user
    #return syntax: user2
    try:
        user = data[1].strip();
        c = db.cursor();
        cmd = 'select User_ID from Users where Username="{}"'.format(user);
        dbLock.acquire(true,);
        uid = c.execute(cmd).fetchall()[0][0];
        cmd = 'select c_ID from Conversation where u_One={0} or u_Two={0}'.format(uid);
        convers = c.execute(cmd).fetchall()[0];#just the user ids
        response = {};
        for i in range (0, len(convers)):
            cmd = 'select u_One from Conversation where c_ID={}'.format(convers[i]);
            u1 = c.execute(cmd).fetchall()[0][0];
            cmd = 'select u_Two from Conversation where c_ID={}'.format(convers[i]);
            u2 = c.execute(cmd).fetchall()[0][0];
            if(u1 == uid):
                cmd = 'select Username from Users where User_ID={}'.format(u2);
                u = c.execute(cmd).fetchall()[0][0];
                response[i] = '{}'.format(u);
            else:
                cmd = 'select Username from Users where User_ID={}'.format(u1);
                u = c.execute(cmd).fetchall()[0][0];
                response[i] = '{}:'.format(u);
        dbLock.release();
        return response;
    except sqlite3.Error,msg:
        print(msg);
        dbLock.release();

def login(data, db):
    #log into the server
    #command syntax: Login:user:password
    print('login called');
    dbLock.acquire(true,);
    username = data[1].strip();
    password = data[2].strip();
    cmd = "select User_ID from Users where Username='{}' and Password='{}'".format(username,password);
    dbLock.release();
    res = db.cursor().execute(cmd).fetchall();
    if(len(res) > 1 or len(res) == 0):
        return "fal";
    else:
        return "ack";

#language of commands
commands = {'Change Status'         : status,           #changes status of the user on the database
            'exit'                  : exit,             #exits from the server and destroys the thread
                                                        #also sets status to offline
            'Send Message'          : send,             #sends a message from the user to another user
            'Message Request'       : recieve,          #the client asks for all recieved messages
            'Add User'              : new_user,
            'Login'                 : login,
            'Conversation Request'  : conversation
            };

#Function for handling connections. This will be used to create threads
def clientthread(conn):
    #Sending message to connected client
    #conn.send('Welcome to the server. Type something and hit enter\n'); #send only takes string
    database = sqlite3.connect('database.db');
    QQ = 0;

    #force the user to log in before using the app
    user = "";
    while(user == ""):
        data = conn.recv(1024);
        command = data.split(':');
        if(command[0].strip() != 'Login' and command[0].strip() != 'Add User'):
            conn.send('Must log in before using the app\n');
        else:
            response = commands[command[0]](command, database);
            conn.send(response + "\n");
            if(response == 'ack'):
                user = data[1];
    #infinite loop so that function do not terminate and thread do not end.
    #Receiving from client
    data = conn.recv(1024);
    command = data.split(':');

    #need to split data into multiple tolkens
    for i in range (0, len(command)):
        print(command[i]);

    response = commands[command[0].strip()](command, database);
    if(response != None):
        for i in range (0, len(response)):
            conn.send(response[i].encode('utf-8'));
     
    #came out of loop
    conn.close();
    database.close();






def debugthread():
    print('debug mode on\n');
    database = sqlite3.connect('database.db');
    c = database.cursor();
    try:
             # c.execute('select User_ID from Users where Username="chicken";')
        data = c.execute('select asdf from Users where Username="chicken"');
        print(data.fetchall());
    except sqlite3.Error, msg:
        print('error in the database');
        print(msg);
    c.close();
    database.close();

if(false):
    print('starting debug mode\n')
    db1 = start_new_thread(debugthread, ());
    end = 0;
    time.sleep(5);


s.listen(10); #tells the socket to start listening and
              #specifies the queue for incomming communications
print 'Socket now listening';
#now keep talking with the client
while (end == 1):
    #wait to accept a connection - blocking call
    conn, addr = s.accept();
    print 'Connected with ' + addr[0] + ':' + str(addr[1]);
     
    #start new thread takes 1st argument as a function name to be run, second is the tuple of arguments to the function.
    start_new_thread(clientthread ,(conn,));
 
s.close()
