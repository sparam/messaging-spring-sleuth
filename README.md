# Getting Started
  
1. mvn clean install
2. start zipkin server on your local
3. run below command

`java -javaagent:opentelemetry-javaagent-all.jar -Dotel.exporter=zipkin -Dotel.exporter.zipkin.service.name=sleuth-application-otel-agent -Dotel.exporter.zipkin.endpoint=http://127.0.0.1:9411/api/v2/spans -jar target/messaging-spring-sleuth-0.0.1-SNAPSHOT.jar`

4. go to browser and hit url http://localhost:8080/xform
5. search for trace here http://localhost:9411/zipkin/

**Observation:** Only http spans by java agent is generated. No sleuth spans

