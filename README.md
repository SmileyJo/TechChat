# TechChat

This app is an instant messaging app. It contains a page to compose, veiw, and send messages, a phone book, a settings page, and a main menu.

TO ADD A CONTACT select "compose" and send someone a message. This person's username will be added to your phonebook automaticly. 

TO VIEW CONTACTS you can simply select "phonebook" to veiw people. Or you can look at the main menu. The main menu will contain contacts that have recently sent you messages, making them easier to find, select, and send messages to. 

TO GO INTO BLOCK MODE select "block" from the menu buttons and it will automaticly give anyone who messages you an auto-response so you can study undisturbed.  

TO ADJUST BLOCK MODE SETTINGS "settings" to alter your message count before deletion, implement an auto-response for when you are in block mode.  

Server Maininence Stuff:
Comminutactions between client and server are done through a socket.  The client will send a command from the predefined language of
commands and the server will then take action based on that command and then send a response if a response is nessisary.

To simulate a client, all one needs to do is telnet into the server (the port is hard coded atm) and use one of the following commands:
Send Message:sender:reciever:message  (sends a message to another user)
Recieve Message:user (recieves all messages that this user has been involved in)

To run a copy of the server locally, you need to have python and sqlite3 installed on your computer, then you should be able to run it
like any compiled c program (with the ./ method).
