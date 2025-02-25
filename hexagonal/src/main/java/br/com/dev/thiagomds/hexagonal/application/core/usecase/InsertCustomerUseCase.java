package br.com.dev.thiagomds.hexagonal.application.core.usecase;

import br.com.dev.thiagomds.hexagonal.application.core.domain.Customer;
import br.com.dev.thiagomds.hexagonal.application.ports.out.FindAddressByZipCodeOutputPort;
import br.com.dev.thiagomds.hexagonal.application.ports.out.InsertCustomerOutputPort;

public class InsertCustomerUseCase {

    private final FindAddressByZipCodeOutputPort findAddressByZipCodeOutputPort;
    private final InsertCustomerOutputPort insertCustomerOutputPort;

    public InsertCustomerUseCase(FindAddressByZipCodeOutputPort findAddressByZipCodeOutputPort,
                                 InsertCustomerOutputPort insertCustomerOutputPort) {
        this.findAddressByZipCodeOutputPort = findAddressByZipCodeOutputPort;
        this.insertCustomerOutputPort = insertCustomerOutputPort;
    }

    public void insert(Customer customer, String zipCode) {
        var address = findAddressByZipCodeOutputPort.findAddress(zipCode);
        customer.setAddress(address);

        insertCustomerOutputPort.insertCustomer(customer);
    }
}
