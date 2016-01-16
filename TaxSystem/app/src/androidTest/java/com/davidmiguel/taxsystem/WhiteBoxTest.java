package com.davidmiguel.taxsystem;

import android.support.v7.widget.RecyclerView;
import android.test.ActivityInstrumentationTestCase2;
import android.widget.EditText;
import android.widget.TextView;

import com.davidmiguel.taxsystem.activities.AddEmployee;
import com.davidmiguel.taxsystem.activities.EmployeesList;
import com.robotium.solo.Solo;

public class WhiteBoxTest extends ActivityInstrumentationTestCase2<EmployeesList> {
    private Solo solo;

    public WhiteBoxTest() {
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
        solo.clickOnView(solo.getView(R.id.fab));
        // Check it is in AddEmployee activity
        solo.assertCurrentActivity("Expected AddEmployee activity", AddEmployee.class);
        // Enter data
        EditText nameInput = (EditText) solo.getView(R.id.name);
        EditText jobInput = (EditText) solo.getView(R.id.job);
        EditText salaryInput = (EditText) solo.getView(R.id.salary);
        solo.enterText(nameInput, "David");
        solo.enterText(jobInput, "CEO");
        solo.enterText(salaryInput, "80000");
        // Click on done icon
        solo.clickOnView(solo.getView(R.id.action_menu_done));
        // Check Toast with "New employee created!" message appears
        assertTrue("No employee created", solo.searchText("New employee created!"));
        // Check it is again in EmployeesList activity
        solo.assertCurrentActivity("Expected EmployeesList activity", EmployeesList.class);
        // Check that a new card have been created with David name
        RecyclerView employeesList = (RecyclerView) solo.getView(R.id.employee_list);
        int lastEmployeeIndex = employeesList.getAdapter().getItemCount() - 1;
        TextView name = solo.clickInRecyclerView(lastEmployeeIndex).get(1);
        assertEquals("Employee David expected", "David", name.getText());
    }
}
