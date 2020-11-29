package com.example.fragmenttest;

import android.app.Activity;
import android.os.Bundle;
import android.os.Handler;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;

public class StopwatchFragment extends Fragment {

    private int seconds = 0;
    private boolean running = false;
    private boolean wasRunning = false;
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        if(savedInstanceState != null){
            seconds = savedInstanceState.getInt("seconds");
            running = savedInstanceState.getBoolean("running");
        }

    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View layout = inflater.inflate(R.layout.fragment_stopwatch,container,false);
        Button startButton = layout.findViewById(R.id.start_button);
        startButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                onClickStart();
            }
        });
        Button stopButton = layout.findViewById(R.id.stop_button);
        stopButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                onClickStop();
            }
        });
      Button resetButton = layout.findViewById(R.id.reset_button);
        resetButton.setOnClickListener(new View.OnClickListener() {
           @Override
           public void onClick(View view) {
               onClickReset();
           }
       });
        runTimer(layout);
                return layout;
    }

    @Override
    public void onStop(){
        super.onStop();
        wasRunning = running;
        running = false;

    }

    @Override
    public void onStart(){
        super.onStart();
        if(wasRunning == true){
            running = true;
        }
    }

    @Override
    public void onSaveInstanceState(Bundle savedInstanceState) {
        super.onSaveInstanceState(savedInstanceState);
        savedInstanceState.putInt("seconds", seconds);
        savedInstanceState.putBoolean("running", running);

    }

    public void onClickStart(){
        running = true;
    }

    public void onClickStop(){
         running = false;
    }

    public void onClickReset(){
         running = false;
         seconds = 0;
    }

    public void runTimer(View view){
        final TextView textView = view.findViewById(R.id.clock_view);
        final Handler handler = new Handler();
        handler.post(new Runnable() {
            @Override
            public void run() {

                int hours = seconds/3600;
                int minutes = (seconds%3600)/60;
                int secs = seconds%60;

                String time = String.format("%d:%02d:%02d",hours,minutes,secs);
                textView.setText(time);

                if(running){
                    seconds++;
                }
                handler.postDelayed(this,1000);
            }
        });

    }
}