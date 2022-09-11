package ma.kafka.demo.producer;

import org.springframework.messaging.Message;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.annotation.KafkaHandler;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.kafka.support.KafkaHeaders;
import org.springframework.messaging.support.MessageBuilder;
import org.springframework.stereotype.Service;

import ma.kafka.demo.entity.Produit;

@Service
public class KafkaProducer {

	private static final Logger LOGGER = LoggerFactory.getLogger(KafkaProducer.class);

	@Autowired
	private KafkaTemplate<String, String> kafkaTemplate;

	@Autowired
	private KafkaTemplate<String, Produit> kafkaTemplateJson;

	public void SendMessage(String message) {
		LOGGER.info(String.format("Message sent %s", message));
		kafkaTemplate.send("myFirstTopic", message);
	}

	public void SendMessageJson(Produit produit) {
		LOGGER.info(String.format("Produit entity send-  %s", produit));

		Message<Produit> message = MessageBuilder.withPayload(produit).setHeader(KafkaHeaders.TOPIC, "myLastTopic").build();
		kafkaTemplateJson.send(message);
	}

}
