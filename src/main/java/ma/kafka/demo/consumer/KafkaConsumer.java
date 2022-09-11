package ma.kafka.demo.consumer;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Service;

import ma.kafka.demo.entity.Produit;

@Service
public class KafkaConsumer {
	
	private static final Logger LOGGER = LoggerFactory.getLogger(KafkaConsumer.class);
	
	@KafkaListener(topics = "myFirstTopic", groupId = "myGroup")
	public void consumer(String message) {
		LOGGER.info(String.format("Message received %s", message));
	}
	
	
	
	@KafkaListener(topics = "myLastTopic", groupId = "myGroup")
	public void consumerJson(Produit produit) {
		LOGGER.info(String.format("Message received %s", produit));
	}

}
