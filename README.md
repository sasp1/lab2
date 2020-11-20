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
java -cp src/main/java Server.PrintServer
```
it should prompt the message
```
Print server registered
```
***
## Client

Open a terminal and navigate to the ```src``` folder.

To compile the client files run
``` 
javac -cp src/main/java src/main/java/Client/Client.java 
``` 
To start a client
```
java -cp src/main/java Client.Client
```
it should prompt the messages 

```
Please enter credentials to login...

Username:
```
Remember, you can launch multiple clients. To do this, open 
the new terminals, navigate to the src folder and omit the compilation
of the client files and just run the start client command.

The solution comes with four users
* user 1
    - *username:* Alice // (Manager)
    - *password:* smoky android spearman afar
* user 2
    - *username:* George // (Service Technician)
    - *password:* financial quote suffix parole
* user 3
    - *username:* Cecilia // (Power User)
    - *password:* petal cuddly unhook overreach
* user 4
    - *username:* Ida // (Power User)
    - *password:* Lets run away
* user 5
    - *username:* David // (Regular User)
    - *password:* balance prone applaud crayon
* user 6
    - *username:* Henry // (Regular User)
    - *password:* Duis aute irure dolor
* user 7
    - *username:* Erica // (Regular User)
    - *password:* DS 02239 FTW
* user 8
    - *username:* Fred // (Regular User)
    - *password:* 21 sah esaelp ew nac



**Important(!)**

Make sure you do not copy/enter the white spaces in front or after the username/password

A successful login attempt is shown below

```
Username: Alice
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
