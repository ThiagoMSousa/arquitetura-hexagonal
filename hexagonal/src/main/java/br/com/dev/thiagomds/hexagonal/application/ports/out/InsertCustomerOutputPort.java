package br.com.dev.thiagomds.hexagonal.application.ports.out;

import br.com.dev.thiagomds.hexagonal.application.core.domain.Customer;

public interface InsertCustomerOutputPort {

    void insertCustomer(Customer customer);
}
