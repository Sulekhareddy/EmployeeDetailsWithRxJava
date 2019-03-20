package com.example.employeedetailswithrxjava;

import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.employeedetailswithrxjava.data.entity.Employee;

import java.util.ArrayList;
import java.util.List;

public class EmployeeAdapter extends RecyclerView.Adapter<EmployeeViewHolder> {

    List<Employee> employeeList = new ArrayList<>();

    @NonNull
    @Override
    public EmployeeViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int position) {

        LayoutInflater layoutInflater = LayoutInflater.from(viewGroup.getContext());
        View view = layoutInflater.inflate(R.layout.recycler_view_item, viewGroup, false);
        return new EmployeeViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull EmployeeViewHolder employeeViewHolder, int position) {
        Employee employee = employeeList.get(position);
        employeeViewHolder.bind(employee);

    }

    @Override
    public int getItemCount() {
        return employeeList.size();
    }

    public void setEmployees(List<Employee> employees){
        if(!employeeList.isEmpty()){
            employeeList.clear();
        }
        employeeList.addAll(employees);
        notifyDataSetChanged();
    }
}
