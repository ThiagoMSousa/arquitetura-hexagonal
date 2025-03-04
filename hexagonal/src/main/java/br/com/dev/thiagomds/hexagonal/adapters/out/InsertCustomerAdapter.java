package br.com.dev.thiagomds.hexagonal.adapters.out;

import br.com.dev.thiagomds.hexagonal.adapters.out.repository.CustomerRepository;
import br.com.dev.thiagomds.hexagonal.adapters.out.repository.mapper.CustomerEntityMapper;
import br.com.dev.thiagomds.hexagonal.application.core.domain.Customer;
import br.com.dev.thiagomds.hexagonal.application.ports.out.InsertCustomerOutputPort;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class InsertCustomerAdapter implements InsertCustomerOutputPort {

    @Autowired
    private CustomerRepository customerRepository;

    @Autowired
    private CustomerEntityMapper customerEntityMapper;

    @Override
    public void insertCustomer(Customer customer) {
        var customerEntity = customerEntityMapper.toCustomerEntity(customer);
        customerRepository.save(customerEntity);
    }
}
