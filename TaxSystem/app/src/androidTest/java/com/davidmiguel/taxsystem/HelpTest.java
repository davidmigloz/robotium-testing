package com.davidmiguel.taxsystem;

import android.test.ActivityInstrumentationTestCase2;

import com.davidmiguel.taxsystem.activities.Help;
import com.robotium.solo.By;
import com.robotium.solo.Solo;

public class HelpTest  extends ActivityInstrumentationTestCase2<Help> {
    private Solo solo;

    public HelpTest() {
        super(Help.class);
    }

    public void setUp() throws Exception {
        super.setUp();
        solo = new Solo(getInstrumentation(), getActivity());
    }

    public void tearDown() throws Exception {
        solo.finishOpenedActivities();
        super.tearDown();
    }

    public void testHelp() throws Exception {
        // Unlock the screen if it is locked
        solo.unlockScreen();
        // Click on "How can I add a new employee?" -> id=add-employee
        final By addEmployeeButton = By.id("add-employee");
        // Wait for a WebElement without scrolling.
        this.solo.waitForWebElement(addEmployeeButton);
        // Clicks on the element
        this.solo.clickOnWebElement(addEmployeeButton);
        // Waits for the results page for Robotium
        solo.waitForText("To add a new employee follow the next steps:", 1, 2000);
        // Check if the text is visible
        assertTrue("No help text found",
                solo.searchText("To add a new employee follow the next steps:"));
    }
}