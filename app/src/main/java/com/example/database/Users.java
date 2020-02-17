package com.example.database;

import android.content.ContentValues;

public class Users {
   private int id;
   private String name ,pass ,email;
    private   ContentValues CV=new ContentValues();


    public ContentValues getCV() {
        //  CV.put("u_id",1);
        CV.put("u_name",name);
        CV.put("u_pass",pass);
        CV.put("u_type",email);
        return CV;
    }



    public Users( String name, String pass, String email) {

        this.email = email;
        this.name = name;
        this.pass = pass;
    }

    public int getId() {
        return id;
    }

    public String getEmail() {
        return email;
    }

    public String getName() {
        return name;
    }

    public String getPass() {
        return pass;
    }
}
