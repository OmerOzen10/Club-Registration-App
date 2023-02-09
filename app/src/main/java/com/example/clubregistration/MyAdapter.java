package com.example.clubregistration;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class MyAdapter extends RecyclerView.Adapter<MyAdapter.MyViewHolder> {

    Context context;

    ArrayList<Members> membersList;

    public MyAdapter(Context context, ArrayList<Members> members) {
        this.context = context;
        this.membersList = members;
    }

    @NonNull
    @Override
    public MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(context).inflate(R.layout.list_item,parent,false);
        return new MyViewHolder(v);
    }

    @Override
    public void onBindViewHolder(@NonNull MyViewHolder holder, int position) {
        Members member = membersList.get(position);
        holder.firstName.setText(member.getFirstName());
        holder.lastName.setText(member.getLastName());
        holder.club.setText(member.getClub());
        holder.email.setText(member.getEmail());
    }

    @Override
    public int getItemCount() {
        return membersList.size();
    }

    public static class MyViewHolder extends RecyclerView.ViewHolder{

        TextView firstName, lastName, email, club;


        public MyViewHolder(@NonNull View itemView) {
            super(itemView);
            firstName = itemView.findViewById(R.id.txtName);
            lastName = itemView.findViewById(R.id.txtLastName);
            email = itemView.findViewById(R.id.txtEmail);
            club = itemView.findViewById(R.id.txtClub);

        }
    }

}
