package com.gargione.hexagonal.config;

import static org.apache.kafka.clients.consumer.ConsumerConfig.AUTO_OFFSET_RESET_CONFIG;
import static org.apache.kafka.clients.consumer.ConsumerConfig.GROUP_ID_CONFIG;
import static org.apache.kafka.clients.consumer.ConsumerConfig.KEY_DESERIALIZER_CLASS_CONFIG;
import static org.apache.kafka.clients.consumer.ConsumerConfig.VALUE_DESERIALIZER_CLASS_CONFIG;
import static org.apache.kafka.clients.producer.ProducerConfig.BOOTSTRAP_SERVERS_CONFIG;

import java.util.HashMap;
import java.util.Map;

import org.apache.kafka.common.serialization.StringDeserializer;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.kafka.annotation.EnableKafka;
import org.springframework.kafka.config.ConcurrentKafkaListenerContainerFactory;
import org.springframework.kafka.core.ConsumerFactory;
import org.springframework.kafka.core.DefaultKafkaConsumerFactory;
import org.springframework.kafka.support.serializer.JsonDeserializer;

import com.gargione.hexagonal.adapters.in.consumer.message.CustomerMessage;

@EnableKafka
@Configuration
public class KafkaConsumerConfig {

    @Bean
    ConsumerFactory<String, CustomerMessage> consumerFactory(){
	Map<String, Object> configProps = new HashMap<>();
	configProps.put(BOOTSTRAP_SERVERS_CONFIG, "localhost:9092");
	configProps.put(GROUP_ID_CONFIG, "gargione");
	configProps.put(KEY_DESERIALIZER_CLASS_CONFIG, StringDeserializer.class);
	configProps.put(VALUE_DESERIALIZER_CLASS_CONFIG, JsonDeserializer.class);
	configProps.put(AUTO_OFFSET_RESET_CONFIG, "earliest");
	return new DefaultKafkaConsumerFactory<>(configProps, new StringDeserializer(), new JsonDeserializer<>(CustomerMessage.class));
    }
    
    @Bean
    ConcurrentKafkaListenerContainerFactory<String, CustomerMessage> kafkaListenerContainerFactory(){
	ConcurrentKafkaListenerContainerFactory<String, CustomerMessage> factory = new ConcurrentKafkaListenerContainerFactory<String, CustomerMessage>();
	factory.setConsumerFactory(consumerFactory());
	return factory;
    }
}
