package com.example.employeedetailswithrxjava.data.database;

import android.arch.persistence.room.Database;
import android.arch.persistence.room.Room;
import android.arch.persistence.room.RoomDatabase;
import android.content.Context;

import com.example.employeedetailswithrxjava.data.dao.EmployeeDao;
import com.example.employeedetailswithrxjava.data.entity.Employee;

@Database(entities = Employee.class, version = 1)
public abstract class EmployeeDatabase extends RoomDatabase {

    private static EmployeeDatabase INSTANCE;
    public static final String DB_NAME = "user.db";


    public abstract EmployeeDao employeeDao();

    public static EmployeeDatabase getAppDatabase(Context context) {
        if (INSTANCE == null) {
            INSTANCE = Room.databaseBuilder(context.getApplicationContext(),
                    EmployeeDatabase.class, DB_NAME)
                    .build();
        }
        return INSTANCE;
    }


    public static void destroyInstance() {
        INSTANCE = null;
    }


}
