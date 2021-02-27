package com.example.messaging.messagingspringsleuth;

import com.example.messaging.messagingspringsleuth.service.SampleRequestResponse;
import com.example.messaging.messagingspringsleuth.service.SampleSink;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.integration.annotation.IntegrationComponentScan;
import org.springframework.scheduling.annotation.EnableAsync;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

@SpringBootApplication
@EnableAsync
@IntegrationComponentScan
@RestController
public class MessagingSpringSleuthApplication {

	private static final Log log = LogFactory.getLog(MessagingSpringSleuthApplication.class);

	@Autowired
	private SampleSink gateway;

	@Autowired
	private SampleRequestResponse transformer;

	public static void main(String[] args) {
		SpringApplication.run(MessagingSpringSleuthApplication.class, args);
	}

	@RequestMapping("/")
	public String home() {
		log.info("Got request");
		String msg = "Hello";
		this.gateway.send(msg);
		return msg;
	}

	@RequestMapping("/foo")
	public String foo() {
		return "foo";
	}

	@RequestMapping("/xform")
	public String xform() {
		String msg = "Hello";
		return this.transformer.send(msg);
	}

	@Bean
	public RestTemplate restTemplate() {
		return new RestTemplate();
	}

}
