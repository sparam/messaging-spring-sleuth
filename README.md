# Getting Started
  
1. mvn clean install
2. start zipkin server on your local
3. run below command

`java -javaagent:opentelemetry-javaagent-all.jar -Dotel.exporter=zipkin -Dotel.exporter.zipkin.service.name=sleuth-application-otel-agent -Dotel.exporter.zipkin.endpoint=http://127.0.0.1:9411/api/v2/spans -jar target/messaging-spring-sleuth-0.0.1-SNAPSHOT.jar`

4. go to browser and hit url http://localhost:8080/xform
 * "HELLO" response
6. search for trace here http://localhost:9411/zipkin/


```2021-02-26 17:49:45.806  INFO [messaging-app,e4e09d3f4cca4f388678859353f22718,f02d2df157c63e17] 18250 --- [nio-8080-exec-1] o.a.c.c.C.[Tomcat].[localhost].[/]       : Initializing Spring DispatcherServlet 'dispatcherServlet'
2021-02-26 17:49:45.807  INFO [messaging-app,e4e09d3f4cca4f388678859353f22718,f02d2df157c63e17] 18250 --- [nio-8080-exec-1] o.s.web.servlet.DispatcherServlet        : Initializing Servlet 'dispatcherServlet'
2021-02-26 17:49:45.808  INFO [messaging-app,e4e09d3f4cca4f388678859353f22718,f02d2df157c63e17] 18250 --- [nio-8080-exec-1] o.s.web.servlet.DispatcherServlet        : Completed initialization in 1 ms
2021-02-26 17:49:45.930  INFO [messaging-app,872ee33c8d492df58c86a13e7a511fa6,c51d62b0e1120e8e] 18250 --- [nio-8080-exec-1] o.s.i.h.s.MessagingMethodInvokerHelper   : Overriding default instance of MessageHandlerMethodFactory with provided one.
2021-02-26 17:49:45.934  INFO [messaging-app,872ee33c8d492df58c86a13e7a511fa6,c51d62b0e1120e8e] 18250 --- [nio-8080-exec-1] c.e.m.m.service.SampleTransformer        : Received: GenericMessage [payload=Hello, headers={replyChannel=org.springframework.messaging.core.GenericMessagingTemplate$TemporaryReplyChannel@7026b05, b3=e4e09d3f4cca4f388678859353f22718-e23d1e8d09c576a4-0, nativeHeaders={}, errorChannel=org.springframework.messaging.core.GenericMessagingTemplate$TemporaryReplyChannel@7026b05, id=16b1d849-c5b8-8d3a-9e5f-ff77feb2b9e6, timestamp=1614390585928}]
```

**Observation:** 

with Otel Java angent:

Only http spans by java agent is generated. No sleuth spans

<img width="1677" alt="Screen Shot 2021-02-26 at 4 17 15 PM" src="https://user-images.githubusercontent.com/1302580/109368482-1cbf1880-784e-11eb-9573-e255bfee7095.png">


FYI:

with sleuth/otel more spans are generated.
![XA ENGLISH](https://user-images.githubusercontent.com/1302580/109368402-d36ec900-784d-11eb-8f6e-715e9322a423.png)

