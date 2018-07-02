# springboot-swagger-service

implementation of API for
1. General algorithmic tasks endpoint
2. To Do List endpoints

Live URL
Supports HTTPS, certificate is self signed so browser will give warning but you can safely proceed.

https://ec2-13-211-167-3.ap-southeast-2.compute.amazonaws.com:8080/test/1.0/swagger-ui.html

If do not want to proceed with HTTPS, here is another container deployed with plain HTTP support

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

1.  **Provide here**

  detail will go here.


 
## What better can be done in version 2.0
* provide thoughts. 