package ma.kafka.demo.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import ma.kafka.demo.entity.Produit;
import ma.kafka.demo.producer.KafkaProducer;

@RequestMapping("/api/kafka")
@RestController
public class KafkaController {

	@Autowired
	private KafkaProducer kafkaProducer;

	@GetMapping(value = "/send")
	public String sendMessageToKafka(@RequestParam(name = "message") String message) {
		
		kafkaProducer.SendMessage(message);
		
		return "Message send successfully";
	}
	
	
	@PostMapping(value = "/send/json")
	public String sendMessageJsonToKafka(@RequestBody Produit produit) {
		
		kafkaProducer.SendMessageJson(produit);
		
		return "Message send successfully";
	}

}
