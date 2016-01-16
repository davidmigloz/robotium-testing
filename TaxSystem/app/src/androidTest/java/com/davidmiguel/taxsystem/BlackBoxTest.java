package com.davidmiguel.taxsystem;

import android.test.ActivityInstrumentationTestCase2;
import android.widget.TextView;

import com.davidmiguel.taxsystem.activities.AddEmployee;
import com.davidmiguel.taxsystem.activities.EmployeesList;
import com.robotium.solo.Solo;

public class BlackBoxTest extends ActivityInstrumentationTestCase2<EmployeesList> {
    private Solo solo;

    public BlackBoxTest() {
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
        // Unlock the screen if it is locked
        solo.unlockScreen();
        // Click on the floating action button
        solo.clickOnImageButton(0);
        // Check it is in AddEmployee activity
        solo.assertCurrentActivity("Expected AddEmployee activity", AddEmployee.class);
        // Enter data
        solo.enterText(0, "David");
        solo.enterText(1, "CEO");
        solo.enterText(2, "80000");
        // Click on done icon
        solo.clickOnScreen(440, 80);
        // Check Toast with "New employee created!" message appears
        assertTrue("No employee created", solo.searchText("New employee created!"));
        // Check it is again in EmployeesList activity
        solo.assertCurrentActivity("Expected EmployeesList activity", EmployeesList.class);
        // Check that a new card have been created with David name
        boolean found = false;
        try {
            for (int i = 0; ; i++) {
                TextView name = solo.clickInRecyclerView(i).get(1);
                if (name.getText().equals("David")) {
                    found = true;
                    break;
                }
            }
        } catch (Exception e) {
            assertEquals("Employee David expected", "David", null);
        }
    }
}