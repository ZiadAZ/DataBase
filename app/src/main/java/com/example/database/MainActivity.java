package com.example.database;

import android.database.sqlite.SQLiteDatabase;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {
DB_Manager db_manager;
SQLiteDatabase user_db;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        db_manager=new DB_Manager(this);
        user_db=db_manager.getWritableDatabase();
     //   read_user_db=db_manager.getReadableDatabase();


    }

}
