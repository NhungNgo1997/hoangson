package com.hoangson.hoangson.Fragment;

import android.content.Context;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.DividerItemDecoration;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.hoangson.hoangson.Adapter.MyAdapterListmusic;
import com.hoangson.hoangson.Interface.Datasend;
import com.hoangson.hoangson.Model.ListMusic;
import com.hoangson.hoangson.R;

import java.util.ArrayList;

public class FramentListmusic extends Fragment {
    RecyclerView recyclerView;
    Datasend datasend;
    ArrayList<ListMusic> arrayList=new ArrayList<>();
    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        return inflater.inflate(R.layout.framentlistmusic,container,false);
    }

    public static FramentListmusic newInstance() {

        Bundle args = new Bundle();

        FramentListmusic fragment = new FramentListmusic();
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        recyclerView=view.findViewById(R.id.recyclerView);
        LinearLayoutManager linearLayoutManager= new LinearLayoutManager(getContext());
        recyclerView.setLayoutManager(linearLayoutManager);
        arrayList.add(new ListMusic(1,"Bai hat 1","ccc",R.raw.aaa));
        arrayList.add(new ListMusic(2,"Bai hat 2","ccc",R.raw.aaa));
        arrayList.add(new ListMusic(3,"Bai hat 3","ccc",R.raw.aaa));
        arrayList.add(new ListMusic(4,"bai hat 4","ccc",R.raw.aaa));
        arrayList.add(new ListMusic(5,"Bai hat 5","ccc",R.raw.aaa));


        recyclerView.addItemDecoration(new DividerItemDecoration(getContext(),linearLayoutManager.getOrientation()));
        recyclerView.setAdapter(new MyAdapterListmusic(getContext(),arrayList,FramentListmusic.this));

    }

    public void play(int id){
        datasend.send(arrayList,id);
    }

    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
        datasend= (Datasend) getActivity();
    }
}
