package br.com.dev.thiagomds.hexagonal.application.core.usecase;

import br.com.dev.thiagomds.hexagonal.application.core.domain.Customer;
import br.com.dev.thiagomds.hexagonal.application.ports.in.InsertCustomerInputPort;
import br.com.dev.thiagomds.hexagonal.application.ports.out.FindAddressByZipCodeOutputPort;
import br.com.dev.thiagomds.hexagonal.application.ports.out.InsertCustomerOutputPort;
import br.com.dev.thiagomds.hexagonal.application.ports.out.SendCpfForValidationOutputPort;

public class InsertCustomerUseCase implements InsertCustomerInputPort {

    private final FindAddressByZipCodeOutputPort findAddressByZipCodeOutputPort;
    private final InsertCustomerOutputPort insertCustomerOutputPort;
    private final SendCpfForValidationOutputPort sendCpfForValidationOutputPort;

    public InsertCustomerUseCase(FindAddressByZipCodeOutputPort findAddressByZipCodeOutputPort,
                                 InsertCustomerOutputPort insertCustomerOutputPort,
                                 SendCpfForValidationOutputPort sendCpfForValidationOutputPort) {
        this.findAddressByZipCodeOutputPort = findAddressByZipCodeOutputPort;
        this.insertCustomerOutputPort = insertCustomerOutputPort;
        this.sendCpfForValidationOutputPort = sendCpfForValidationOutputPort;
    }

    @Override
    public void insertCustomer(Customer customer, String zipCode) {
        var address = findAddressByZipCodeOutputPort.findAddress(zipCode);
        customer.setAddress(address);
        insertCustomerOutputPort.insertCustomer(customer);
        sendCpfForValidationOutputPort.send(customer.getCpf());
    }
}
