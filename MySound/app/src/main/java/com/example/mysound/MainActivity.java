package com.example.mysound;

import android.media.SoundPool;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    Button btnSound;

    SoundPool sp;
    int soundId;
    boolean spLoaded = false;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        btnSound = findViewById(R.id.btn_soundpool);
        btnSound.setOnClickListener(myListener);

        sp= new SoundPool.Builder()
                .setMaxStreams(10)
                .build();
        sp.setOnLoadCompleteListener(new SoundPool.OnLoadCompleteListener() {
            public void onLoadComplete(SoundPool soundPool, int sampleId, int status) {
                if (status == 0) {
                    spLoaded = true;
                } else {
                    Toast.makeText(MainActivity.this, "Gagal load", Toast.LENGTH_SHORT).show();
                }
            }
        });
        soundId = sp.load(this, R.raw.police_siren, 1);

    }

    View.OnClickListener myListener = new View.OnClickListener() {
        @Override
        public void onClick(View v) {
            if (spLoaded) {
                sp.play(soundId, 1, 1, 0, 0, 1);
            }
        }
    };
}
