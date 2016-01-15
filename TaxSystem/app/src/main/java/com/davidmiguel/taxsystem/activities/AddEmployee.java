package com.davidmiguel.taxsystem.activities;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.EditText;
import android.widget.Toast;

import com.davidmiguel.taxsystem.R;
import com.davidmiguel.taxsystem.entities.Employee;
import com.davidmiguel.taxsystem.entities.TaxCategory;

public class AddEmployee extends AppCompatActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_employee);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        ActionBar ab = getSupportActionBar();
        assert ab != null;
        ab.setHomeAsUpIndicator(R.drawable.ic_arrow_back);
        ab.setDisplayHomeAsUpEnabled(true);

    }

    private void addEmployee() {
        EditText nameInput = (EditText) findViewById(R.id.name);
        EditText jobInput = (EditText) findViewById(R.id.job);
        EditText salaryInput = (EditText) findViewById(R.id.salary);

        if(!nameInput.getText().toString().trim().equals("") &&
                !jobInput.getText().toString().trim().equals("") &&
                !salaryInput.getText().toString().trim().equals("")){
            String name = nameInput.getText().toString();
            String job = jobInput.getText().toString();
            int salary = Integer.parseInt(salaryInput.getText().toString());
            TaxCategory taxCategory = calculateTaxCategory(salary);
            int tax = calculateTax(salary, taxCategory);
            // Create and save new employee
            new Employee(name, job, salary, taxCategory, tax).save();
            // Redirect to main activity
            Toast.makeText(getApplicationContext(),
                    "New employee created!", Toast.LENGTH_SHORT).show();
            Intent intent = new Intent(this, EmployeesList.class);
            intent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK | Intent.FLAG_ACTIVITY_CLEAR_TASK);
            startActivity(intent);
        } else{
            Toast.makeText(this, "Please, fill the inputs.", Toast.LENGTH_SHORT);
        }
    }

    private TaxCategory calculateTaxCategory(int salary) {
        TaxCategory category;
        if(salary < 4000) {
            category = TaxCategory.CAT1;
        } else if(salary < 5500) {
            category = TaxCategory.CAT2;
        }else if(salary < 33500){
            category = TaxCategory.CAT3;
        }else{
            category = TaxCategory.CAT4;
        }
        return category;
    }

    private int calculateTax(int salary, TaxCategory taxCategory) {
        return salary + salary * taxCategory.getTax() /100;
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.back_done, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        switch (item.getItemId()) {
            case android.R.id.home:
                onBackPressed();
                break;
            case R.id.action_menu_done:
                addEmployee();
            default:
                break;
        }
        return super.onOptionsItemSelected(item);
    }
}
