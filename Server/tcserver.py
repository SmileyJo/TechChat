#!/usr/bin/env python

#root@localhost: eteyzgFG5B%k

import socket;
import sys;
import sqlite3;
import time;
import signal;
from threading import Lock;
from thread import *;



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
    print("Sigterm Caught");
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
    
    #c_ID  INTEGER      PRIMARY KEY
    #                   NOT NULL,
    #u_One INT (11)     NOT NULL
    #                   REFERENCES Users (User_ID),
    #u_Two INT (11)     REFERENCES Users (User_ID) 
    #                   NOT NULL,
    #time  INT (11)     DEFAULT NULL,
    #ip    VARCHAR (30) DEFAULT NULL

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
    except Error,msg:
        print(msg);
        dbLock.realease();



def new_user(data, db):
    #create a new user
    #add user;username;password
    c = db.cursor();

def login(data, db):
    #log into the server
    #command syntax: Login:user:password
    print('login called');
    username = data[1].strip();
    password = data[2].strip();
    cmd = "select User_ID from Users where Username='{}' and Password='{}'".format(username,password);
    res = db.cursor().execute(cmd).fetchall();
    if(len(res) > 1 or len(res) == 0):
        return "fail";
    else:
        return "ack";

#language of commands
commands = {'Change Status'     : status,           #changes status of the user on the database
            'exit'              : exit,             #exits from the server and destroys the thread
                                                    #also sets status to offline
            'Send Message'      : send,             #sends a message from the user to another user
            'Message Request'   : recieve,          #the client asks for all recieved messages
            'Add User'          : new_user,
            'Login'             : login
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
        if(command[0].strip() != 'Login'):
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
        data = c.execute('select User_ID from Users where Username="chicken"');
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
