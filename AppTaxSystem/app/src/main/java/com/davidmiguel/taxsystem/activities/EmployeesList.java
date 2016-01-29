package com.davidmiguel.taxsystem.activities;

import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.support.v7.widget.helper.ItemTouchHelper;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Toast;

import com.davidmiguel.taxsystem.R;
import com.davidmiguel.taxsystem.entities.Employee;
import com.davidmiguel.taxsystem.utils.EmployeeClickListener;
import com.davidmiguel.taxsystem.utils.SimpleItemTouchHelperCallback;
import com.davidmiguel.taxsystem.adapters.EmployeeAdapter;

import java.text.DecimalFormat;
import java.text.NumberFormat;
import java.util.List;

public class EmployeesList extends AppCompatActivity implements EmployeeClickListener {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        // Set template
        setContentView(R.layout.activity_employees_list);

        // Set toolbar
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        // List
        RecyclerView recyclerView = (RecyclerView) findViewById(R.id.employee_list);
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(getBaseContext());
        recyclerView.setLayoutManager(linearLayoutManager);

        // Get employees
        List<Employee> employees = Employee.listAll(Employee.class);

        // Set adapter
        EmployeeAdapter adapter = new EmployeeAdapter(employees, this);
        recyclerView.setAdapter(adapter);

        // Swipe and drag
        ItemTouchHelper.Callback callback = new SimpleItemTouchHelperCallback(adapter,
                ItemTouchHelper.UP | ItemTouchHelper.DOWN,
                ItemTouchHelper.RIGHT);
        ItemTouchHelper employeeTouchHelper = new ItemTouchHelper(callback);
        employeeTouchHelper.attachToRecyclerView(recyclerView);

        // Floating action button
        FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(getApplicationContext(), AddEmployee.class);
                startActivity(intent);
            }
        });
    }

    @Override
    public void onClick(Employee employee) {
        NumberFormat nf = new DecimalFormat("#,###,###,###€");
        Toast.makeText(this, "Tax: " + nf.format(employee.getTax()),
                Toast.LENGTH_SHORT).show();
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            case android.R.id.home:
                onBackPressed();
                break;
            case R.id.action_menu_help:
                Intent intent = new Intent(getApplicationContext(), Help.class);
                startActivity(intent);
            default:
                break;
        }
        return super.onOptionsItemSelected(item);
    }
}
