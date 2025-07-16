package com.springboot.kafka.producer;

import java.time.LocalDateTime;

import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

@Component
public class KafkaProducer {

	private final KafkaTemplate<String, String> kafkaTemplate;
	private final String TOPIC_NAME = "test-topic";

	public KafkaProducer(KafkaTemplate<String, String> kafkaTemplate) {
		this.kafkaTemplate = kafkaTemplate;
	}

	@Scheduled(fixedDelay = 5000)
	public void sendCurrentDataTime() {
		LocalDateTime dt = LocalDateTime.now();
		kafkaTemplate.send(TOPIC_NAME, dt.toString());
		System.out.println("Kafka Producer sent: " + dt.toString());
	}
}
