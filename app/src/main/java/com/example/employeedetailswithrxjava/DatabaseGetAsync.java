package com.example.employeedetailswithrxjava;

import android.os.AsyncTask;

import com.example.employeedetailswithrxjava.data.dao.EmployeeDao;
import com.example.employeedetailswithrxjava.data.entity.Employee;

import java.util.List;

public class DatabaseGetAsync extends AsyncTask<Void, Void, List<Employee>> {

    private EmployeeDao todoDao;

    OnAsyncInteractionListener listener;

    public DatabaseGetAsync(EmployeeDao todoDao, OnAsyncInteractionListener listener) {
        this.todoDao = todoDao;
        this.listener = listener;
    }

    @Override
    protected List<Employee> doInBackground(Void... voids) {
        return todoDao.getTodoItems();
    }

    @Override
    protected void onPostExecute(List<Employee> todoList) {
        super.onPostExecute(todoList);
        listener.onPostExecuteDB(todoList);
    }
}

