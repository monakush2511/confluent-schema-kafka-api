package io.confluent.developer;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Service;

import lombok.RequiredArgsConstructor;
import lombok.extern.apachecommons.CommonsLog;

@Service
@CommonsLog(topic = "Producer Logger")
@RequiredArgsConstructor
public class Producer {

  @Value("${topic.name}") 
  private String TOPIC;

  @Autowired
  private KafkaTemplate<String, User> kafkaTemplate;

public void sendMessage(User user) {
	{ 
		this.kafkaTemplate.send(this.TOPIC,user);
	  System.out.println("Produced user -> %s" +user);
	  
	  }
	
}

	/*
	 * void sendMessage(User user) { this.kafkaTemplate.send(this.TOPIC,user);
	 * System.out.println("Produced user -> %s" +user);
	 * 
	 * }
	 */
  
}