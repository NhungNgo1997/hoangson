package com.hoangson.hoangson;

import android.content.SharedPreferences;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.support.v4.view.ViewPager;
import android.util.Log;
import android.view.View;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.widget.ImageView;
import android.widget.Toast;

import com.hoangson.hoangson.Adapter.MyAdapterViewpager;
import com.hoangson.hoangson.Fragment.FragmentHome;
import com.hoangson.hoangson.Fragment.FragmentLyric;
import com.hoangson.hoangson.Fragment.FramentListmusic;
import com.hoangson.hoangson.Interface.Datasend;
import com.hoangson.hoangson.Model.ListMusic;
import com.hoangson.hoangson.Model.Test;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity implements Datasend {
    SharedPreferences ginho;
    MediaPlayer mediaPlayer;
    ViewPager viewpager;
    MyAdapterViewpager myAdapterViewpager;

    ImageView imgrandom, imgskipprevious, imgskipnext, imgplay, imgrepeat;
    public static ArrayList<ListMusic> listMusicArrayList = new ArrayList<>();

    private FragmentHome fragmentHome;
    private FramentListmusic framentListmusic;
    private FragmentLyric fragmentLyric;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        viewpager = findViewById(R.id.viewpager);
        myAdapterViewpager = new MyAdapterViewpager(getSupportFragmentManager());

        myAdapterViewpager.addFragment(framentListmusic = FramentListmusic.newInstance());
        myAdapterViewpager.addFragment(fragmentHome = FragmentHome.newInstance());
        myAdapterViewpager.addFragment(fragmentLyric = FragmentLyric.newInstance());

        viewpager.setAdapter(myAdapterViewpager);
        imgplay = findViewById(R.id.imgplay);
        imgrandom = findViewById(R.id.imgrandom);
        imgskipprevious = findViewById(R.id.imgskipprevious);
        imgskipnext = findViewById(R.id.imgskipnext);
        imgrepeat = findViewById(R.id.imgrepeat);

    }

    @Override
    public void send(final List<ListMusic> listMusic, final int vitri) {
        listMusicArrayList.addAll(listMusic);
        even(vitri);
    }

    private void play(int hihi) {

        mediaPlayer = MediaPlayer.create(this, listMusicArrayList.get(hihi).getLink());
        Test.listMusics = listMusicArrayList.get(hihi);
    }

    private void even(final int vitr) {
        Log.e("Check even", vitr + "");
        if (Test.vitri == -1) {
            mediaPlayer.stop();
        }
        if (listMusicArrayList != null) {
            Log.e("Check event", "go list");
            Bundle bundle = new Bundle();
            if (fragmentHome != null) {
                Log.e("Check event", "send to home");
                fragmentHome.play(listMusicArrayList.get(vitr));
            }

            play(vitr);
            mediaPlayer.start();
            imgplay.setImageResource(R.drawable.ic_pause);
            imgplay.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    if (mediaPlayer.isPlaying()) {
                        mediaPlayer.pause();
                        imgplay.setImageResource(R.drawable.ic_play);
                    } else {
                        mediaPlayer.start();
                        imgplay.setImageResource(R.drawable.ic_pause);
                    }
                }
            });
        }

        imgskipnext.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mediaPlayer.stop();
                play(++Test.vitri);
                mediaPlayer.start();
                Toast.makeText(MainActivity.this, "hihi", Toast.LENGTH_SHORT).show();
            }
        });
        imgskipprevious.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mediaPlayer.stop();
                play(--Test.vitri);
                mediaPlayer.start();
            }
        });

    }
}
