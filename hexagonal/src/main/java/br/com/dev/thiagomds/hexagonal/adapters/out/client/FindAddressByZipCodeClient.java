package br.com.dev.thiagomds.hexagonal.adapters.out.client;

import br.com.dev.thiagomds.hexagonal.adapters.out.client.response.AddressResponse;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@FeignClient(
        name = "FindAddressByZipCodeClient",
        url  = "${spring.application.client-http.address.url}"
)
public interface FindAddressByZipCodeClient {

    @GetMapping("/{zipCode}")
    AddressResponse findAddress(@PathVariable("zipCode") String zipCode);

}
