package com.acme.architecture.testing.archunit.rule.core;

import com.acme.architecture.testing.archunit.constant.ArchUnitPackageConstant;
import com.acme.architecture.testing.archunit.rule.core.CatalogConstantArchitectureRule;
import com.tngtech.archunit.core.importer.ImportOption;
import com.tngtech.archunit.junit.AnalyzeClasses;
import com.tngtech.archunit.junit.ArchTest;
import com.tngtech.archunit.lang.ArchRule;

@AnalyzeClasses(packages = ArchUnitPackageConstant.PACKAGE_EXAMPLE, 
	importOptions = { 
			ImportOption.DoNotIncludeArchives.class, 
			ImportOption.DoNotIncludeJars.class 
	}
)
// Includes test classes
public class CatalogConstantArchitectureRuleTest {

	@ArchTest
	public static final ArchRule constant_classes_should_be_in_constant_package = CatalogConstantArchitectureRule.constant_classes_should_be_in_constant_package;

	@ArchTest
	public static final ArchRule constant_classes_should_have_names_ending_with_the_word_constant = CatalogConstantArchitectureRule.constant_classes_should_have_names_ending_with_the_word_constant;
	
	@ArchTest
	public static final ArchRule constant_classes_should_be_public = CatalogConstantArchitectureRule.constant_classes_should_be_public;
	
	@ArchTest
	public static final ArchRule constant_classes_should_be_final = CatalogConstantArchitectureRule.constant_classes_should_be_final;
	
	@ArchTest
	public static final ArchRule constant_classes_fields_should_be_public_static_final = CatalogConstantArchitectureRule.constant_classes_fields_should_be_public_static_final;
	
	@ArchTest
	public static final ArchRule constant_classes_fields_no_should_be_private = CatalogConstantArchitectureRule.constant_classes_fields_no_should_be_private;
	
	@ArchTest
	public static final ArchRule constant_classes_methods_no_should_be_public = CatalogConstantArchitectureRule.constant_classes_methods_no_should_be_public;

	@ArchTest
	public static final ArchRule no_constant_classes_should_be_reside_other_packages = CatalogConstantArchitectureRule.no_constant_classes_should_be_reside_other_packages;

}