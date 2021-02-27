# Getting Started
  
1. mvn clean install
2. start zipkin server on your local
3. run below command

`java -javaagent:opentelemetry-javaagent-all.jar -Dotel.exporter=zipkin -Dotel.exporter.zipkin.service.name=sleuth-application-otel-agent -Dotel.exporter.zipkin.endpoint=http://127.0.0.1:9411/api/v2/spans -jar target/messaging-spring-sleuth-0.0.1-SNAPSHOT.jar`

4. go to browser and hit url http://localhost:8080/xform
5. search for trace here http://localhost:9411/zipkin/

**Observation:** 

with Otel Java angent:

Only http spans by java agent is generated. No sleuth spans

<img width="1677" alt="Screen Shot 2021-02-26 at 4 17 15 PM" src="https://user-images.githubusercontent.com/1302580/109368482-1cbf1880-784e-11eb-9573-e255bfee7095.png">


FYI:

with sleuth/otel:

![XA ENGLISH](https://user-images.githubusercontent.com/1302580/109368402-d36ec900-784d-11eb-8f6e-715e9322a423.png)

