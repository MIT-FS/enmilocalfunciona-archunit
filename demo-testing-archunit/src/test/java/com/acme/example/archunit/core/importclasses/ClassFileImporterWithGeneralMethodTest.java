package com.acme.example.archunit.core.importclasses;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

import java.util.List;

import org.junit.jupiter.api.Test;

import com.acme.example.archunit.core.importclasses.component.util.ArchUnitComponentUtil;
import com.tngtech.archunit.core.domain.JavaClasses;
import com.tngtech.archunit.core.importer.ClassFileImporter;
import com.tngtech.archunit.core.importer.ImportOption;

public class ClassFileImporterWithGeneralMethodTest {
	
	private static final String GENERIC_PACKAGE_TEST_VALUE = "com.acme.example";
	
	private static final int NUM_IMPORTED_CLASSES_DEFAULT_GENERIC_WITH_OPTIONS = 18;

	private JavaClasses IMPORTED_CLASSES = new ClassFileImporter()
    		.withImportOption(ImportOption.Predefined.DO_NOT_INCLUDE_TESTS)
    		.withImportOption(ImportOption.Predefined.DO_NOT_INCLUDE_ARCHIVES)
    		.withImportOption(ImportOption.Predefined.DO_NOT_INCLUDE_JARS)
    		.importPackages(GENERIC_PACKAGE_TEST_VALUE);
	
	
	@Test
    public void whenCallImportPackagesFieldWithOptions_thenReturnJavaClassComponents() {
		System.out.println("\n*** ClassFileImporter Default Generic with Options ***");
		
        //Show : Project Classes (NO test, NO Archives and NO JARs)
        System.out.println("* Show : Project Classes (NO test, NO Archives and NO JARs)");
        ArchUnitComponentUtil.showInfo(IMPORTED_CLASSES);
   
        //Generate JavaClass List
        List<?> importedClassesList = ArchUnitComponentUtil.generarJavaClassList(IMPORTED_CLASSES);
   
        assertNotNull(importedClassesList);
        assertEquals(NUM_IMPORTED_CLASSES_DEFAULT_GENERIC_WITH_OPTIONS,importedClassesList.size());
    }
	
	
}