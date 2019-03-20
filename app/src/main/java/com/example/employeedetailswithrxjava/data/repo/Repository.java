package com.example.employeedetailswithrxjava.data.repo;

import android.content.Context;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;

import com.example.employeedetailswithrxjava.DatabaseGetAsync;
import com.example.employeedetailswithrxjava.DatabaseInsertAsync;
import com.example.employeedetailswithrxjava.HttpRequestAsync;
import com.example.employeedetailswithrxjava.OnAsyncInteractionListener;
import com.example.employeedetailswithrxjava.data.dao.EmployeeDao;
import com.example.employeedetailswithrxjava.data.database.EmployeeDatabase;
import com.example.employeedetailswithrxjava.data.entity.Employee;

import java.util.ArrayList;
import java.util.List;

public class Repository {

    private String url = "http://dummy.restapiexample.com/api/v1/employees";

    private EmployeeDao employeeDao;
    private Context context;
    private OnAsyncInteractionListener listener;


    public Repository(Context context, OnAsyncInteractionListener listener) {
        EmployeeDatabase database = EmployeeDatabase.getAppDatabase(context);
        employeeDao = database.employeeDao();
        this.listener = listener;
        this.context = context;
    }

    public void getTodoList() {
        if (isNetworkAvailable()) {
            new HttpRequestAsync(listener).execute(url);
        } else {
            new DatabaseGetAsync(employeeDao, listener).execute();
        }
    }

    public void insert(List<Employee> todoItems) {
        ArrayList todoList = new ArrayList<>(todoItems);
        new DatabaseInsertAsync(employeeDao).execute(todoList);
    }

    public void destroyDatabaseInstance() {
        EmployeeDatabase.destroyInstance();
    }

    private boolean isNetworkAvailable() {
        ConnectivityManager connectivityManager
                = (ConnectivityManager) context.getSystemService(Context.CONNECTIVITY_SERVICE);
        if (connectivityManager != null) {
            NetworkInfo activeNetworkInfo = connectivityManager.getActiveNetworkInfo();
            return activeNetworkInfo != null && activeNetworkInfo.isConnected();
        }
        return false;
    }
}
