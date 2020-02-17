package com.example.database;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.widget.Toast;

import java.util.ArrayList;

public class DB_Manager extends SQLiteOpenHelper {
    static    String name ="app_DB";
    static final String TABLE_USER="users";
    static int version =1;
    ArrayList<Users> arrUsers=new ArrayList<>();
    SQLiteDatabase db;
    public DB_Manager(Context context) {
           super(context,name,null, version);

    }
    long addToDB(String table,ContentValues C){
        db=this.getWritableDatabase();



long zz=db.insert(table,null,C);

//        db.execSQL("INSERT INTO users VALUES (NULL,'Ziad','passz',1 );");
//        db.execSQL("INSERT INTO users VALUES (NULL,'Mohammed','passm',1 );");
//        db.execSQL("INSERT INTO users VALUES (NULL,'Zayed','passd',1 );");
//        db.execSQL("INSERT INTO users VALUES (NULL,'Abdullah','passa',1 );");
//        db.execSQL("INSERT INTO users VALUES (NULL,'Lutf','passf',1 );");
        return zz;
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL("CREATE TABLE "+TABLE_USER+" (u_id INTEGER PRIMARY KEY AUTOINCREMENT , " +
                "u_name VARCHAR NOT NULL, u_pass VARCHAR NOT NULL," +
                "u_type INTEGER )");
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {

    }


    public ArrayList<Users> feche(){
    SQLiteDatabase read_user_db=this.getReadableDatabase();

        Cursor c = read_user_db.rawQuery("SELECT * FROM users ", null);
//        String s=c.getString(1);

       c.moveToFirst();
        do {
            arrUsers.add(new Users(c.getString(1),c.getString(2),c.getString(3)));
        } while(c.moveToNext());

        return arrUsers;

    }
}
