This is a quick guide on how to run the program 
on Linux or Mac (it has not been tested on Windows)
***

## Server

Open a terminal and navigate to the root of the project

To compile the server files run
``` 
javac -cp src/main/java src/main/java/Server/PrintServer.java 
```
To start the server
```
java -cp src/main/java Server/PrintServer
```
it should prompt the message
```
Print server registered
```
***
## Client.Client

Open a terminal and navigate to the ```src``` folder.

To compile the client files run
``` 
javac -cp src/main/java src/main/java/Client/Client.java 
``` 
To start a client
```
java -cp src/main/java Client/Client
```
it should promt the messages 

```
Please enter credentials to login...

Username:
```
Remember, you can launch multiple clients. To do this, open 
the new terminals, navigate to the src folder and omit the compilation
of the client files and just run the start client command.

The solution comes with four users
* user 1
    - *username:* ronaldo
    - *password:* smoky android spearman afar
* user 2
    - *username:* messi
    - *password:* financial quote suffix parole
* user 3
    - *username:* neymar
    - *password:* petal cuddly unhook overreach
* user 4
    - *username:* ramos
    - *password:* balance prone applaud crayon

**Important(!)**

Make sure you do not copy/enter the white spaces infront or after the password

A succesful login attempt is shown below

```
Username: ronaldo
Password: smoky android spearman afar
Successfully logged in!

1  - print
2  - queue
3  - top queue
4  - start
5  - stop
6  - restart
7  - status
8  - read configuration
9  - set configuration
0  - exit
Please enter desired action: 
```
