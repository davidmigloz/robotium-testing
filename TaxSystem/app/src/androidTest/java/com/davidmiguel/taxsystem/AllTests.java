package com.davidmiguel.taxsystem;

import junit.framework.Test;
import junit.framework.TestSuite;

public class AllTests {
    public static Test suite() {
        TestSuite suite = new TestSuite(AllTests.class.getName());
        suite.addTest(TestSuite.createTest(AddEmployeeTest.class, "testAddEmployeeWhiteBox"));
        suite.addTest(TestSuite.createTest(AddEmployeeTest.class, "testAddEmployeeBlackBox"));
        suite.addTest(TestSuite.createTest(RemoveEmployeeTest.class, "testRemoveEmployee"));
        suite.addTest(TestSuite.createTest(HelpTest.class, "testHelp"));
        suite.addTest(TestSuite.createTest(CalculationTaxesTest.class, "testCalculationTaxes"));
        return suite;
    }
}
