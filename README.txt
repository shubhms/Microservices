Youtube Link : https://youtu.be/_PQd6aZ-ANk

🔴 Microservices Crash Course for beginners || Spring Boot || Hindi


user-service
	port					-	9001
	/user/1344				-	get user details (without contact details)
			
contact-service
	port					-	9002
	/contact/user/116		-	get contacts of user 116
			
After using RestTemplate (which bound the two above services, we now get :
	/user/1344				-	get user details (with contact details) in user service
	
Now creating Eureka Server and Eureka Client to register our services, hence they could 
be discovered (Service Discovery)	-	currently our services are on localhost

Created a separate eserver project, and registered it as Eureka server by adding eureka netflix server dependency
Also in application.yml file, added conf so that it itself does not get registed as client

Now added dependency of eureka netflix client in userservice and contactservice. Now as soon as I added the 
client dependency, these two services started showing up as Instances (client) in browser page of http://localhost:8761/

No cofiguration was needed, this happened because as soon as client dependency was added in POM of userservice
and contactservice, springboot automatically checked whether any eureka server is running on the default port of
8761. Yes it was running, so registed the 2 services as client to this server.

Now changing Application name, and adding IP address and port to instances shown on Eureka server homepage.

With the help of Eureka server, and the services registered as client to it could be used by any of the microservice 
just by using the name, port of any other microservice registered with Eureka.

Now Designing, API Gateway (call any microservice, auth and authentication could be done):

API-gateway is just there so that our customer user hits only api-gateway URL or Port, nothing else. From therewe navigate to 
user-service or contact-service as per our convenience.


------------------------------------------------------------------------------------------------------------------------------------------
Video Link : https://youtu.be/PhOhauyinZU

After second commit of Hystrix capability added :

With Hystrix we can monitor our requests, how many requests failed, passed.
With Hystrix, we can configure reponse to our user in case any service is down.
For Eg : If user service is down, we can get appropriate response back
Like : "User service is down at this time!! Sorry for the inconvenience."

So I was able to get this response if the user service/ contact service is down.
But I was not able to open dashboard of Hystrix which shows the monitoring of requests whether failed or passed.





