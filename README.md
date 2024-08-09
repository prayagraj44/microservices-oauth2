# microservice


This project has following services as a part microservice architecture

config-server
eureka-server
auth-server
registration-server

1. config server is centralized service providing and boostraping 
configs and properties to all other services.

Have Used git to hold properties file ,created a "shared" folder under the resouces
and initailized it as a git repo (remote github can be used as well)


2.eureka service - identify and maintain registry of all other services running
including their urls and port

3 auth - created auth server using oauth2.0 to act as Authorization server to other resource server like(registration service)

4 registration service  -  rest api exposing endpoints to create user and perform operation on them using h2 for db and jpa for persistence
                        - to consume resgistration serivce one must first obtain access token from auth server [use postman on  http://localhost:8081/oauth/token]
			- and then use that token to access rest endpoints of resgistration serivce

_________________________________________________________________________________________________________
Sequence for starting microservcies

config-server -> eureka-server ->auth-server ->registration-server
* also please initalize  config-server/resources/shared as a git reposiotory
_________________________________________________________________________________________________________

Generating access token from auth server

hit the url  http://localhost:8081/oauth/token  with following params

Use Basic auth 
username:prayag-client 
password:prayagclientsecret

and following keys in body

username:prayag
password:prayagsecret
grant_type:password


above values are set in application properties file

access token will be generated to access resgistration api

_________________________________________________________________________________________________________________________________
Swagger ui is included in registration-server security on swagger ui is configured to allow it to display ui on
http://localhost:8080/swagger-ui/#/user-registration-controller/

Alos h2 database console is permitted @http://localhost:8080/h2-console

url, username and password is registration.properties fo central config server which will be bootstraped

_____________________________________________________________________________________________________________________________________
To change properties file property of specific service open that property file in  resources/shared folder change it and commit in git


git status
git add *
git commit -m "<<changes made desc>>"







