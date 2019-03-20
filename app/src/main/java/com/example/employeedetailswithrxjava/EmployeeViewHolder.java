package com.example.employeedetailswithrxjava;

import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import com.example.employeedetailswithrxjava.data.entity.Employee;

public class EmployeeViewHolder extends RecyclerView.ViewHolder {


    TextView employeeTextView;
    TextView employee_salaryTextView;
    ImageView imageView;

    public EmployeeViewHolder(@NonNull View itemView) {
        super(itemView);
        employeeTextView = itemView.findViewById(R.id.name);
        employee_salaryTextView = itemView.findViewById(R.id.salary);
        imageView = itemView.findViewById(R.id.img);
    }

    public void bind(Employee employee) {

        employeeTextView.setText(employee.getEmployeeName());
        employee_salaryTextView.setText(employee.getEmployeeSalary());

    }
}
