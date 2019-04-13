package com.hoangson.hoangson.Fragment;

import android.media.MediaPlayer;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ProgressBar;
import android.widget.TextView;
import android.widget.Toast;

import com.hoangson.hoangson.MainActivity;
import com.hoangson.hoangson.Model.ListMusic;
import com.hoangson.hoangson.Model.Test;
import com.hoangson.hoangson.R;

public class FragmentHome extends Fragment {
    private TextView txtvnamesong, txtvnamesinger,time;
    private ProgressBar progressBar;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragmenthome, container, false);
    }

    public static FragmentHome newInstance() {

        Bundle args = new Bundle();

        FragmentHome fragment = new FragmentHome();
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        txtvnamesong = view.findViewById(R.id.tenbaihat);
        txtvnamesinger = view.findViewById(R.id.tencasi);
        time = view.findViewById(R.id.time);
        progressBar = view.findViewById(R.id.progressBar);
        Bundle bundle = getArguments();
        Log.d("DANGHIEU", MainActivity.listMusicArrayList.size() + "");
        if (bundle != null) {
            ListMusic listMusic = (ListMusic) bundle.getSerializable("Mang");

        }

        if (Test.listMusics != null) {
            txtvnamesong.setText("" + Test.listMusics.getNamemusic());
//            txtvnamesinger.setText(""+ Test.listMusics.getNamesinger());
        }
    }

    public void play(ListMusic  music) {
        Log.e("Check", "play home");
        if(isAdded()){
            Log.e("check", "isAdd");
            if(txtvnamesong!=null) txtvnamesong.setText(music.getNamemusic());
            MediaPlayer mediaPlayer = MediaPlayer.create(getContext(),music.getLink());
            int time1 = mediaPlayer.getDuration()/60000;

            time.setText(time1+"");
            progressBar.setMax(time1);


            Toast.makeText(getContext(), music.getNamemusic(),Toast.LENGTH_SHORT).show();
        }

    }
}
