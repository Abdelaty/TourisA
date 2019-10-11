package com.tourisa.fragments;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

import com.tourisa.R;

public class MainLoginFragment extends Fragment {
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_main_login, container, false);
        Button loginBtn = view.findViewById(R.id.login_btn);
        Button signupBtn = view.findViewById(R.id.signup_btn);
        loginBtn.setOnClickListener(v -> loadFragment(new LoginScreenFragment()));
        signupBtn.setOnClickListener(v -> loadFragment(new SignupScreenFragment()));
//        loginBtn.setOnClickListener(view1 -> loadFragment(new LoginScreenFragment()));
//        signupBtn.setOnClickListener(view1 -> loadFragment(new SignupScreenFragment()));


        return view;
    }

    private void loadFragment(Fragment fragment) {
        FragmentManager fragmentManager = getActivity().getSupportFragmentManager();
        FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
        fragmentTransaction.replace(R.id.main_fragment, fragment);
        fragmentTransaction.addToBackStack(null);
        fragmentTransaction.commit();
    }
}
