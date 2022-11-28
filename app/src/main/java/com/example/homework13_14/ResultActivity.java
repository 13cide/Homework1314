package com.example.homework13_14;

import androidx.activity.result.contract.ActivityResultContracts;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.graphics.Bitmap;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.provider.MediaStore;
import android.util.Log;
import android.view.View;
import android.widget.TextView;

import com.example.homework13_14.databinding.ActivityMainBinding;
import com.example.homework13_14.databinding.ActivityResultBinding;

public class ResultActivity extends AppCompatActivity implements View.OnClickListener{


    ActivityResultBinding binding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityResultBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());


        String email = getIntent().getStringExtra("email");
        binding.emailOutput.setText(email);
        if (email.equals("Rick Astley")) MediaPlayer.create(this, R.raw.easter_egg).start();
        binding.getPhoto.setOnClickListener(this);
    }

    private final static int MAKE_PHOTO_REQUEST = 1;

    @Override
    public void onClick(View view) {
        Intent intent = new Intent(MediaStore.ACTION_IMAGE_CAPTURE);
        startActivityForResult(intent, MAKE_PHOTO_REQUEST);
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if (requestCode == MAKE_PHOTO_REQUEST && resultCode == RESULT_OK) {
            Bundle extras = data.getExtras();
            Bitmap thumbnailBitmap = (Bitmap) extras.get("data");
            binding.image.setImageBitmap(thumbnailBitmap);
            Log.i("HOMEWORK_APLICATION_TAG", "new photo");
        }
    }
}