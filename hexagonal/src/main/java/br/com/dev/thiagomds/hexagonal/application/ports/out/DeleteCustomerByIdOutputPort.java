package br.com.dev.thiagomds.hexagonal.application.ports.out;

public interface DeleteCustomerByIdOutputPort {

    void delete(String id);
}
