package com.example.harishawallpaperchange;

import androidx.appcompat.app.AppCompatActivity;

import android.app.WallpaperManager;
import android.graphics.BitmapFactory;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;


import java.io.IOException;

import java.util.Timer;
import java.util.TimerTask;


public class MainActivity extends AppCompatActivity {
    int images[] = new int[]{ R.drawable.r1, R.drawable.r2,R.drawable.r3, R.drawable.r4, R.drawable.r5, R.drawable.r6};
    Button btn;
    int i=0;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        btn = findViewById(R.id.btn);
        btn.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v)
            {
                new Timer().schedule(new ChangeWallpaper(),0,3000);
            }
        });

    }
    class ChangeWallpaper extends TimerTask {
        //@SuppressLint("MissingPermission")
        @Override
        public void run() {
            WallpaperManager wallpaperManager = WallpaperManager.getInstance(getBaseContext());
            try
            {
                wallpaperManager.setBitmap(BitmapFactory.decodeResource(getResources(),images[i]));
                i++;
                if(i==6)
                {
                    i=0;
                }
            }
            catch (IOException e)
            {
                e.printStackTrace();
            }
        }
    }


}