#a server socket example in python

import socket;
import sys;
from thread import *;
 
HOST = '';   # Symbolic name meaning all available interfaces
PORT = 8886; # Arbitrary non-privileged port
 
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

#Function for handling connections. This will be used to create threads
def clientthread(conn):
    #Sending message to connected client
    conn.send('Welcome to the server. Type something and hit enter\n'); #send only takes string
     
    #infinite loop so that function do not terminate and thread do not end.
    while True:
         
        #Receiving from client
        data = conn.recv(1024);
        data = data.strip();
        print(data);
        reply = 'OK...' + data + '\n';
        if (str(data) == "shutdown" or str(data) == "shutdown\n"):
        	print("attempting to close socket\n");
        	conn.sendall(reply);
        	conn.close();
        	break;
        if not data: 
            break;
     
        conn.sendall(reply);
     
    #came out of loop
    conn.close();
 
#now keep talking with the client
while (end == 1):
    #wait to accept a connection - blocking call
    conn, addr = s.accept();
    print 'Connected with ' + addr[0] + ':' + str(addr[1]);
     
    #start new thread takes 1st argument as a function name to be run, second is the tuple of arguments to the function.
    start_new_thread(clientthread ,(conn,));
 
s.close()

