package br.com.dev.thiagomds.hexagonal.application.ports.in;

import br.com.dev.thiagomds.hexagonal.application.core.domain.Customer;

public interface FindCustomerByIdInputPort {

    Customer find(String id);

}
