package com.example.tae.second_assignment;

import android.content.Intent;
import android.media.AudioManager;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.design.widget.BottomNavigationView;
import android.support.v4.widget.SwipeRefreshLayout;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.MenuItem;
import android.widget.TextView;
import android.widget.Toast;

import com.example.tae.second_assignment.network.AppDataManager;
import com.example.tae.second_assignment.network.model.Music_Model;
import com.example.tae.second_assignment.network.model.OnItemClickListener;
import com.example.tae.second_assignment.network.model.Result;
import com.example.tae.second_assignment.ui.Classic_Music.ClassicMusicPresenter;
import com.example.tae.second_assignment.ui.Classic_Music.IClassicMusicMvpView;
import com.example.tae.second_assignment.ui.utils.rx.AppSchedulerProvider;

import java.io.IOException;

import io.reactivex.disposables.CompositeDisposable;

public class ClassicMusicActivity extends AppCompatActivity implements IClassicMusicMvpView {
    SwipeRefreshLayout mySwipeRefreshLayout;
    private TextView mTextMessage;
    ClassicMusicPresenter<IClassicMusicMvpView> classicMusicPresenterClassicMusicPresenter;
    private RecyclerView recyclerView;
    private BottomNavigationView.OnNavigationItemSelectedListener mOnNavigationItemSelectedListener
            = new BottomNavigationView.OnNavigationItemSelectedListener() {

        @Override
        public boolean onNavigationItemSelected(@NonNull MenuItem item) {
            switch (item.getItemId()) {
                case R.id.navigation_home:
                    Intent intent = new Intent(ClassicMusicActivity.this, MainActivity.class);
                    startActivity(intent);
                case R.id.navigation_dashboard:

                case R.id.navigation_notifications:
                    Intent intentPop = new Intent(ClassicMusicActivity.this, ClassicMusicActivity.class);
                    startActivity(intentPop);
            }
            return false;
        }

    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        classicMusicPresenterClassicMusicPresenter= new ClassicMusicPresenter<>(new AppDataManager(), new AppSchedulerProvider(), new CompositeDisposable());
        classicMusicPresenterClassicMusicPresenter.onAttach(this);
        classicMusicPresenterClassicMusicPresenter.onViewPrepared();
        IClassicMusicMvpView view=this;
        BottomNavigationView navigation = (BottomNavigationView) findViewById(R.id.navigation);
        mySwipeRefreshLayout = (SwipeRefreshLayout) findViewById(R.id.swipeRefresh);
        mySwipeRefreshLayout.setOnRefreshListener(
                new SwipeRefreshLayout.OnRefreshListener() {
                    @Override
                    public void onRefresh() {
                        Log.i("Refresh", "onRefresh called from SwipeRefreshLayout");
                        classicMusicPresenterClassicMusicPresenter= new ClassicMusicPresenter<>(new AppDataManager(), new AppSchedulerProvider(), new CompositeDisposable());
                        classicMusicPresenterClassicMusicPresenter.onAttach(view);
                        classicMusicPresenterClassicMusicPresenter.onViewPrepared();
                        myUpdateOperation();
                        initialiseRecyclerView();
                    }
                }
        );
        initialiseRecyclerView();

    }
                    public void myUpdateOperation() {

                        mySwipeRefreshLayout.setRefreshing(false);}


    public void initialiseRecyclerView() {

        recyclerView = (RecyclerView) findViewById(R.id.recyclerMusic);
        recyclerView.setLayoutManager(new LinearLayoutManager(getApplicationContext()));
    }
    @Override
    public void onFetchDataCompleted(Music_Model rockMusic_model) {
        recyclerView.setAdapter(new MusicAdapter(rockMusic_model.getResults(), R.layout.list_item_movie, new OnItemClickListener() {

            @Override
            public void onItemClick(Result item) {
                Toast.makeText(getApplicationContext(),item.getArtistId().toString(),Toast.LENGTH_LONG).show();

                String url = item.getPreviewUrl(); // your URL here
                MediaPlayer mediaPlayer = new MediaPlayer();
                mediaPlayer.setAudioStreamType(AudioManager.STREAM_MUSIC);
                try {
                    mediaPlayer.setDataSource(url);
                } catch (IOException e) {
                    e.printStackTrace();
                }
                try {

                    mediaPlayer.prepare(); // might take long! (for buffering, etc)
                } catch (IOException e) {
                    e.printStackTrace();
                }


                mediaPlayer.start();
            }

        }, getApplicationContext()));
    }

    @Override
    public void showLoading() {

    }

    @Override
    public void hideLoading() {

    }

    @Override
    public void onError(String message) {

    }

    @Override
    public void showMessage(String message) {

    }

    @Override
    public boolean isNetworkConnected() {
        return false;
    }
}