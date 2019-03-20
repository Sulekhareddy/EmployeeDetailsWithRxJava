package com.example.employeedetailswithrxjava;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.DividerItemDecoration;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.Button;
import android.widget.ProgressBar;

import com.example.employeedetailswithrxjava.data.entity.Employee;
import com.example.employeedetailswithrxjava.data.repo.Repository;

import java.util.List;

public class MainActivity extends AppCompatActivity implements View.OnClickListener, OnAsyncInteractionListener{

    private ProgressBar progressBar;
    private Button requestButton;
    private RecyclerView recyclerView;

    private EmployeeAdapter adapter;
    private Repository repository;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        repository = new Repository(this, this);

        initViews();
    }

    private void initViews() {
        progressBar = findViewById(R.id.progress_circular);
        requestButton = findViewById(R.id.employee_button);
        recyclerView = findViewById(R.id.recyclerView);

        adapter = new EmployeeAdapter();
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        recyclerView.addItemDecoration(new DividerItemDecoration(this, DividerItemDecoration.VERTICAL));
        recyclerView.setAdapter(adapter);

        requestButton.setOnClickListener(this);
    }

    @Override
    public void onClick(View view) {
        repository.getTodoList();
    }

    @Override
    public void onPreExecute() {
        progressBar.setVisibility(View.VISIBLE);
        recyclerView.setVisibility(View.GONE);
    }

    @Override
    public void onPostExecute(List<Employee> results) {
        adapter.setEmployees(results);
        repository.insert(results);
        progressBar.setVisibility(View.GONE);
        recyclerView.setVisibility(View.VISIBLE);
    }

    @Override
    public void onPostExecuteDB(List<Employee> results) {
        adapter.setEmployees(results);
        progressBar.setVisibility(View.GONE);
        recyclerView.setVisibility(View.VISIBLE);
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        repository.destroyDatabaseInstance();
    }
}
