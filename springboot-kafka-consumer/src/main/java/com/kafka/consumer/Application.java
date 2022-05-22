package com.kafka.consumer;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;

import javax.annotation.PostConstruct;
import java.time.ZoneId;
import java.util.TimeZone;

@EnableFeignClients
@SpringBootApplication
public class Application {

	@PostConstruct
	public void init() {
		TimeZone.setDefault(TimeZone.getTimeZone(ZoneId.of("Asia/Seoul")));
	}

	public static void main(String[] args) {
		SpringApplication.run(Application.class, args);
	}

}
