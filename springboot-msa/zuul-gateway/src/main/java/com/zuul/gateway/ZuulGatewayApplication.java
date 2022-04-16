package com.zuul.gateway;

import com.zuul.gateway.filters.GatewayErrorFilter;
import com.zuul.gateway.filters.GatewayPostFilter;
import com.zuul.gateway.filters.GatewayPreFilter;
import com.zuul.gateway.filters.GatewayRouteFilter;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.netflix.zuul.EnableZuulProxy;
import org.springframework.context.annotation.Bean;

@EnableDiscoveryClient
@EnableZuulProxy
@SpringBootApplication
public class ZuulGatewayApplication {

	public static void main(String[] args) {
		SpringApplication.run(ZuulGatewayApplication.class, args);
	}

	@Bean
	public GatewayPreFilter preFilter() {
		return new GatewayPreFilter();
	}

	@Bean
	public GatewayPostFilter postFilter() {
		return new GatewayPostFilter();
	}

	@Bean
	public GatewayRouteFilter routeFilter() {
		return new GatewayRouteFilter();
	}

	@Bean
	public GatewayErrorFilter errorFilter() {
		return new GatewayErrorFilter();
	}
}
