/*****************************************************************************
 *	Program: ServerTest.c
 *	@author: Dane Jensen
 *	Purpose:	Use a standard testing tool to help debug issues with
 *				The server program used by tech chat
 *****************************************************************************/

 #define debug

 #include <stdio.h>
 #include <stdlib.h>
 #include <sys/types.h>
 #include <sys/socket.h>
 #include <netinet/in.h>
 #include <netdb.h> 


 int main(int argc, char** argv){
 	//file redirection is expected, but manual input is allowed
 	//arguments:
 	//[0] is the program name
 	//[1] is the port
 	//[2] is the ip address
 	int sockfd,				//the file descripter for the socket
 		portno, 			//the port
 		n;
 	portno = atoi(argv[1]);
 	char* hostname;
 	struct sockaddr_in serv_addr;
    struct hostent *server;
 	char buffer[256];
 	if(argc == 2){
 		hostname = "";//localhost
 	}else{
 		hostname = argv[2];//an actual ip address
 	}
 	sockfd = socket(AF_INET, SOCK_STREAM, 0);
 	server = gethostbyname(hostname);

 	bzero((char *) &serv_addr, sizeof(serv_addr));

 	serv_addr.sin_family = AF_INET;
 	serv_addr.sin_port = htons(portno);
 	bcopy((char *)server->h_addr, (char *)&serv_addr.sin_addr.s_addr,server->h_length);
 	if (connect(sockfd,(struct sockaddr *)&serv_addr,sizeof(serv_addr)) < 0) 
        error("ERROR connecting");
    //now connected to the server
    //put debugging code here
//start example code


 }


