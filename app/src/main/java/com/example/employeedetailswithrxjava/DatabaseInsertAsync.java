package com.example.employeedetailswithrxjava;

import android.os.AsyncTask;

import com.example.employeedetailswithrxjava.data.dao.EmployeeDao;
import com.example.employeedetailswithrxjava.data.entity.Employee;

import java.util.ArrayList;

public class DatabaseInsertAsync extends AsyncTask<ArrayList<Employee>, Void, Void> {

    EmployeeDao todoDao;

    public DatabaseInsertAsync(EmployeeDao todoDao) {
        this.todoDao = todoDao;
    }

    @Override
    protected Void doInBackground(ArrayList<Employee>... arrayLists) {
        ArrayList<Employee> items = arrayLists[0];
        todoDao.insertAll(items);
        return null;
    }
}

