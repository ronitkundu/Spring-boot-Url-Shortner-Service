#Spring boot url Shortner Application

#Requirements- Eclipse, Maven, jdk16,Git

#This application is having in-memory H2 database and is a spring boot application with embedded tomcat.

#To run this application we need to have clone the code from git then imoprt the project into Eclipse workspace. This is a maven project.We need to have maven installed on our system and jdk also required.

#Once imported in Eclipse workspace we need we need to build the code using maven-install option

#Then we can the application from RunAsApplication since tomcat is embedded with this application it will get started at localhost:8080

#Once we hit localhost:8080 the page will have 1 input as Long Url and once submitted it will produce the short url. The page will also contain the list of All Short Url available and Hit Counts of those URL's

#We can also build the war file url-shortner-0.0.1-SNAPSHOT.war  generated in target file once build and on host it on weblogic server.

###############Unit Testing ###############

#Unit Testing is done using Spring boot Starter Test Junit and Mockito where we are mocking the dao layer

#1st Test Case
##We are checking if we are getting all the list of objects of Shortened urls from db

#2nd Test Case
##We are checking if Rest Controller is returning correct Short Url depending on the the validation of Long URL

#3rd Test Case
#We are checking if correct Long Url is returned from the provided short Url 

#4th Test Case
##We are checking if The Controller is return the Home page Url properly




