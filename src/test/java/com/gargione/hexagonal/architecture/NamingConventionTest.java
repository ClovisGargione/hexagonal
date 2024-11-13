package com.gargione.hexagonal.architecture;

import static com.tngtech.archunit.lang.syntax.ArchRuleDefinition.classes;

import org.springframework.boot.test.context.SpringBootTest;

import com.tngtech.archunit.junit.AnalyzeClasses;
import com.tngtech.archunit.junit.ArchTest;
import com.tngtech.archunit.lang.ArchRule;

@AnalyzeClasses(packages = "com.gargione.hexagonal")
@SpringBootTest
public class NamingConventionTest {

    @ArchTest
    public static final ArchRule consumer_reside_only_consumer_package = classes()
    	.that()
    	.haveNameMatching(".*Consumer")
    	.should()
    	.resideInAPackage("..adapters.in.consumer");
    
    @ArchTest
    public static final ArchRule mapper_reside_only_mapper_package = classes()
    	.that()
    	.haveNameMatching(".*Mapper")
    	.should()
    	.resideInAnyPackage("..adapters.in.consumer.mapper", "..adapters.in.controller.mapper", "..adapters.out.client.mapper", "..adapters.out.repository.mapper");
    
    @ArchTest
    public static final ArchRule message_reside_only_message_package = classes()
    	.that()
    	.haveNameMatching(".*Message")
    	.should()
    	.resideInAPackage("..adapters.in.consumer.message");
    
    @ArchTest
    public static final ArchRule controller_reside_only_constroller_package = classes()
    	.that()
    	.haveNameMatching(".*Controller")
    	.should()
    	.resideInAPackage("..adapters.in.controller");
    
    @ArchTest
    public static final ArchRule should_be_suffixed_consumer = classes()
    	.that()
    	.resideInAPackage("..consumer")
    	.should()
    	.haveSimpleNameEndingWith("Consumer");
    
    @ArchTest
    public static final ArchRule should_be_suffixed_mapper = classes()
    	.that()
    	.resideInAPackage("..mapper")
    	.should()
    	.haveSimpleNameEndingWith("Mapper")
    	.orShould()
    	.haveSimpleNameEndingWith("MapperImpl");

}
