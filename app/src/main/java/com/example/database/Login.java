package com.example.database;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class Login extends AppCompatActivity {
EditText tName,tEmail,tPass;
DB_Manager db_manager=new DB_Manager(this);
Button bReg,bShow;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        tEmail=findViewById(R.id.email);
        tName=findViewById(R.id.name);
        tPass=findViewById(R.id.pass);
        bReg=findViewById(R.id.regB);
        bShow=findViewById(R.id.showB);
        bReg.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Users u=new Users(tName.getText().toString(),tPass.getText().toString(),tEmail.getText().toString());
               long g= db_manager.addToDB(db_manager.TABLE_USER,u.getCV());
                Toast.makeText(Login.this, g+"", Toast.LENGTH_SHORT).show();
            }
        });
        bShow.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i=new Intent(Login.this, Recycler_Robot.class);
                startActivity(i);
            }
        });


    }

}
