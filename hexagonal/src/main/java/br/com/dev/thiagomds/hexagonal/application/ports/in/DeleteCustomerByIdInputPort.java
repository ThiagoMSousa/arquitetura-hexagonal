package br.com.dev.thiagomds.hexagonal.application.ports.in;

public interface DeleteCustomerByIdInputPort {

    void delete(String id);
}
