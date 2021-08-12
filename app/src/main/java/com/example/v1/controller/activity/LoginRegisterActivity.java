package com.example.v1.controller.activity;

import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;
import androidx.viewpager.widget.ViewPager;

import com.example.v1.R;
import com.example.v1.adapter.LoginAndRegisterAdapter;
import com.example.v1.controller.fragment.loginregister.LoginFragment;
import com.example.v1.controller.fragment.loginregister.RegisterFragment;


public class LoginRegisterActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        ViewPager viewPager = findViewById(R.id.viewPager);

        LoginAndRegisterAdapter pagerAdapter = new LoginAndRegisterAdapter(getSupportFragmentManager());
        pagerAdapter.addFragment(new LoginFragment());
        pagerAdapter.addFragment(new RegisterFragment());


        viewPager.setAdapter(pagerAdapter);
    }


}