package br.com.dev.thiagomds.hexagonal.adapters.out.client;

import br.com.dev.thiagomds.hexagonal.adapters.out.client.mapper.AddressResponseMapper;
import br.com.dev.thiagomds.hexagonal.application.core.domain.Address;
import br.com.dev.thiagomds.hexagonal.application.ports.out.FindAddressByZipCodeOutputPort;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class FindAddressByZipCodeAdapter implements FindAddressByZipCodeOutputPort {

    @Autowired
    private FindAddressByZipCodeClient findAddressByZipCodeClient;

    @Autowired
    private AddressResponseMapper addressResponseMapper;

    @Override
    public Address findAddress(String zipCode) {
        var addressResponse = findAddressByZipCodeClient.findAddress(zipCode);
        return addressResponseMapper.toADdress(addressResponse);
    }
}
