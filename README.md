# Charter Enterprise MOTD Sample Project
A web service that returns a message of the day, which can also be set via a secure PUT request.

## Instructions
The put command can must be done using https and port 8443 and requires a Content-Type : application/json header. The following JSON format should be used in the body of the http request:

{"message":"This is the new message.",
"securityKey":"ofihuUD$5hfQRcLX&34"}

The securityKey is just a static variable stored in the controller. I used RESTClient for testing. Note that a security exception must be added for the https endpoint because the certificate is locally-generated and has not been registered.

### Getting Started
* To compile
mvn clean install dockerfile:build

* To run
If using Docker:
docker run -p 8080:8080 -p 8443:8443 -t springio/motd-code-sample
else:
From the target directory
java -jar motd-code-sample-1.0-SNAPSHOT.jar

* To see the message:
I used a browser:
locally: localhost:8080
AWS: http://ec2-52-14-195-214.us-east-2.compute.amazonaws.com:8080

* To change the message:
locally: https://localhost:8443/
AWS: https://ec2-52-14-195-214.us-east-2.compute.amazonaws.com:8443

See the instructions above for generating the PUT command.


### Prerequisites
* Java 1.8
* Maven
* RESTClient in Firefox was what I used for testing the PUT command

### Deployment
This is now running in AWS at http://ec2-52-14-195-214.us-east-2.compute.amazonaws.com. There is currently done manually - there is no build integration for AWS deployment.
