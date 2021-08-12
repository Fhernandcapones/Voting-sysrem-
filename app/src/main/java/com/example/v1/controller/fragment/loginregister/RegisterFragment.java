package com.example.v1.controller.fragment.loginregister;


import android.os.Bundle;
import android.os.CountDownTimer;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnFocusChangeListener;
import android.view.ViewGroup;
import android.widget.Button;

import androidx.core.content.ContextCompat;
import androidx.fragment.app.Fragment;


import com.airbnb.lottie.LottieAnimationView;
import com.example.v1.R;
import com.google.android.material.textfield.TextInputEditText;
import com.google.android.material.textfield.TextInputLayout;

public class RegisterFragment extends Fragment {

    private TextInputEditText username, completeName, email, firstPassword, confirmPassword;
    private TextInputLayout usernameLayout, completenameLayout, emailLayout, firstPasswordLayout, confirmPasswordLayout;
    private Button registerButton;
    private LottieAnimationView lottieAnimationView;
    private CountDownTimer countTimer;
    public RegisterFragment() {
        // Required empty public constructor
    }

    private final OnFocusChangeListener focusChangeListener = new OnFocusChangeListener() {

        @Override
        public void onFocusChange(View v, boolean hasFocus) {
            if (hasFocus) {
                validateOnFocus(v);
                v.setBackground(ContextCompat.getDrawable(getContext(), R.drawable.text_field_active));
            } else {
                validateOnNotFocus(v);
                v.setBackground(ContextCompat.getDrawable(getContext(), R.drawable.text_field_not_active));
            }
        }
    };


    private void init(View view) {
        username = view.findViewById(R.id.reg_username);
        completeName = view.findViewById(R.id.reg_full_name);
        email = view.findViewById(R.id.reg_email);
        firstPassword = view.findViewById(R.id.reg_password);
        confirmPassword = view.findViewById(R.id.reg_retype_password);

        usernameLayout = view.findViewById(R.id.reg_username_text_layout);
        completenameLayout = view.findViewById(R.id.reg_full_name_text_layout);
        emailLayout = view.findViewById(R.id.reg_email_text_layout);
        firstPasswordLayout = view.findViewById(R.id.reg_password_text_layout);
        confirmPasswordLayout = view.findViewById(R.id.reg_retype_password_text_layout);
        registerButton = view.findViewById(R.id.reg_button);
        lottieAnimationView = view.findViewById(R.id.imageAnimation);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_register, container, false);
        init(view);
        sleep();
        attachListeners(view);
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


    public void attachListeners(View view) {
        username.setOnFocusChangeListener(focusChangeListener);
        completeName.setOnFocusChangeListener(focusChangeListener);
        email.setOnFocusChangeListener(focusChangeListener);
        firstPassword.setOnFocusChangeListener(focusChangeListener);
        confirmPassword.setOnFocusChangeListener(focusChangeListener);
        registerButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                /*THIS IS OTP FRAGMENT VALIDATION */
                validateInputs(v);
            }
        });

    }

    public void validateInputs(View view) {

        String usernameText = username.getText().toString().trim();
        String fullnameText = completeName.getText().toString().trim();
        String emailText = email.getText().toString().trim();
        String firstPasswordText = firstPassword.getText().toString().trim();
        String confirmPasswordText = confirmPassword.getText().toString().trim();


        if (usernameText.isEmpty() && !username.isFocused()) {
            setErrorOnField(usernameLayout);
        }else if(usernameText.isEmpty() && username.isFocused()){
            fixInputLayout(usernameLayout);
        } else{
            fixInputLayout(usernameLayout);
        }

        if (fullnameText.isEmpty() && !completeName.isFocused()) {
            setErrorOnField(completenameLayout);
        }else if (fullnameText.isEmpty() && completeName.isFocused()){
            fixInputLayout(completenameLayout);
        }else{
            fixInputLayout(completenameLayout);
        }

        if (emailText.isEmpty() && !email.isFocused()) {
            setErrorOnField(emailLayout);
        }else if (emailText.isEmpty() && email.isFocused()){
            fixInputLayout(emailLayout);
        }else{
            fixInputLayout(emailLayout);
        }

        if (firstPasswordText.isEmpty() && !firstPassword.isFocused()) {
            setErrorOnField(firstPasswordLayout);
        }else if (firstPasswordText.isEmpty() && firstPassword.isFocused()){
            fixInputLayout(firstPasswordLayout);
        } else{
            fixInputLayout(firstPasswordLayout);
        }

        if (confirmPasswordText.isEmpty() && !confirmPassword.isFocused()) {
            setErrorOnField(confirmPasswordLayout);
        }else if (confirmPasswordText.isEmpty() && confirmPassword.isFocused()){
            fixInputLayout(confirmPasswordLayout);
        }else{
            fixInputLayout(confirmPasswordLayout);
        }

    }

    public boolean checkIfEmpty(TextInputEditText field){
        return field.getText().toString().isEmpty();
    }

    public void setErrorOnField(TextInputLayout layout){
        layout.setError("Field cannot be emtpy");
    }

    public void fixInputLayout(TextInputLayout layout){
        layout.setError(null);
        layout.setErrorEnabled(false);
    }

    public void validateOnFocus(View v){
        if (v.equals(username)) {
            usernameLayout.setErrorEnabled(false);
        }
        if (v.equals(completeName)) {
            completenameLayout.setErrorEnabled(false);
        }
        if (v.equals(email)) {
            emailLayout.setErrorEnabled(false);
        }
        if (v.equals(firstPassword)) {
            firstPasswordLayout.setErrorEnabled(false);
        }
        if (v.equals(confirmPassword)) {
            confirmPasswordLayout.setErrorEnabled(false);
        }
    }

    public void validateOnNotFocus(View v){
//        if(v.getClass().getName().equalsIgnoreCase("android.widget.TextInputEditText")){
//            TextInputEditText input = (TextInputEditText) v;
//            TextInputLayout inputLayout = (TextInputLayout) v;
//            if(checkIfEmpty(input)){
//                setErrorOnField(inputLayout);
//                inputLayout.setErrorEnabled(true);
//            }
//        }
        if (v.equals(username) && checkIfEmpty(username)) {
            setErrorOnField(usernameLayout);
            usernameLayout.setErrorEnabled(true);
        }
        if (v.equals(completeName) && checkIfEmpty(completeName)) {
            setErrorOnField(completenameLayout);
            completenameLayout.setErrorEnabled(true);
        }
        if (v.equals(email) && checkIfEmpty(email)) {
            setErrorOnField(emailLayout);
            emailLayout.setErrorEnabled(true);
        }
        if (v.equals(firstPassword) && checkIfEmpty(firstPassword)) {
            setErrorOnField(firstPasswordLayout);
            firstPasswordLayout.setErrorEnabled(true);
        }
        if (v.equals(confirmPassword) && checkIfEmpty(confirmPassword)) {
            setErrorOnField(confirmPasswordLayout);
            confirmPasswordLayout.setErrorEnabled(true);
        }
    }
}
