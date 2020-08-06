package io.confluent.developer;

import javax.annotation.processing.Processor;

import org.apache.kafka.clients.admin.NewTopic;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.stream.annotation.EnableBinding;
import org.springframework.context.annotation.Bean;
@EnableBinding(Processor.class)
@SpringBootApplication
public class KafkaApiApplication {

	@Value("${topic.name}")  
	  private String topicName;

	  @Value("${topic.partitions-num}")
	  private Integer partitions;

	  @Value("${topic.replication-factor}")
	  private short replicationFactor;

	  @Bean
	  NewTopic newTopic() {  
	    return new NewTopic(topicName, partitions, replicationFactor);
	  }
	public static void main(String[] args) {
		SpringApplication.run(KafkaApiApplication.class, args);
	}

}
