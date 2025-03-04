package br.com.dev.thiagomds.hexagonal.adapters.in.consumer;

import br.com.dev.thiagomds.hexagonal.adapters.in.consumer.mapper.CustomerMessageMapper;
import br.com.dev.thiagomds.hexagonal.adapters.in.consumer.message.CustomerMessage;
import br.com.dev.thiagomds.hexagonal.application.ports.in.UpdateCustomerInputPort;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Component;

@Component
public class ReceiveValidatedCpfConsumer {

    @Autowired
    private UpdateCustomerInputPort updateCustomerInputPort;

    @Autowired
    private CustomerMessageMapper customerMessageMapper;

    @KafkaListener(topics = "tp-cpf-validated", groupId = "thiagomds")
    public void receive(CustomerMessage customerMessage){
        var customer = customerMessageMapper.toCustomer(customerMessage);
        updateCustomerInputPort.update(customer, customerMessage.getZipCode());
    }

}
