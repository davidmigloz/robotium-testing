package com.davidmiguel.taxsystem.activities;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.davidmiguel.taxsystem.R;
import com.davidmiguel.taxsystem.entities.Employee;

import java.util.ArrayList;
import java.util.List;

public class EmployeeAdapter extends RecyclerView.Adapter<EmployeeAdapter.ViewHolder> {
    private List<Employee> employees = new ArrayList<>();
    private EmployeeClickListener listener;

    public EmployeeAdapter(List<Employee> employees, EmployeeClickListener listener) {
        this.employees = employees;
        this.listener = listener;
    }

    @Override
    public EmployeeAdapter.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.list_item_main, parent, false);
        return new ViewHolder(view, listener);
    }

    @Override
    public void onBindViewHolder(EmployeeAdapter.ViewHolder holder, int position) {
        holder.bind(employees.get(position));
    }

    @Override
    public int getItemCount() {
        return employees == null ? 0 : employees.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener {
        private EmployeeClickListener listener;
        private TextView firstLetter;
        private TextView name;
        private TextView job;
        private TextView taxCategory;
        private TextView tax;

        public ViewHolder(View itemView, EmployeeClickListener listener) {
            super(itemView);

            this.listener = listener;

            firstLetter = (TextView) itemView.findViewById(R.id.first_letter);
            name = (TextView) itemView.findViewById(R.id.name);
            job = (TextView) itemView.findViewById(R.id.job);
            taxCategory = (TextView) itemView.findViewById(R.id.tax_category);
            tax = (TextView) itemView.findViewById(R.id.tax);
        }

        public void bind(Employee employee) {
            firstLetter.setText(employee.getName().substring(0, 1));
            name.setText(employee.getName());
            job.setText(employee.getJob());
            taxCategory.setText(employee.getCategory().toString());
            tax.setText(String.format("%d€", employee.getTax()));
        }

        @Override
        public void onClick(View v) {
            listener.onClick(employees.get(getAdapterPosition()));
        }
    }
}
