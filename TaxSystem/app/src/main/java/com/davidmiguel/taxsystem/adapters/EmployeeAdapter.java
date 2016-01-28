package com.davidmiguel.taxsystem.adapters;

import android.graphics.Color;
import android.graphics.drawable.Drawable;
import android.support.v7.widget.CardView;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.davidmiguel.taxsystem.R;
import com.davidmiguel.taxsystem.utils.EmployeeClickListener;
import com.davidmiguel.taxsystem.entities.Employee;
import com.davidmiguel.taxsystem.utils.ItemTouchHelperAdapter;
import com.davidmiguel.taxsystem.utils.ItemTouchHelperViewHolder;

import java.text.DecimalFormat;
import java.text.NumberFormat;
import java.util.Collections;
import java.util.List;

public class EmployeeAdapter extends RecyclerView.Adapter<EmployeeAdapter.ViewHolder>
        implements ItemTouchHelperAdapter {
    private List<Employee> employees;
    private EmployeeClickListener listener;

    public EmployeeAdapter(List<Employee> employees, EmployeeClickListener listener) {
        this.employees = employees;
        this.listener = listener;
    }

    @Override
    public EmployeeAdapter.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.list_item_employees_list, parent, false);
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

    @Override
    public void onItemDismiss(int position) {
        employees.get(position).delete();
        employees.remove(position);
        notifyItemRemoved(position);
    }

    @Override
    public boolean onItemMove(int fromPosition, int toPosition) {
        Collections.swap(employees, fromPosition, toPosition);
        notifyItemMoved(fromPosition, toPosition);
        return true;
    }

    public class ViewHolder extends RecyclerView.ViewHolder
            implements View.OnClickListener , ItemTouchHelperViewHolder {
        private EmployeeClickListener listener;
        public CardView card;
        private TextView firstLetter;
        private TextView name;
        private TextView job;
        private TextView taxCategory;
        private TextView salary;
        private Drawable background;

        public ViewHolder(View itemView, EmployeeClickListener listener) {
            super(itemView);

            card = (CardView) itemView.findViewById(R.id.card);
            firstLetter = (TextView) itemView.findViewById(R.id.first_letter);
            name = (TextView) itemView.findViewById(R.id.name);
            job = (TextView) itemView.findViewById(R.id.job);
            taxCategory = (TextView) itemView.findViewById(R.id.tax_category);
            salary = (TextView) itemView.findViewById(R.id.salary);

            background = card.getBackground();

            this.listener = listener;
            itemView.setOnClickListener(this);
        }

        public void bind(Employee employee) {
            firstLetter.setText(employee.getName().substring(0, 1));
            name.setText(employee.getName());
            job.setText(employee.getJob());
            taxCategory.setText(employee.getCategory().toString());
            NumberFormat nf = new DecimalFormat("#,###,###€");
            salary.setText(nf.format(employee.getSalary()));
        }

        @Override
        public void onClick(View v) {
            listener.onClick(employees.get(getAdapterPosition()));
        }

        @Override
        public void onItemSelected() {
            card.setBackgroundColor(Color.LTGRAY);
        }

        @Override
        public void onItemClear() {
            card.setBackground(background);
        }
    }
}
