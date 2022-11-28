package com.example.homework13_14;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Toast;

import com.example.homework13_14.databinding.ActivityMainBinding;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    ActivityMainBinding binding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityMainBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        binding.registerButton.setOnClickListener(this);
    }

    @Override
    public void onClick(View view) {
        String password = binding.passwordInput.getText().toString();
        String email = binding.emailInput.getText().toString();
        if (email.length() == 0) {
            Toast.makeText(this, "Вы не ввели почту", Toast.LENGTH_SHORT).show();
            Log.e("HOMEWORK_APLICATION_TAG","try to input empty email");
        }
        else if (password.length() == 0) {
            Toast.makeText(this, "Вы не ввели пароль", Toast.LENGTH_SHORT).show();
            Log.e("HOMEWORK_APLICATION_TAG","try to input empty password");
        }
        else if (!email.contains("@")) {
            Toast.makeText(this, "Невозможно ввести почту без @", Toast.LENGTH_SHORT).show();
            Log.e("HOMEWORK_APLICATION_TAG","try to input email without @");
        }
        else if (password.length() < 8) {
            Toast.makeText(this, "Пароль должен быть больше 8 символов", Toast.LENGTH_SHORT).show();
            Log.e("HOMEWORK_APLICATION_TAG","try to input short password");
        }
        else if (email.equals("rickroll@gmail.com") && !password.equals("RickAstley")) {
            Toast.makeText(this, "Did you just give up?", Toast.LENGTH_SHORT).show();
            Log.wtf("HOMEWORK_APLICATION_TAG","try to became Rick Astley");
        }
        else {
            Intent intent = new Intent(MainActivity.this, ResultActivity.class);
            if (email.equals("rickroll@gmail.com")) {
                email = "Rick Astley";
            }
            intent.putExtra("email", email);
            startActivity(intent);
            Log.i("HOMEWORK_APLICATION_TAG",String.format("new registration with email: %s and password: %s", email, password));
            finish();
        }
    }
}