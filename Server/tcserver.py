#!/usr/bin/env python

#a server socket example in python
#root@localhost: eteyzgFG5B%k

import socket;
import sys;
import sqlite3;
from thread import *;

#right now its hosted on local host, so on a tech ip, it should
#be accessable to any user
HOST = '';   # Symbolic name meaning all available interfaces
PORT = 8887; # Arbitrary non-privileged port
#db = mysql.connector.connect(host='root@localhost', password='eteyzgFG5B%k', database='danej');

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

def status(data, c):
    #query the db for login info matching
    #the inputted username and pw
    print("status called");

def exit(data, c):
    #query the db for login info matching
    #the inputted username and pw
    print("exit called");

def send(data, c):
    #query the db for login info matching
    #the inputted username and pw
    if(len(data) != 4):
        conn.send('Illegal Argument Exception: 4 arguments expected');
    print("send called");
    #sender, reciever, message
    c.execute('call sendmessage("' + data[1] + '". "' + data[2] + '", "' + data[3] + '")');

def recieve(data, c):
    #query the db for login info matching
    #the inputted username and pw
    print("recieve called");


#language of commands
commands = {'Change Status' : status, #changes status of the user on the database
            'exit' : exit,           #exits from the server and destroys the thread
                                     #also sets status to offline
            'Send Message' : send,    #sends a message from the user to another user
            'Message Request' : recieve,     #the client asks for all recieved messages
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
    
#now keep talking with the client
while (end == 1):
    #wait to accept a connection - blocking call
    conn, addr = s.accept();
    print 'Connected with ' + addr[0] + ':' + str(addr[1]);
     
    #start new thread takes 1st argument as a function name to be run, second is the tuple of arguments to the function.
    start_new_thread(clientthread ,(conn,));
 
s.close()
c.close();
database.close();
