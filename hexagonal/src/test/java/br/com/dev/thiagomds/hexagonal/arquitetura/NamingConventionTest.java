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
}