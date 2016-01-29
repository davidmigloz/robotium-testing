package com.davidmiguel.taxsystem;

import android.graphics.PointF;
import android.support.v7.widget.RecyclerView;
import android.test.ActivityInstrumentationTestCase2;

import com.davidmiguel.taxsystem.activities.EmployeesList;
import com.robotium.solo.Condition;
import com.robotium.solo.Solo;

public class RemoveEmployeeTest extends ActivityInstrumentationTestCase2<EmployeesList> {
    private Solo solo;

    public RemoveEmployeeTest() {
        super(EmployeesList.class);
    }

    public void setUp() throws Exception {
        super.setUp();
        solo = new Solo(getInstrumentation(), getActivity());
    }

    public void tearDown() throws Exception {
        solo.finishOpenedActivities();
        super.tearDown();
    }

    public void testRemoveEmployee() throws Exception {
        // Unlock the screen if it is locked
        solo.unlockScreen();
        // Count numbers of employees before removing
        final RecyclerView employeesList = (RecyclerView) solo.getView(R.id.employee_list);
        final int numEmployees = employeesList.getAdapter().getItemCount();

        // Swipe from left to right in the first item
        solo.swipe(new PointF(10, 200), new PointF(10, 200),
                new PointF(400, 200), new PointF(400, 200));
        solo.clickOnText("TaxSystem");
        solo.waitForCondition(new Condition() {
            @Override
            public boolean isSatisfied() {
                return numEmployees != employeesList.getAdapter().getItemCount();
            }
        }, 3000);

        // Check we have one item less
        int numEmployeesAfter = employeesList.getAdapter().getItemCount();
        assertEquals("Expected " + (numEmployees - 1) + " employees",
                numEmployees - 1, numEmployeesAfter);
    }
}