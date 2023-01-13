package com.example.a201913709048;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class MessageAdapter extends RecyclerView.Adapter<MessageAdapter.MyViewHolder>{

    Context context;
    ArrayList<MessageModel> list;

    public MessageAdapter(Context context, ArrayList<MessageModel> list) {
        this.context = context;
        this.list = list;
    }

    @NonNull
    @Override
    public MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(context).inflate(R.layout.item,parent,false);
        return new MyViewHolder(v);
    }

    @Override
    public void onBindViewHolder(@NonNull MyViewHolder holder, int position) {

        MessageModel Messagemodel = list.get(position);
        holder.mesajBaslik.setText(Messagemodel.getMesajBaslik());
        holder.mesajIcerik.setText(Messagemodel.getMesajIcerik());
    }

    @Override
    public int getItemCount() {
        return list.size();
    }

    public static class MyViewHolder extends RecyclerView.ViewHolder{

        TextView mesajBaslik, mesajIcerik;
        public MyViewHolder(@NonNull View itemView) {
            super(itemView);
            mesajBaslik = itemView.findViewById(R.id.tvGrupAdi);
            mesajIcerik = itemView.findViewById(R.id.tvGrupAciklama);
        }
    }

}
