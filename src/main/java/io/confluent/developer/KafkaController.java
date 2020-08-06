package io.confluent.developer;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import lombok.RequiredArgsConstructor;

@RestController
@RequestMapping(value = "/user")  
@RequiredArgsConstructor
public class KafkaController {

	@Autowired
  private Producer producer;  

 /*@PostMapping(value = "/publish") 
  public void sendMessageToKafkaTopic(@RequestParam("name") String name,
                                      @RequestParam("age") Integer age ,@RequestBody User user) {
	  System.out.println(user.getAge());
    this.producer.sendMessage(new User(name, age));
  }
	*/
	 @GetMapping("/employees/{name}/{age}")
	    public String producerAvroMessage(@PathVariable String name, @PathVariable int age) {
		this.producer.sendMessage(new User(name,age));
	        return "Sent employee details to consumer";
	    }
	
	
}