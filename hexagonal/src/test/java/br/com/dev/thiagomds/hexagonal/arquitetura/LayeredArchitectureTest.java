package br.com.dev.thiagomds.hexagonal.arquitetura;


import com.tngtech.archunit.junit.AnalyzeClasses;
import com.tngtech.archunit.junit.ArchTest;
import com.tngtech.archunit.lang.ArchRule;
import org.springframework.boot.test.context.SpringBootTest;

import static com.tngtech.archunit.library.Architectures.layeredArchitecture;

@AnalyzeClasses(packages = "br.com.dev.thiagomds.hexagonal")
public class LayeredArchitectureTest {

    /**
     * Este teste do ArchUnit garante que a arquitetura em camadas seja respeitada.
     *
     * - A camada AdaptersIn só pode ser acessada pela camada Config.
     * - A camada AdaptersOut só pode ser acessada pela camada Config.
     * - A camada UseCase só pode ser acessada pela camada Config.
     * - A camada PortsIn só pode ser acessada pelas camadas UseCase e AdaptersIn.
     * - A camada PortsOut só pode ser acessada pelas camadas UseCase e AdaptersOut.
     * - A camada Config não pode ser acessada por nenhuma outra camada.
     */
    @ArchTest
    public static final ArchRule layered_should_not_access_all_services = layeredArchitecture()
            .consideringAllDependencies()
            .layer("AdaptersIn").definedBy("..adapters.in..")
            .layer("AdaptersOut").definedBy("..adapters.out..")
            .layer("UseCase").definedBy("..application.core.usecase..")
            .layer("PortsIn").definedBy("..application.ports.in..")
            .layer("PortsOut").definedBy("..application.ports.out..")
            .layer("Config").definedBy("..config..")
            .whereLayer("AdaptersIn").mayOnlyBeAccessedByLayers("Config")
            .whereLayer("AdaptersOut").mayOnlyBeAccessedByLayers("Config")
            .whereLayer("UseCase").mayOnlyBeAccessedByLayers("Config")
            .whereLayer("PortsIn").mayOnlyBeAccessedByLayers("UseCase", "AdaptersIn")
            .whereLayer("PortsOut").mayOnlyBeAccessedByLayers("UseCase", "AdaptersOut")
            .whereLayer("Config").mayNotBeAccessedByAnyLayer();

}
