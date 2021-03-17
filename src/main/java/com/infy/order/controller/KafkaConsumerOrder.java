package com.infy.order.controller;

import java.net.URISyntaxException;
import java.util.Arrays;
//import org.apache.kafka.clients.consumer.KafkaConsumer;
import java.util.Properties;

import org.apache.kafka.clients.consumer.ConsumerRecord;
import org.apache.kafka.clients.consumer.ConsumerRecords;
import org.apache.kafka.clients.consumer.KafkaConsumer;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonMappingException;

@SpringBootApplication
@RestController
public class KafkaConsumerOrder {
	private static KafkaConsumer<String, String> consumer;
	@RequestMapping("/")
	@SuppressWarnings("deprecation")
	public static void main1(String[] args) throws JsonMappingException, JsonProcessingException, URISyntaxException {
	    	Properties props = new Properties();
	        props.put("bootstrap.servers", "localhost:9092");
	        props.put("group.id", "test-consumer-group");
	        props.put("enable.auto.commit", "false");
	        props.put("auto.offset.reset","earliest");
	        props.put("key.deserializer", "org.apache.kafka.common.serialization.StringDeserializer");
	        props.put("value.deserializer", "org.apache.kafka.common.serialization.StringDeserializer");
	        consumer = new KafkaConsumer<>(props);
	        consumer.subscribe(Arrays.asList("javatechie"));
//	        RestTemplate restTemplate = new RestTemplate();
//		    final String baseUrl = "http://notification:9007/sendAccountCreatednotification";
//		    URI uri = new URI(baseUrl);

	        	
	        while (true) {
				ConsumerRecords<String, String> records = consumer.poll(100);
	            for (ConsumerRecord<String, String> record : records)
	            {
	            	String c=record.value();
	            	System.out.println(c);
	            }
	        }
	        
	}
	 
	    
	public static void main(String[] args) {
		SpringApplication.run(KafkaConsumerOrder.class, args);
	}
	
	

}
