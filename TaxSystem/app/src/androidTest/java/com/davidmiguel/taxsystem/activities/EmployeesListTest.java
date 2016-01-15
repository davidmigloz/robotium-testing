package com.davidmiguel.taxsystem.activities;

import android.test.ActivityInstrumentationTestCase2;

import com.davidmiguel.taxsystem.R;
import com.robotium.solo.Solo;

public class EmployeesListTest extends ActivityInstrumentationTestCase2<EmployeesList> {
    private Solo solo;

    public EmployeesListTest() {
        super(EmployeesList.class);
    }

    public void setUp() throws Exception {
        super.setUp();
        solo = new Solo(getInstrumentation(), getActivity());
    }

    public void tearDown() throws Exception {
        solo.finishOpenedActivities();
    }

    public void testAddEmployee() throws Exception {
        solo.unlockScreen();

        solo.clickOnImageButton(0);

        solo.assertCurrentActivity("Expected AddEmployee activity", AddEmployee.class);

        solo.enterText(0, "David");
        solo.enterText(1, "CEO");
        solo.enterText(2, "80000");

        solo.clickOnView(solo.getView(R.id.action_menu_done));

        assertTrue("No employee created", solo.searchText("New employee created!"));

        solo.assertCurrentActivity("Expected EmployeesList activity", EmployeesList.class);
    }
}