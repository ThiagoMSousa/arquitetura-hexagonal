package br.com.dev.thiagomds.hexagonal.application.ports.in;

import br.com.dev.thiagomds.hexagonal.application.core.domain.Customer;

public interface InsertCustomerInputPort {

    void insertCustomer(Customer customer, String zipCode);

}
