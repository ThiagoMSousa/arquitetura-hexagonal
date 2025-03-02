package br.com.dev.thiagomds.hexagonal.application.ports.in;

import br.com.dev.thiagomds.hexagonal.application.core.domain.Customer;

public interface UpdateCustomerInputPort {

    void update(Customer customer, String zipCode);
}
