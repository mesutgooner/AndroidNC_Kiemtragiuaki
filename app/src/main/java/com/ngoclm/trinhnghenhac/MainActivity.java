package com.ngoclm.trinhnghenhac;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import android.app.Activity;
import android.content.Intent;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.widget.Button;
import android.widget.TextView;

import com.ngoclm.trinhnghenhac.global.GlobalData;

public class MainActivity extends AppCompatActivity {
    TextView tvSongNumber;
    TextView tvSongName;
    TextView tvSongDuration;
    Button btnSelect;
    Button btnPlay;
    Button btnPause;
    MediaPlayer playing;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        getViews();
        setTitle("Trình Nghe Nhạc");
    }

    private void getViews() {
        tvSongNumber = findViewById(R.id.tvSongNumber);
        tvSongName = findViewById(R.id.tvSongName);
        tvSongDuration = findViewById(R.id.tvSongDuration);
        btnSelect = findViewById(R.id.btnSelect);
        btnPlay = findViewById(R.id.btnPlay);
        btnPause = findViewById(R.id.btnPause);

        btnSelect.setOnClickListener(v -> {
            Intent browseIntent = new Intent(this, SongBrowseActivity.class);
            startActivityForResult(browseIntent, 200);
        });

        btnPlay.setOnClickListener(v -> {
            if (GlobalData.player != null) {
                if (playing != null) {
                    if (playing.isPlaying()) {
                        if (playing != GlobalData.player) {
                            playing.stop();
                        }
                    }
                }
                playing = GlobalData.player;
                playing.start();
            }
        });
        btnPause.setOnClickListener(v -> {
            if (playing != null) {
                if (playing.isPlaying()) {
                    playing.pause();
                }
            }
        });
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if (requestCode == 200) {
            if (resultCode == Activity.RESULT_OK) {
                if (GlobalData.player != null) {
                    tvSongName.setText(GlobalData.name);
                    tvSongDuration.setText(GlobalData.duration);
                    tvSongNumber.setText(GlobalData.number.toString());
                }

            }
        }
    }
}