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
import com.davidmiguel.taxsystem.entities.SalaryCategory;
import com.davidmiguel.taxsystem.entities.TaxCategory;

public class AddEmployee extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        // Set template
        setContentView(R.layout.activity_add_employee);

        // Set toolbar
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        // Set back button
        ActionBar ab = getSupportActionBar();
        if (ab != null) {
            ab.setHomeAsUpIndicator(R.drawable.ic_arrow_back);
            ab.setDisplayHomeAsUpEnabled(true);
        }
    }

    private void addEmployee() {
        EditText nameInput = (EditText) findViewById(R.id.name);
        EditText jobInput = (EditText) findViewById(R.id.job);
        EditText salaryInput = (EditText) findViewById(R.id.salary);

        if (!nameInput.getText().toString().trim().equals("") &&
                !jobInput.getText().toString().trim().equals("") &&
                !salaryInput.getText().toString().trim().equals("")) {
            String name = nameInput.getText().toString();
            String job = jobInput.getText().toString();
            int salary = Integer.parseInt(salaryInput.getText().toString());
            TaxCategory taxCategory = calculateTaxCategory(salary);
            long tax = calculateTax(salary, taxCategory);

            // Create and save new employee
            new Employee(name, job, salary, taxCategory, tax).save();

            // Redirect to main activity
            Toast.makeText(getApplicationContext(),
                    "New employee created!", Toast.LENGTH_SHORT).show();
            Intent intent = new Intent(this, EmployeesList.class);
            intent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK | Intent.FLAG_ACTIVITY_CLEAR_TASK);
            startActivity(intent);
        } else {
            Toast.makeText(this, "Please, fill the inputs.", Toast.LENGTH_SHORT).show();
        }
    }

    private TaxCategory calculateTaxCategory(int salary) {
        TaxCategory category = null;
        if (salary < 0) {
            category = null; // 2º error
        } else if (salary < SalaryCategory.CAT1.getMaxSalary()) {
            category = TaxCategory.CAT1;
        } else if (salary < SalaryCategory.CAT2.getMaxSalary()) {
            category = TaxCategory.CAT2;
        } else if (salary <= SalaryCategory.CAT3.getMaxSalary()) { // 3º error
            category = TaxCategory.CAT3;
        } else if (salary < SalaryCategory.CAT4.getMaxSalary()) {
            category = TaxCategory.CAT4;
        }
        return category;
    }

    private long calculateTax(int salary, TaxCategory taxCategory) {
        long tax = 0;
        switch (taxCategory) {
            case CAT4:
                tax += salary * TaxCategory.CAT4.getTax();
                salary = 33500;
            case CAT3:
                tax += salary * TaxCategory.CAT3.getTax();
                salary = 5500;
            case CAT2:
                tax += salary * TaxCategory.CAT2.getTax();
                salary = 4000;
            case CAT1:
                tax += salary * TaxCategory.CAT1.getTax();
        }
        return Math.round(tax);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.back_done, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
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
