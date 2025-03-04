package br.com.dev.thiagomds.hexagonal.config;

import br.com.dev.thiagomds.hexagonal.adapters.out.FindAddressByZipCodeAdapter;
import br.com.dev.thiagomds.hexagonal.adapters.out.InsertCustomerAdapter;
import br.com.dev.thiagomds.hexagonal.adapters.out.SendCpfValidationAdapter;
import br.com.dev.thiagomds.hexagonal.application.core.usecase.InsertCustomerUseCase;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class InsertCustomerConfig {

    @Bean
    public InsertCustomerUseCase insertCustomerUseCase(
            FindAddressByZipCodeAdapter findAddressByZipCodeAdapter,
            InsertCustomerAdapter insertCustomerAdapter,
            SendCpfValidationAdapter sendCpfValidationAdapter
    ){
        return new InsertCustomerUseCase(findAddressByZipCodeAdapter,
                insertCustomerAdapter,
                sendCpfValidationAdapter);
    }
}
