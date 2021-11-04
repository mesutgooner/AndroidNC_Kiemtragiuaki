package com.ngoclm.trinhnghenhac;

import androidx.appcompat.app.AppCompatActivity;

import android.app.Activity;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.widget.Button;
import android.widget.TextView;

import com.ngoclm.trinhnghenhac.global.GlobalData;

import java.util.concurrent.TimeUnit;

public class SongBrowseActivity extends AppCompatActivity {
    TextView tvSongBrowseNumber;
    Button btn1;
    Button btn2;
    Button btn3;
    Button btn4;
    Button btn5;
    Button btn6;
    Button btnToPlay;
    Integer duration;
    
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_song_browse);
        getViews();
        setTitle("Chọn bài hát");
        onClick();
    }

    private void getViews() {
        tvSongBrowseNumber = findViewById(R.id.tvSongBrowseNumber);
        btn1= findViewById(R.id.btn1);
        btn2 = findViewById(R.id.btn2);
        btn3 = findViewById(R.id.btn3);
        btn4 = findViewById(R.id.btn4);
        btn5 = findViewById(R.id.btn5);
        btn6 = findViewById(R.id.btn6);
        btnToPlay = findViewById(R.id.btnToPlay);
    }

    private void onClick(){
        btn1.setOnClickListener(v -> {
            tvSongBrowseNumber.setText("1");
            GlobalData.player = MediaPlayer.create(this,R.raw.fiction);
            GlobalData.number=1;
            GlobalData.name="Fiction";
            duration = GlobalData.player.getDuration();
            GlobalData.duration = String.format("%d min, %d sec",
                    TimeUnit.MILLISECONDS.toMinutes(duration),
                    TimeUnit.MILLISECONDS.toSeconds(duration)-TimeUnit.MINUTES.toSeconds(TimeUnit.MILLISECONDS.toMinutes(duration)));
        });
        btn2.setOnClickListener(v -> {
            tvSongBrowseNumber.setText("2");
            GlobalData.player = MediaPlayer.create(this,R.raw.hoasua);
            GlobalData.number=2;
            GlobalData.name="Hoa Sữa";
            duration = GlobalData.player.getDuration();
            GlobalData.duration = String.format("%d min, %d sec",
                    TimeUnit.MILLISECONDS.toMinutes(duration),
                    TimeUnit.MILLISECONDS.toSeconds(duration)-TimeUnit.MINUTES.toSeconds(TimeUnit.MILLISECONDS.toMinutes(duration)));
        });
        btn3.setOnClickListener(v -> {
            tvSongBrowseNumber.setText("3");
            GlobalData.player = MediaPlayer.create(this,R.raw.lies);
            GlobalData.number=3;
            GlobalData.name="Lies";
            duration = GlobalData.player.getDuration();
            GlobalData.duration = String.format("%d min, %d sec",
                    TimeUnit.MILLISECONDS.toMinutes(duration),
                    TimeUnit.MILLISECONDS.toSeconds(duration)-TimeUnit.MINUTES.toSeconds(TimeUnit.MILLISECONDS.toMinutes(duration)));
        });
        btn4.setOnClickListener(v -> {
            tvSongBrowseNumber.setText("4");
            GlobalData.player = MediaPlayer.create(this,R.raw.mistaken);
            GlobalData.number=4;
            GlobalData.name="Mistaken";
            duration = GlobalData.player.getDuration();
            GlobalData.duration = String.format("%d min, %d sec",
                    TimeUnit.MILLISECONDS.toMinutes(duration),
                    TimeUnit.MILLISECONDS.toSeconds(duration)-TimeUnit.MINUTES.toSeconds(TimeUnit.MILLISECONDS.toMinutes(duration)));
        });
        btn5.setOnClickListener(v -> {
            tvSongBrowseNumber.setText("5");
            GlobalData.player = MediaPlayer.create(this,R.raw.poison);
            GlobalData.number=5;
            GlobalData.name="Poison";
            duration = GlobalData.player.getDuration();
            GlobalData.duration = String.format("%d min, %d sec",
                    TimeUnit.MILLISECONDS.toMinutes(duration),
                    TimeUnit.MILLISECONDS.toSeconds(duration)-TimeUnit.MINUTES.toSeconds(TimeUnit.MILLISECONDS.toMinutes(duration)));
        });
        btn6.setOnClickListener(v -> {
            tvSongBrowseNumber.setText("6");
            GlobalData.player = MediaPlayer.create(this,R.raw.quabanh);
            GlobalData.number=6;
            GlobalData.name="Quá bảnh";
            duration = GlobalData.player.getDuration();
            GlobalData.duration = String.format("%d min, %d sec",
                    TimeUnit.MILLISECONDS.toMinutes(duration),
                    TimeUnit.MILLISECONDS.toSeconds(duration)-TimeUnit.MINUTES.toSeconds(TimeUnit.MILLISECONDS.toMinutes(duration)));
        });
        btnToPlay.setOnClickListener(v -> {
            if (GlobalData.player!=null){
                setResult(Activity.RESULT_OK);
                finish();
            }
        });
    }
}