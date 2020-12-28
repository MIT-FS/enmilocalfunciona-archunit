package com.acme.architecture.testing.archunit.rule.core;

import static com.tngtech.archunit.lang.syntax.ArchRuleDefinition.classes;
import static com.tngtech.archunit.lang.syntax.ArchRuleDefinition.methods;
import static com.tngtech.archunit.lang.syntax.ArchRuleDefinition.noClasses;

import com.acme.architecture.testing.archunit.constant.ArchUnitNameConstant;
import com.acme.architecture.testing.archunit.constant.ArchUnitPackageConstant;
import com.tngtech.archunit.junit.ArchTest;
import com.tngtech.archunit.lang.ArchRule;

public class CatalogUtilArchitectureRule {
	
	@ArchTest
	public static final ArchRule util_classes_should_be_in_util_package = 
		    classes()
		    .that().haveSimpleNameEndingWith(ArchUnitNameConstant.SUFFIX_NAME_UTIL_CLASS)
		    .should().resideInAnyPackage(ArchUnitPackageConstant.RESIDE_FINAL_PACKAGE_UTIL_CLASS, ArchUnitPackageConstant.RESIDE_PACKAGE_UTIL_CLASS);

	@ArchTest
	public static final ArchRule util_classes_should_have_names_ending_with_the_word_util = 
		    classes()
		    .that().resideInAnyPackage(ArchUnitPackageConstant.RESIDE_FINAL_PACKAGE_UTIL_CLASS, ArchUnitPackageConstant.RESIDE_PACKAGE_UTIL_CLASS)
		    .should().haveSimpleNameEndingWith(ArchUnitNameConstant.SUFFIX_NAME_UTIL_CLASS);

	@ArchTest
	public static final ArchRule util_classes_should_be_public = 
		    classes()
		    .that().resideInAnyPackage(ArchUnitPackageConstant.RESIDE_FINAL_PACKAGE_UTIL_CLASS, ArchUnitPackageConstant.RESIDE_PACKAGE_UTIL_CLASS)
		    .should().bePublic();
	
	@ArchTest
	public static final ArchRule util_classes_methods_should_be_static = 
			methods()
			.that().arePublic()
			.and().areDeclaredInClassesThat().resideInAnyPackage(ArchUnitPackageConstant.RESIDE_FINAL_PACKAGE_UTIL_CLASS, ArchUnitPackageConstant.RESIDE_PACKAGE_UTIL_CLASS)
			.should().beStatic();
	
	@ArchTest
	public static final ArchRule no_util_classes_should_be_reside_other_packages = 
			noClasses()
			.that().haveSimpleNameEndingWith(ArchUnitNameConstant.SUFFIX_NAME_UTIL_CLASS)
		    .should().resideOutsideOfPackage(ArchUnitPackageConstant.RESIDE_FINAL_PACKAGE_UTIL_CLASS)
		    .andShould().resideOutsideOfPackage(ArchUnitPackageConstant.RESIDE_PACKAGE_UTIL_CLASS);
}
