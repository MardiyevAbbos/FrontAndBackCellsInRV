package com.example.frontandbackcellsinrv.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.RelativeLayout;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.frontandbackcellsinrv.R;
import com.example.frontandbackcellsinrv.model.Member;

import java.util.ArrayList;

public class MainAdapter extends RecyclerView.Adapter<RecyclerView.ViewHolder> {

    private Context context;
    private ArrayList<Member> members;

    public MainAdapter(Context context, ArrayList<Member> members) {
        this.context = context;
        this.members = members;
    }


    @Override
    public int getItemCount() {
        return members.size();
    }


    @NonNull
    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(context).inflate(R.layout.item_custom_layout, parent, false);
        return new CustomViewHolder(view);
    }


    @Override
    public void onBindViewHolder(@NonNull RecyclerView.ViewHolder holder, int position) {
        Member member = members.get(position);
        if (holder instanceof CustomViewHolder) {
            TextView name = ((CustomViewHolder) holder).name;
            name.setText(member.getName());
        }
    }


    public class CustomViewHolder extends RecyclerView.ViewHolder {
        public View view;
        public RelativeLayout background, foreground;
        public TextView name;

        CustomViewHolder(View v) {
            super(v);
            this.view = v;
            background = view.findViewById(R.id.view_background);
            foreground = view.findViewById(R.id.view_foreground);
            name = view.findViewById(R.id.tv_swipe_name);
        }
    }


}
