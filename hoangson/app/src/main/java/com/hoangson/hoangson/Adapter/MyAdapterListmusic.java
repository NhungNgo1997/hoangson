package com.hoangson.hoangson.Adapter;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.hoangson.hoangson.Fragment.FramentListmusic;
import com.hoangson.hoangson.Interface.SetOnItemclickListener;
import com.hoangson.hoangson.Model.ListMusic;
import com.hoangson.hoangson.Model.Test;
import com.hoangson.hoangson.R;

import java.util.List;

public class MyAdapterListmusic extends RecyclerView.Adapter<MyAdapterListmusic.ViewHolder> {
    private Context context;
    private List<ListMusic> list;
    private FramentListmusic framentListmusic;

    public MyAdapterListmusic(Context context, List<ListMusic> list, FramentListmusic framentListmusic) {
        this.context = context;
        this.list = list;
        this.framentListmusic = framentListmusic;
    }

    @NonNull
    @Override
    public MyAdapterListmusic.ViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        return new ViewHolder((View) LayoutInflater.from(context).inflate(R.layout.itembaihat,viewGroup,false));
    }

    @Override
    public void onBindViewHolder(@NonNull MyAdapterListmusic.ViewHolder viewHolder, int i) {
        viewHolder.name.setText(list.get(i).getNamemusic());
        viewHolder.namesinger.setText(list.get(i).getNamesinger());
        viewHolder.setSetOnItemclickListener(new SetOnItemclickListener() {
            @Override
            public void onclick(View view, int posstion) {
                Test.vitri=posstion;
                framentListmusic.play(posstion);
            }
        });
    }

    @Override
    public int getItemCount() {
        return list.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener {

        private TextView name,namesinger;
        private SetOnItemclickListener setOnItemclickListener;

        public void setSetOnItemclickListener(SetOnItemclickListener setOnItemclickListener) {
            this.setOnItemclickListener = setOnItemclickListener;
        }

        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            name=itemView.findViewById(R.id.name);
            namesinger=itemView.findViewById(R.id.namesinger);
            itemView.setOnClickListener(this);
        }

        @Override
        public void onClick(View v) {
            setOnItemclickListener.onclick(v,getAdapterPosition());
        }
    }
}
