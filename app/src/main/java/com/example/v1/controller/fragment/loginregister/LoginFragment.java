package com.example.v1.controller.fragment.loginregister;


import android.content.Intent;
import android.os.Bundle;
import android.os.CountDownTimer;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

import androidx.core.content.ContextCompat;
import androidx.fragment.app.Fragment;

import com.airbnb.lottie.LottieAnimationView;

import com.example.v1.Dashboard;
import com.example.v1.R;
import com.google.android.material.textfield.TextInputEditText;
import com.google.android.material.textfield.TextInputLayout;


public class LoginFragment extends Fragment {


    public LoginFragment() {
    }

    private Button button;
    private TextInputLayout usernameLayout;
    private TextInputLayout passwordLayout;
    private TextInputEditText password;
    private TextInputEditText username;
    private CountDownTimer countTimer;
    private LottieAnimationView lottieAnimationView;

    private void init(View view) {
        button = view.findViewById(R.id.loginButton);
        username = view.findViewById(R.id.username);
        password = view.findViewById(R.id.password);
        usernameLayout = view.findViewById(R.id.username_text_layout);
        passwordLayout = view.findViewById(R.id.password_input_layout);
        username.setOnFocusChangeListener(focusChangeListener);
        password.setOnFocusChangeListener(focusChangeListener);
        lottieAnimationView = view.findViewById(R.id.imageAnimation);
    }

    private final View.OnFocusChangeListener focusChangeListener = new View.OnFocusChangeListener() {
        @Override
        public void onFocusChange(View v, boolean hasFocus) {
            if (hasFocus) {
                v.setBackground(ContextCompat.getDrawable(getContext(), R.drawable.text_field_active));
                usernameLayout.setErrorEnabled(false);
                passwordLayout.setErrorEnabled(false);
            } else {
                v.setBackground(ContextCompat.getDrawable(getContext(), R.drawable.text_field_not_active));
            }

        }
    };

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        View view = inflater.inflate(R.layout.fragment_login,
                container, false);
        init(view);
        login(view);
        sleep();
        lottieAnimationView.cancelAnimation();
        return view;
    }

    private void sleep() {
        countTimer = new CountDownTimer(20, 20) {
            @Override
            public void onTick(long millisUntilFinished) {}
            @Override
            public void onFinish() {
                lottieAnimationView.cancelAnimation();
            }
        }.start();
    }
    private void login(View view) {
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                validateEmptyCredentials(v);

            }
        });
    }

    private void validateEmptyCredentials(View view) {
        String usernameInput = username.getText().toString().trim();
        String passwordInput = password.getText().toString().trim();
        boolean hasEmptyUsername = false;
        boolean hasEmptyPassword = false;
        if (usernameInput.isEmpty()) {
            hasEmptyUsername = true;
            Log.d("TEST", "WORKING");
            usernameLayout.setError("Username Cannot be empty");
        }
        if (passwordInput.isEmpty()) {
            hasEmptyPassword = true;
            Log.d("Password", "Empty");
            passwordLayout.setError("Password cannot be empty");
        }

        if (!hasEmptyPassword && !hasEmptyUsername) {
            Intent dashboard = new Intent(getContext(), Dashboard.class);
            startActivity(dashboard);

        }


    }


}
