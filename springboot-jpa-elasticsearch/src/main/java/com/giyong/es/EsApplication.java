package com.giyong.es;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

import javax.annotation.PostConstruct;
import java.time.ZoneId;
import java.util.Date;
import java.util.TimeZone;

@EntityScan(basePackages = {"com.giyong.es.domain.entity"})
@EnableJpaRepositories(basePackages =  {"com.giyong.es.domain.entity"})
@SpringBootApplication
public class EsApplication {

	public static void main(String[] args) {
		SpringApplication.run(EsApplication.class, args);
	}

	@PostConstruct
	public void started() {
		System.out.println("현재시각: " + new Date());
		TimeZone.setDefault(TimeZone.getTimeZone(ZoneId.of("Asia/Seoul")));
		System.out.println("현재시각: " + new Date());
	}
}
