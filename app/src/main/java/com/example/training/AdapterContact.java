package com.example.training;

import android.content.Context;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;


// ربط adapter with java xml exist code
public class AdapterContact extends RecyclerView.Adapter<AdapterContact.Holder> {
    private ArrayList<ModelContact> list;
    @NonNull
    @Override
    public Holder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view= LayoutInflater.from(parent.getContext()).inflate(R.layout.item_content,parent,false);
        return new Holder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull Holder holder, int position) {
        holder.phone.setText(list.get(position).getPhone());
        holder.name.setText(list.get(position).getName());
    }

    public void setList(ArrayList<ModelContact> list) {
        this.list = list;
    }

    @Override
    public int getItemCount() {
        return list==null?0 : list.size();
    }

    class Holder extends RecyclerView.ViewHolder{
        TextView name,phone;
        public Holder(@NonNull View itemView) {
            super(itemView);
            name=itemView.findViewById(R.id.textName);
            phone=itemView.findViewById(R.id.textPhone);
        }
    }

}
