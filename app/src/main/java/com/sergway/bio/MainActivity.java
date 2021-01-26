package com.sergway.bio;

import androidx.appcompat.app.AppCompatActivity;
import androidx.databinding.DataBindingUtil;

import android.content.Context;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.view.inputmethod.InputMethodManager;

import com.sergway.bio.data.Bio;
import com.sergway.bio.databinding.ActivityMainBinding;

public class MainActivity extends AppCompatActivity {
    private ActivityMainBinding binding;
    private final Bio bio = new Bio();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = DataBindingUtil.setContentView(this, R.layout.activity_main);
        bio.setName("Sergway Khodyachikh");

        binding.setBio(bio);
        binding.doneButton.setOnClickListener(this::addHobbies);
    }

    public void addHobbies(View view) {
        bio.setHobbies(String.format("Hobbies: %s",
                binding.enterHobbies.getText().toString().trim()));

//        binding.hobbiesText.setText(String.format("Hobbies: %s",
//                binding.enterHobbies.getText().toString().trim()));

        binding.invalidateAll();
        binding.hobbiesText.setVisibility(View.VISIBLE);
        // hide keyboard
        InputMethodManager inputMethodManager = (InputMethodManager) getSystemService(Context.INPUT_METHOD_SERVICE);
        inputMethodManager.hideSoftInputFromWindow(view.getWindowToken(), 0);
    }
}