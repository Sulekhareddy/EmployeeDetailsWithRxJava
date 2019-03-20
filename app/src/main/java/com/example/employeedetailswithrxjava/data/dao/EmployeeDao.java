package com.example.employeedetailswithrxjava.data.dao;

import android.arch.persistence.room.Dao;
import android.arch.persistence.room.Insert;
import android.arch.persistence.room.OnConflictStrategy;
import android.arch.persistence.room.Query;

import com.example.employeedetailswithrxjava.data.entity.Employee;

import java.util.List;

@Dao
public interface EmployeeDao {

    @Query("SELECT * FROM employee_table")
    List<Employee> getTodoItems();


    @Insert(onConflict = OnConflictStrategy.REPLACE)
    void insertAll(List<Employee> todoList);
}
