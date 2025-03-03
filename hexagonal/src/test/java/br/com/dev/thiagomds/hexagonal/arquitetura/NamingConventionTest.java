package br.com.dev.thiagomds.hexagonal.arquitetura;

import com.tngtech.archunit.junit.AnalyzeClasses;
import com.tngtech.archunit.junit.ArchTest;
import com.tngtech.archunit.lang.ArchRule;

import static com.tngtech.archunit.lang.syntax.ArchRuleDefinition.classes;

@AnalyzeClasses(packages = "br.com.dev.thiagomds.hexagonal")
public class NamingConventionTest {

    /**
     * Este teste do ArchUnit garante que as classes com o sufixo "Consumer" residam
     * apenas no pacote "..adapters.in.consumer".
     */
    @ArchTest
    public static final ArchRule consumer_reside_only_consumer_packages = classes()
            .that()
            .haveNameMatching(".*Consumer")
            .should()
            .resideInAPackage("..adapters.in.consumer")
            .as("Consumer classes reside inside consumer package adapters.in package");

    /**
     * Este teste do ArchUnit garante que as classes com o sufixo "Mapper" residam
     * apenas nos pacotes "..adapters.in.consumer.mapper", "..adapters.in.controller.mapper",
     * "..adapters.out.client.mapper" ou "..adapters.out.repository.mapper".
     */
    @ArchTest
    public static final ArchRule mapper_reside_only_mapper_packages = classes()
            .that()
            .haveNameMatching(".*Mapper")
            .should()
            .resideInAnyPackage("..adapters.in.consumer.mapper",
                    "..adapters.in.controller.mapper",
                    "..adapters.out.client.mapper",
                    "..adapters.out.repository.mapper")
            .as("Mapper classes should reside inside mapper package in controller, client, consumer or repository packages");

    /**
     * Este teste do ArchUnit garante que as classes com o sufixo "Message" residam
     * apenas no pacote "..adapters.in.consumer.message".
     */
    @ArchTest
    public static final ArchRule message_reside_only_message_package = classes()
            .that()
            .haveNameMatching(".*Message")
            .should()
            .resideInAPackage("..adapters.in.consumer.message")
            .as("Message classes should reside inside message package in consumer package");

    /**
     * Este teste do ArchUnit garante que as classes com o sufixo "Controller" residam
     * apenas no pacote "..adapters.in.controller".
     */
    @ArchTest
    public static final ArchRule controller_reside_only_controller_package = classes()
            .that()
            .haveNameMatching(".*Controller")
            .should()
            .resideInAPackage("..adapters.in.controller")
            .as("Controller classes should reside inside controller package in adapters.in package");

    /**
     * Este teste do ArchUnit garante que as classes com o sufixo "Request" residam
     * apenas nos pacotes "..adapters.in.controller.request" ou "..adapters.out.client.request".
     */
    @ArchTest
    public static final ArchRule request_reside_only_request_package = classes()
            .that()
            .haveNameMatching(".*Request")
            .should()
            .resideInAnyPackage("..adapters.in.controller.request", "..adapters.out.client.request")
            .as("Request classes should reside inside request package in controller or client packages");

    /**
     * Este teste do ArchUnit garante que as classes com o sufixo "Response" residam
     * apenas nos pacotes "..adapters.in.controller.response" ou "..adapters.out.client.response".
     */
    @ArchTest
    public static final ArchRule response_reside_only_response_package = classes()
            .that()
            .haveNameMatching(".*Response")
            .should()
            .resideInAnyPackage("..adapters.in.controller.response", "..adapters.out.client.response")
            .as("Response classes should reside inside response package in controller or client packages");

    /**
     * Este teste do ArchUnit garante que as classes com o sufixo "Adapter" residam
     * apenas no pacote "..adapters.out".
     */
    @ArchTest
    public static final ArchRule adapter_reside_only_adapter_package = classes()
            .that()
            .haveNameMatching(".*Adapter")
            .should()
            .resideInAPackage("..adapters.out")
            .as("Adapter classes should reside inside out package in adapters package");

    /**
     * Este teste do ArchUnit garante que as classes com o sufixo "Client" residam
     * apenas no pacote "..adapters.out.client".
     */
    @ArchTest
    public static final ArchRule client_reside_only_client_package = classes()
            .that()
            .haveNameMatching(".*Client")
            .should()
            .resideInAPackage("..adapters.out.client")
            .as("Client classes should reside inside client package in adapters.out package");

    /**
     * Este teste do ArchUnit garante que as classes com o sufixo "Repository" residam
     * apenas no pacote "..adapters.out.repository".
     */
    @ArchTest
    public static final ArchRule repository_reside_only_repository_package = classes()
            .that()
            .haveNameMatching(".*Repository")
            .should()
            .resideInAPackage("..adapters.out.repository")
            .as("Repository classes should reside inside repository package in adapters.out package");

    /**
     * Este teste do ArchUnit garante que as classes com o sufixo "Entity" residam
     * apenas no pacote "..adapters.out.repository.entity".
     */
    @ArchTest
    public static final ArchRule entity_reside_only_entity_package = classes()
            .that()
            .haveNameMatching(".*Entity")
            .should()
            .resideInAPackage("..adapters.out.repository.entity")
            .as("Entity classes should reside inside entity package in entity package");

    /**
     * Este teste do ArchUnit garante que as classes com o sufixo "UseCase" residam
     * apenas no pacote "..application.core.usecase".
     */
    @ArchTest
    public static final ArchRule usecase_reside_only_usecase_package = classes()
            .that()
            .haveNameMatching(".*UseCase")
            .should()
            .resideInAPackage("..application.core.usecase")
            .as("Usecase classes should reside inside usecase package in core package");

    /**
     * Este teste do ArchUnit garante que as classes com o sufixo "InputPort" residam
     * apenas no pacote "..application.ports.in".
     */
    @ArchTest
    public static final ArchRule input_reside_only_input_package = classes()
            .that()
            .haveNameMatching(".*InputPort")
            .should()
            .resideInAPackage("..application.ports.in")
            .as("InputPort classes should reside inside ports.in package in application package");

    /**
     * Este teste do ArchUnit garante que as classes com o sufixo "OutputPort" residam
     * apenas no pacote "..application.ports.out".
     */
    @ArchTest
    public static final ArchRule output_reside_only_output_package = classes()
            .that()
            .haveNameMatching(".*OutputPort")
            .should()
            .resideInAPackage("..application.ports.out")
            .as("OutputPort classes should reside inside ports.out package in application package");

    /**
     * Este teste do ArchUnit garante que as classes com o sufixo "Config" residam
     * apenas no pacote "..hexagonal.config".
     */
    @ArchTest
    public static final ArchRule config_reside_only_config_package = classes()
            .that()
            .haveNameMatching(".*Config")
            .should()
            .resideInAPackage("..hexagonal.config")
            .as("Config classes should reside inside config package in hexagonal package");

    /**
     * Este teste do ArchUnit garante que as classes no pacote "..consumer" tenham
     * o sufixo "Consumer".
     */
    @ArchTest
    public static final ArchRule should_be_suffixed_consumer = classes()
            .that()
            .resideInAPackage("..consumer")
            .should()
            .haveSimpleNameEndingWith("Consumer");

    /**
     * Este teste do ArchUnit garante que as classes no pacote "..mapper" tenham
     * o sufixo "Mapper" ou "MapperImpl".
     */
    @ArchTest
    public static final ArchRule should_be_suffixed_mapper = classes()
            .that()
            .resideInAPackage("..mapper")
            .should()
            .haveSimpleNameEndingWith("Mapper")
            .orShould()
            .haveSimpleNameEndingWith("MapperImpl");

    /**
     * Este teste do ArchUnit garante que as classes no pacote "..message" tenham
     * o sufixo "Message".
     */
    @ArchTest
    public static final ArchRule should_be_suffixed_message = classes()
            .that()
            .resideInAPackage("..message")
            .should()
            .haveSimpleNameEndingWith("Message");

    /**
     * Este teste do ArchUnit garante que as classes no pacote "..controller" tenham
     * o sufixo "Controller".
     */
    @ArchTest
    public static final ArchRule should_be_suffixed_controller = classes()
            .that()
            .resideInAPackage("..controller")
            .should()
            .haveSimpleNameEndingWith("Controller");

    /**
     * Este teste do ArchUnit garante que as classes no pacote "..request" tenham
     * o sufixo "Request".
     */
    @ArchTest
    public static final ArchRule should_be_suffixed_request = classes()
            .that()
            .resideInAPackage("..request")
            .should()
            .haveSimpleNameEndingWith("Request");

    /**
     * Este teste do ArchUnit garante que as classes no pacote "..response" tenham
     * o sufixo "Response".
     */
    @ArchTest
    public static final ArchRule should_be_suffixed_response = classes()
            .that()
            .resideInAPackage("..response")
            .should()
            .haveSimpleNameEndingWith("Response");

    /**
     * Este teste do ArchUnit garante que as classes no pacote "..client" tenham
     * o sufixo "Client".
     */
    @ArchTest
    public static final ArchRule should_be_suffixed_client = classes()
            .that()
            .resideInAPackage("..client")
            .should()
            .haveSimpleNameEndingWith("Client");

    /**
     * Este teste do ArchUnit garante que as classes no pacote "..repository" tenham
     * o sufixo "Repository".
     */
    @ArchTest
    public static final ArchRule should_be_suffixed_repository = classes()
            .that()
            .resideInAPackage("..repository")
            .should()
            .haveSimpleNameEndingWith("Repository");

    /**
     * Este teste do ArchUnit garante que as classes no pacote "..entity" tenham
     * o sufixo "Entity".
     */
    @ArchTest
    public static final ArchRule should_be_suffixed_entity = classes()
            .that()
            .resideInAPackage("..entity")
            .should()
            .haveSimpleNameEndingWith("Entity");

    /**
     * Este teste do ArchUnit garante que as classes no pacote "..adapters.out" tenham
     * o sufixo "Adapter".
     */
    @ArchTest
    public static final ArchRule should_be_suffixed_adapter = classes()
            .that()
            .resideInAPackage("..adapters.out")
            .should()
            .haveSimpleNameEndingWith("Adapter");

    /**
     * Este teste do ArchUnit garante que as classes no pacote "..usecase" tenham
     * o sufixo "UseCase".
     */
    @ArchTest
    public static final ArchRule should_be_suffixed_usecase = classes()
            .that()
            .resideInAPackage("..usecase")
            .should()
            .haveSimpleNameEndingWith("UseCase");

    /**
     * Este teste do ArchUnit garante que as classes no pacote "..ports.in" tenham
     * o sufixo "InputPort".
     */
    @ArchTest
    public static final ArchRule should_be_suffixed_input_port = classes()
            .that()
            .resideInAPackage("..ports.in")
            .should()
            .haveSimpleNameEndingWith("InputPort");

    /**
     * Este teste do ArchUnit garante que as classes no pacote "..ports.out" tenham
     * o sufixo "OutputPort".
     */
    @ArchTest
    public static final ArchRule should_be_suffixed_output_port = classes()
            .that()
            .resideInAPackage("..ports.out")
            .should()
            .haveSimpleNameEndingWith("OutputPort");

    /**
     * Este teste do ArchUnit garante que as classes no pacote "..config" tenham
     * o sufixo "Config".
     */
    @ArchTest
    public static final ArchRule should_be_suffixed_config = classes()
            .that()
            .resideInAPackage("..config")
            .should()
            .haveSimpleNameEndingWith("Config");

}