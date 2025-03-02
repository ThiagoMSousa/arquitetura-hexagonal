package br.com.dev.thiagomds.hexagonal.adapters.out;

import br.com.dev.thiagomds.hexagonal.adapters.out.repository.CustomerRepository;
import br.com.dev.thiagomds.hexagonal.adapters.out.repository.mapper.CustomerEntityMapper;
import br.com.dev.thiagomds.hexagonal.application.core.domain.Customer;
import br.com.dev.thiagomds.hexagonal.application.ports.out.UpdateCustomerOutputPort;
import org.springframework.beans.factory.annotation.Autowired;

public class UpdateCustomerAdapter implements UpdateCustomerOutputPort {

    @Autowired
    private CustomerRepository customerRepository;

    @Autowired
    private     CustomerEntityMapper customerEntityMapper;

    @Override
    public void update(Customer customer){
        var customerEntity = customerEntityMapper.toCustomerEntity(customer);
        customerRepository.save(customerEntity);
    }
}
