package com.allen.transactionmessageservice;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

@EnableDiscoveryClient
@SpringBootApplication
public class TransactionMessageService {

	public static void main(String[] args) {

		SpringApplication.run(TransactionMessageService.class, args);
	}
}
