package br.com.dev.thiagomds.hexagonal.adapters.in.controller;

import br.com.dev.thiagomds.hexagonal.adapters.in.controller.mapper.CustomerMapper;
import br.com.dev.thiagomds.hexagonal.adapters.in.controller.request.CustomerRequest;
import br.com.dev.thiagomds.hexagonal.adapters.in.controller.response.CustomerResponse;
import br.com.dev.thiagomds.hexagonal.application.ports.in.FindCustomerByIdInputPort;
import br.com.dev.thiagomds.hexagonal.application.ports.in.InsertCustomerInputPort;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/v1/customers")
public class CustomerController {

    @Autowired
    private InsertCustomerInputPort insertCustomerInputPort;

    @Autowired
    private CustomerMapper customerMapper;

    @Autowired
    FindCustomerByIdInputPort findCustomerByIdInputPort;

    @PostMapping
    public ResponseEntity<Void> insert(@RequestBody CustomerRequest customerRequest) {
        var customer = customerMapper.toCustomer(customerRequest);
        insertCustomerInputPort.insertCustomer(customer, customerRequest.getZipCode());
        return ResponseEntity.ok().build();
    }

    @GetMapping("/{id}")
    public ResponseEntity<CustomerResponse> find(@PathVariable String id) {
        var customer = findCustomerByIdInputPort.find(id);
        var customerResponse = customerMapper.toCustomerResponse(customer);
        return ResponseEntity.ok().body(customerResponse);
    }

}
