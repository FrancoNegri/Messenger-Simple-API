# ASAPP Chat Backend Challenge v1
### Overview
This is a java based boilerplate which runs an HTTP Server configured to answer the endpoints defined in 
[the challenge you received](https://backend-challenge.asapp.engineering/).
All endpoints are configured in src/main/java/com/asapp/backend/challenge/Application.java and if you go deeper to the
Routes and Filters passed as second parameters, you will find a TODO comment where you are free to implement your solution.

### How to run it
sudo docker-compose up

### Notes
The api uses spring-boot to function
	/check is a get instead of a POST given that I could not find a clean way to do it