package com.example.muhtadi.berita;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;

public class detail extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail);

        TextView title = (TextView)findViewById(R.id.title_detail);
        TextView desc = (TextView)findViewById(R.id.news_description_detail);
        ImageView imageView = (ImageView)findViewById(R.id.sports_image_detail);

        //set title and desc
        title.setText(getIntent().getStringExtra("title"));
        desc.setText(getIntent().getStringExtra("desc"));

        //set image
        Glide.with(this).load(getIntent().getIntExtra("gambar", 0)).into(imageView);

    }
}
