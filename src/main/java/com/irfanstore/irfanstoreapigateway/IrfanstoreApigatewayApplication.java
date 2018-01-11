package com.irfanstore.irfanstoreapigateway;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.netflix.zuul.EnableZuulProxy;
import org.springframework.cloud.sleuth.sampler.AlwaysSampler;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
@EnableDiscoveryClient
@EnableZuulProxy
public class IrfanstoreApigatewayApplication {

	public static void main(String[] args) {
		SpringApplication.run(IrfanstoreApigatewayApplication.class, args);
	}

	//Capturing all the traces. Can customize what we want to trace.
	@Bean
	public AlwaysSampler defaultSampler() {
		return new AlwaysSampler();
	}

}


/*
To route the call through API Gateway use the following URL convention:
http://<<api gateway URL>>/<<service name>>/<<service URL>>
For example:
http://irfanstore-apigateway.cfapps.io/product-service/api/product

More on the Zuul Gateway see below link:
https://cloud.spring.io/spring-cloud-netflix/multi/multi__router_and_filter_zuul.html
 */