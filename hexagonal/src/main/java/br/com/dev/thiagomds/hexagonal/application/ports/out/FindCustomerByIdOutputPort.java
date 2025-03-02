package br.com.dev.thiagomds.hexagonal.application.ports.out;

import br.com.dev.thiagomds.hexagonal.application.core.domain.Customer;
import br.com.dev.thiagomds.hexagonal.application.core.usecase.FindCustomerByIdUseCase;

import java.util.Optional;

public interface FindCustomerByIdOutputPort {

    Optional<Customer> find(String id);
}
