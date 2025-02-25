package br.com.dev.thiagomds.hexagonal.application.ports.out;

import br.com.dev.thiagomds.hexagonal.application.core.domain.Address;

public interface FindAddressByZipCodeOutputPort {

    Address findAddress(String zipCode);
}
