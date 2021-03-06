#!/usr/bin/env python

#root@localhost: eteyzgFG5B%k

import socket;
import sys;
import sqlite3;
import threading;
from thread import *;

#right now its hosted on local host, so on a tech ip, it should
#be accessable to any user
HOST = '';   # Symbolic name meaning all available interfaces
PORT = 8887; # Arbitrary non-privileged port

#database semaphores
converLock  =   BoundedSemaphore(1);    #allows only 1 thread to use the table at any given time
userLock    =   BoundedSemaphore(1);    #allows only 1 thread to use the table at any given time
replyLock   =   BoundedSemaphore(1);    #allows only 1 thread to use the table at any given time
delLock     =   BoundedSemaphore(1);    #allows only 1 thread to use the table at any given time



s = socket.socket(socket.AF_INET, socket.SOCK_STREAM);
print 'Socket created';
 
try:
    s.bind((HOST, PORT));
except socket.error , msg:
    print 'Bind failed. Error Code : ' + str(msg[0]) + ' Message ' + msg[1];
    sys.exit();
     
print 'Socket bind complete';

s.listen(10); #tells the socket to start listening and
			  #specifies the queue for incomming communications
print 'Socket now listening';
end = 1;

# 0 = Online, 1 = Away, 2 = Busy, 3 = Invisible(Offline to others), 4 = Offline(exits)
# Default status: Online
def status(data, c):
 	if(len(data) != 3):
		conn.send('Illegal Argument Exception: 2 arguments expected');

	userLock.acquire(true,)
	username = data[1];
	status = data[2];
	c.execute('update Users set status='+status+' where Username ='+username';');
	conn.commit();
	userLock.release();

	if(status == 4):
		conn.close();
		c.close();
		database.close();
	
    print("status called");

def exit(data, c):

    print("exit called");

def send(data, c):
    #query the db for login info matching
    #the inputted username and pw
    if(len(data) != 4):
        conn.send('Illegal Argument Exception: 4 arguments expected');
    print("send called");
    #we need to write the procedure for the server to execute
    #because sqlite3 doesn't support procedures
    sender = data[1];
    reciever = data[2];
    msg = data[3];

    #user table cs is different
    #to keep user table unlocked
    userLock.aquire(true,);
    senderR = c.execute('select * from Users where Username='+sender+';');
    recieverR = c.execute('select * from Users where Username='+reciever+';');
    userLock.release();
    
    #c_ID  INTEGER      PRIMARY KEY
    #                   NOT NULL,
    #u_One INT (11)     NOT NULL
    #                   REFERENCES Users (User_ID),
    #u_Two INT (11)     REFERENCES Users (User_ID) 
    #                   NOT NULL,
    #time  INT (11)     DEFAULT NULL,
    #ip    VARCHAR (30) DEFAULT NULL

    #critical section
    replyLock.aquire(true,);
    converLock.aquire(true,);
    
    conversations = c.execute('select * from Conversation where (u_One=' + senderR[0].User_ID
        + ' and u_Two=' + recieverR[0].User_ID + ') or (u_One=' + recieverR[0].User_ID + ' and u_Two='+ senderR[0].User_ID +');');
    #multiple conversations found, throw an error
    if(len(conversations > 1)):
        print('Unexpected return value from Coversation table');
    #no conversations found, add a new conversation and then insert relpy
    elif(len(conversations == 0)):
        c.execute('insert into Conversation(u_One, u_Two) values('+senderR[0].User_ID+', '+recieverR[0].User_ID + ');');
        conversations = c.execute('select * from Conversation where (u_One=' + senderR[0].User_ID
            + ' and u_Two=' + recieverR[0].User_ID + ') or (u_One=' + reciever + ' and u_Two='+sender+');');
        conver = conversations[0].c_ID;
        c.execute('insert into Reply(c_fk_ID, user_fk_ID, reply) values('+conver+', '+senderR[0].User_ID+', '+msg+');');
    #one conversation found, insert reply
    else:
        conver = conversations[0].c_ID;
        c.execute('insert into Reply(c_fk_ID, user_fk_ID, reply) values('+conver+', '+senderR[0].User_ID+', '+msg+');');
    
    replyLock.release();
    converLock.release();
    #end critical section

def recieve(data, c):

	if(len(data) != 3):
		conn.send('Illegal Argument Exception: 3 arguments expected');

	sender = data[1];
	reciever = data[2];

	userLock.acquire(true,);
    senderR = c.execute('select * from Users where Username='+sender+';');
    recieverR = c.execute('select * from Users where Username='+reciever+';');
    userLock.release();

	converLock(true,);
	conversations = c.execute('select * from Conversation where (u_One=' + senderR[0].User_ID
        + ' and u_Two=' + uTwo[0].User_ID + ') or (u_One=' + recieverR[0].User_ID + ' and u_Two='+ senderR[0].User_ID +');');
	converLock.release();

	if(len(conversations) > 0):
		replyLock.acquire(true,);
		c.execute('select (reply, time) from Reply where (u_One='+senderR[0].User_ID+'and u_Two='reciever[0].User_ID+') or (u_One='+recieverR[0].User_ID+'and u_Two='+recieverR[0].User_ID+');');
		replyLock.release();
    print("recieve called");

def new_user(data, c):
	if(len(data) != 3):
		conn.send('Illegal Argument Exception: 3 arguments expected');
	#correct arguments, insert user
	username = data[1];
	password = data[2];

	else:
		#potentially change to support email
		userLock.aqcuire(true,);
		c.execute('insert into Users(Username, Password) values('+username+','+password+');');
		userLock.release();
    print("new_user called");


#language of commands
commands = {'Change Status'     : status,           #changes status of the user on the database
            'exit'              : exit,                      #exits from the server and destroys the thread
                                                    #also sets status to offline
            'Send Message'      : send,             #sends a message from the user to another user
            'Message Request'   : recieve,          #the client asks for all recieved messages
            'add user'          : new_user
            };

#Function for handling connections. This will be used to create threads
def clientthread(conn):
    #Sending message to connected client
    conn.send('Welcome to the server. Type something and hit enter\n'); #send only takes string
    database = sqlite3.connect('database');
    c = database.cursor();
    QQ = 0;

    #infinite loop so that function do not terminate and thread do not end.
    while QQ != 1:
         
        #Receiving from client
        data = conn.recv(1024);
        command = data.split(':');

        if(command[0] == "exit"):
            commands[command[0]](command);
            QQ = 1;
            break;
        #need to split data into multiple tolkens
        for i in range (0, len(command)):
            print(command[i]);

        commands[command[0]](command, c);
     
     
    #came out of loop
    conn.close();
    c.close();
    database.close();
    
#now keep talking with the client
while (end == 1):
    #wait to accept a connection - blocking call
    conn, addr = s.accept();
    print 'Connected with ' + addr[0] + ':' + str(addr[1]);
     
    #start new thread takes 1st argument as a function name to be run, second is the tuple of arguments to the function.
    start_new_thread(clientthread ,(conn,));
 
s.close()
