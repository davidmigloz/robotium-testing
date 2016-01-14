package com.davidmiguel.taxsystem.activities;

import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.view.Menu;
import android.view.MenuItem;

import com.davidmiguel.taxsystem.R;
import com.davidmiguel.taxsystem.entities.Employee;
import com.davidmiguel.taxsystem.entities.TaxCategory;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity implements EmployeeClickListener {
    private EmployeeAdapter adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        // List
        RecyclerView recyclerView = (RecyclerView) findViewById(R.id.employee_list);
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(getBaseContext());
        recyclerView.setLayoutManager(linearLayoutManager);

        // List items
        List<Employee> employees = new ArrayList<>();
        employees.add(new Employee("David", "CEO", 3000, TaxCategory.CAT4, 100));
        employees.add(new Employee("Ana", "Developer", 2000, TaxCategory.CAT3, 50));
        employees.add(new Employee("Alba", "Designer", 2000, TaxCategory.CAT3, 50));

        // Show items
        adapter = new EmployeeAdapter(employees, this);
        recyclerView.setAdapter(adapter);

        // Floating action button
        FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
                        .setAction("Action", null).show();
            }
        });
    }

    @Override
    public void onClick(Employee employee) {

    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }
}
