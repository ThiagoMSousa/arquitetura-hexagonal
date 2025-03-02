package br.com.dev.thiagomds.hexagonal.adapters.in.controller.mapper;


import br.com.dev.thiagomds.hexagonal.adapters.in.controller.request.CustomerRequest;
import br.com.dev.thiagomds.hexagonal.adapters.in.controller.response.CustomerResponse;
import br.com.dev.thiagomds.hexagonal.application.core.domain.Customer;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper(componentModel = "spring")
public interface CustomerMapper {

    @Mapping(target = "id", ignore = true)
    @Mapping(target = "address", ignore = true)
    @Mapping(target = "isValid", ignore = true)
    Customer toCustomer(CustomerRequest customerRequest);

    CustomerResponse toCustomerResponse(Customer customer);

}
