package br.com.dev.thiagomds.hexagonal.adapters.in.controller;

import br.com.dev.thiagomds.hexagonal.adapters.in.controller.mapper.CustomerMapper;
import br.com.dev.thiagomds.hexagonal.adapters.in.controller.request.CustomerRequest;
import br.com.dev.thiagomds.hexagonal.application.ports.in.InsertCustomerInputPort;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/v1/customers")
public class CustomerController {

    @Autowired
    private InsertCustomerInputPort insertCustomerInputPort;

    @Autowired
    private CustomerMapper customerMapper;

    @PostMapping
    public ResponseEntity<Void> insert(@RequestBody CustomerRequest customerRequest) {
        var customer = customerMapper.toCustomer(customerRequest);
        insertCustomerInputPort.insertCustomer(customer, customerRequest.getZipCode());
        return ResponseEntity.ok().build();
    }

}
