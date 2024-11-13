package com.gargione.hexagonal.architecture;

import static com.tngtech.archunit.library.Architectures.layeredArchitecture;

import org.springframework.boot.test.context.SpringBootTest;

import com.tngtech.archunit.junit.AnalyzeClasses;
import com.tngtech.archunit.junit.ArchTest;
import com.tngtech.archunit.lang.ArchRule;


@AnalyzeClasses(packages = "com.gargione.hexagonal")
@SpringBootTest
public class LayeredArchitectureTest {

    @ArchTest
    public static final ArchRule layered_architecture_test = layeredArchitecture()
	    .consideringOnlyDependenciesInLayers()
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
