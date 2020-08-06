package io.confluent.developer;

import org.apache.kafka.clients.consumer.ConsumerRecord;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.cloud.stream.annotation.StreamListener;
import org.springframework.cloud.stream.messaging.Processor;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.messaging.handler.annotation.Header;
import org.springframework.messaging.handler.annotation.Payload;
import org.springframework.stereotype.Service;


import lombok.extern.apachecommons.CommonsLog;

@Service
@CommonsLog(topic = "Consumer Logger")
public class Consumer {

  @KafkaListener(   
      topics = "#{'${topic.name}'}", groupId = "#{'${spring.kafka.consumer.group-id}'}")
  
  public void consume(ConsumerRecord<String,User> record) {
    //log.info(String.format("Consumed message -> %s", record));
    System.out.println(String.format("Consumed message -> %s", record));
  }
}
/*


    private static final Logger LOGGER = LoggerFactory.getLogger(Consumer.class);

    @KafkaListener(topics = "${kafka.topic.name}", groupId = "${kafka.consumer.group.id}")
    public void recieveData(@Payload User user, @Header(KafkaHeaders.MESSAGE_KEY) String messageKey) throws Exception{
        LOGGER.info("Data - " + user + " recieved");
    }
}*/