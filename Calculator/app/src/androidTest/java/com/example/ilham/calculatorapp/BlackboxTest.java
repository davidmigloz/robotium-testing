package com.example.ilham.calculatorapp;

import android.test.ActivityInstrumentationTestCase2;

import com.robotium.solo.Solo;

public class BlackboxTest extends ActivityInstrumentationTestCase2 {
    private Solo solo;

    public BlackboxTest() {
        super(MainActivity.class);
    }

    @Override
    protected void setUp() throws Exception {
        super.setUp();
        solo = new Solo(getInstrumentation(), getActivity());
    }

    @Override
    public void tearDown() throws Exception {
        solo.finishOpenedActivities();
    }

    public void testAdd() {
        solo.clearEditText(0);
        solo.enterText(0, "5");
        solo.clearEditText(1);
        solo.enterText(1, "5");
        solo.clickOnButton("+");
        assertTrue("Problem asserting addition", solo.searchText("10"));
    }

    public void testDiv1() {
        solo.clearEditText(0);
        solo.enterText(0, "5");
        solo.clearEditText(1);
        solo.enterText(1, "5");
        solo.clickOnButton("/");
        assertTrue("Problem asserting addition", solo.searchText("1"));
    }
}


