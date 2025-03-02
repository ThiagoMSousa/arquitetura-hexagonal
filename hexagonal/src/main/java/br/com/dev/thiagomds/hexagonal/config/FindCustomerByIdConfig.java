package br.com.dev.thiagomds.hexagonal.config;

import br.com.dev.thiagomds.hexagonal.adapters.out.FindCustomerByIdAdapter;
import br.com.dev.thiagomds.hexagonal.application.core.usecase.FindCustomerByIdUseCase;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class FindCustomerByIdConfig {

    @Bean
    public FindCustomerByIdUseCase findCustomerByIdUseCase(
            FindCustomerByIdAdapter findAddressByZipCodeAdapter
    ){
        return new FindCustomerByIdUseCase(findAddressByZipCodeAdapter);
    }
}
