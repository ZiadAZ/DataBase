package com.example.database;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.support.annotation.NonNull;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

public class Recycler_Robot extends AppCompatActivity {
    ArrayList<Users> arrayUsers=new ArrayList<>();
    RecyclerView recyclerView;
    DB_Manager db_manager;

    ArrayList<Users> arrUsers=new ArrayList<>();
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_recycler__robot);
        recyclerView=findViewById(R.id.recycleListView);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        db_manager=new DB_Manager(this);

        //  read_user_db=db_manager.getReadableDatabase();
        arrayUsers=db_manager.feche();
    Toast.makeText(this,arrayUsers.get(0).getName(),Toast.LENGTH_SHORT).show();
Adapter adapter=new Adapter(arrayUsers,this);
recyclerView.setAdapter(adapter);

    }

    class Adapter extends RecyclerView.Adapter<UsersViewHolder>{
        List<Users> listUsers;
        Context ctx;

        public Adapter(List<Users> lUsers,Context ctx) {
            this.listUsers = lUsers;
            this.ctx = ctx;
        }

        @NonNull
        @Override
        public UsersViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
            View view= LayoutInflater.from(ctx).inflate(R.layout.user_template,viewGroup,false);
            return new UsersViewHolder(view);
        }

        @Override
        public void onBindViewHolder(@NonNull UsersViewHolder usersViewHolder, int i) {
            usersViewHolder.t_name.setText(listUsers.get(i).getName());
            usersViewHolder.t_pass.setText(listUsers.get(i).getPass());
            usersViewHolder.t_type.setText(listUsers.get(i).getEmail());
        }

        @Override
        public int getItemCount() {
            return listUsers.size();
        }


    }
    class UsersViewHolder extends RecyclerView.ViewHolder{
        TextView t_name,t_pass,t_type;
        public UsersViewHolder(@NonNull View itemView) {
            super(itemView);
            t_name=itemView.findViewById(R.id.u_name);
            t_pass=itemView.findViewById(R.id.u_pass);
            t_type=itemView.findViewById(R.id.u_type);

        }
    }

}

