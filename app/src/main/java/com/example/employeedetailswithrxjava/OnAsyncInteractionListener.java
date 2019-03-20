package com.example.employeedetailswithrxjava;

import com.example.employeedetailswithrxjava.data.entity.Employee;

import java.util.List;

public interface OnAsyncInteractionListener {

    void onPreExecute();

    void onPostExecute(List<Employee> result);

    void onPostExecuteDB(List<Employee> result);
}
