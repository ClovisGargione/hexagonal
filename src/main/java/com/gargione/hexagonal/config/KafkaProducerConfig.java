package com.gargione.hexagonal.config;

import java.util.HashMap;
import java.util.Map;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.kafka.core.DefaultKafkaProducerFactory;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.kafka.core.ProducerFactory;

import com.fasterxml.jackson.databind.ser.std.StringSerializer;

import static org.apache.kafka.clients.producer.ProducerConfig.BOOTSTRAP_SERVERS_CONFIG;
import static org.apache.kafka.clients.consumer.ConsumerConfig.GROUP_ID_CONFIG;
import static org.apache.kafka.clients.producer.ProducerConfig.KEY_SERIALIZER_CLASS_CONFIG;
import static org.apache.kafka.clients.producer.ProducerConfig.VALUE_SERIALIZER_CLASS_CONFIG;

@Configuration
public class KafkaProducerConfig {

    @Bean
    ProducerFactory<String, String> producerFactory(){
	Map<String, Object> configProps = new HashMap<>();
	configProps.put(BOOTSTRAP_SERVERS_CONFIG, "localhost:9092");
	configProps.put(GROUP_ID_CONFIG, "gargione");
	configProps.put(KEY_SERIALIZER_CLASS_CONFIG, StringSerializer.class);
	configProps.put(VALUE_SERIALIZER_CLASS_CONFIG, StringSerializer.class);
	return new DefaultKafkaProducerFactory<>(configProps);
    }
    
    @Bean
    KafkaTemplate<String, String> kaskaTemplate(){
	return new KafkaTemplate<>(producerFactory());
    }
}
