package br.com.dev.thiagomds.hexagonal.adapters.in.controller.response;

import lombok.Data;

@Data
public class CustomerResponse {

    private String name;
    private AddressResponse addres;
    private String cpf;
    private Boolean isValidCpf;

}
