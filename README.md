# TODO endpoints

implementation of API endpoints for
1. General algorithmic tasks
2. To Do List endpoints

Live URL

**Supports HTTPS** https://ec2-13-211-167-3.ap-southeast-2.compute.amazonaws.com:8080/test/1.0/swagger-ui.html

>certificate is self signed so browser will give warning but you can click advance button and safely proceed.

>If do not want to proceed with HTTPS, here is another container running with plain HTTP support

**Supports HTTP**
http://ec2-13-211-167-3.ap-southeast-2.compute.amazonaws.com:80/test/1.0/swagger-ui.html

## How to build and run from source

1.  #### clone repository

        git clone https://github.com/arunchauhan54/springboot-swagger-service.git

2.  #### go to project directory

        cd springboot-swagger-service  

3.  #### Application uses port 8443, make sure its free on host machine

    ##### Windows

        gradlew bootRun
  
    ##### Other

        ./gradlew bootRun
    
4. #### All done. Please goto

        http://localhost:8443/test/1.0/swagger-ui.html
        

## Assumptions

* Configuring JWT is not part of exercise
* Load balancing and multiple node deployment is not needed
* Its fine to use self sign certificate for https communications

 
## What better can be done in version 2.0

* Logging support should be added.
* Rest should use hateoas to add related link of subject as part of response.
* Exception handling should be improved to handled few other scenarios.
* More test case for patch and validation exception.

> A request : while running integration testing from client provided link i realised that because of my self sign https
 certificate its failing.Please do testing directly from swagger UI. 

> Client provided link was returning response for scheme as HTTPS so assuming that as expected behavior I have also exposed 
docker container port for HTTPS only.