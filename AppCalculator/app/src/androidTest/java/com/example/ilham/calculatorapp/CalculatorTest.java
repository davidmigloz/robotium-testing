package com.example.ilham.calculatorapp;

import android.test.ActivityInstrumentationTestCase2;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import com.robotium.solo.Solo;

public class CalculatorTest extends ActivityInstrumentationTestCase2 {
    private Solo solo;

    public CalculatorTest() {
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

    public void testWhiteBox() {
        solo.unlockScreen();
        EditText num1Input = (EditText) solo.getView(R.id.etFirstNumber);
        EditText num2Input = (EditText) solo.getView(R.id.etSecondNumber);
        solo.clearEditText(num1Input);
        solo.clearEditText(num2Input);
        solo.enterText(num1Input, "5");
        solo.enterText(num2Input, "5");
        Button addButton = (Button) solo.getView(R.id.btnAdd);
        solo.clickOnView(addButton);
        TextView result = (TextView) solo.getView(R.id.tvResult);
        assertEquals("10", result.getText());
    }

    public void testBlackBox() {
        solo.unlockScreen();
        solo.clearEditText(0);
        solo.enterText(0, "5");
        solo.clearEditText(1);
        solo.enterText(1, "5");
        solo.clickOnButton("+");
        assertTrue("Problem asserting addition", solo.searchText("10"));
    }
}
