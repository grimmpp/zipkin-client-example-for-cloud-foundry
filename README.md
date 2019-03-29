# Zipkin Client Example with Spring Boot 2 for Cloud Foundry

This project is to demonstrate how to create a RestTemplate based on java spring boot 2 so that it adds the zipkin headers automatically.

You can find in the class <a href="./src/main/java/de/grimmpp/springboot/zipkindemo/zipkindemo/ZipkinController.java">ZipkinController</a> an example of a REST endpoint which starts a series of cascading calls. By calling the endpint /zipkin?count=5 you can simulate a cascade of 5 + 1 initial call.
In the log output of Cloud Foundry you can see the log entries from the GoRouter for each single call. Because the calls are nested they start with the last one and the latest entries it the frist call which arrived at the app and the last response which was delivered.
In the following picture you can see example logs which were caused by http://zipkin-test.dev.cfdev.sh/zipkin?count=5 .

<img src="logs2.jpg" width="200" />

## How to build
````
./gradlew clean build
```` 

## How to deploy
````
./deploy.bat
````

## How to trigger app / generate logs
````
curl http://zipkin-test.dev.cfdev.sh/zipkin?count=5     #curl http://<APP_URL>/zipkin?count=<NUMBER_OF_CALLS>
````
