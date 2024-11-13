package com.gargione.hexagonal.adapters.out;

import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Component;

import com.gargione.hexagonal.application.ports.out.SendCpfForValidationOutputPort;

@Component
public class SendCpfValidationAdapter implements SendCpfForValidationOutputPort{

    private KafkaTemplate<String, String> kafkaTemplate;
    
    
    public SendCpfValidationAdapter(KafkaTemplate<String, String> kafkaTemplate) {
	super();
	this.kafkaTemplate = kafkaTemplate;
    }



    @Override
    public void send(String cpf) {
	kafkaTemplate.send("tp-cpf-validation", cpf);
    }

}
