package com.tourisa.fragments;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

import com.facebook.AccessToken;
import com.facebook.CallbackManager;
import com.facebook.FacebookCallback;
import com.facebook.FacebookException;
import com.facebook.FacebookSdk;
import com.facebook.GraphRequest;
import com.facebook.appevents.AppEventsLogger;
import com.facebook.login.LoginManager;
import com.facebook.login.LoginResult;
import com.facebook.login.widget.LoginButton;
import com.tourisa.R;

import org.json.JSONException;

import java.util.Collections;
import java.util.Objects;

public class LoginScreenFragment extends Fragment {
    private static final String EMAIL = "email";
    private LoginButton facebookLoginButton;
    private CallbackManager callbackManager;

    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_login, container, false);
        callbackManager = CallbackManager.Factory.create();

        facebookLoginButton = view.findViewById(R.id.facebook_login_draft_button);
        facebookLoginButton.setFragment(this);
        facebookLoginButton.setReadPermissions(Collections.singletonList(EMAIL));
        ImageView loginButton = view.findViewById(R.id.facebook_login_button);
        loginButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                facebookLoginButton.performClick();
            }
        });
        FacebookSdk.sdkInitialize(Objects.requireNonNull(getActivity()).getApplication());
        AppEventsLogger.activateApp(getActivity().getApplication());
        facebookLoginButton.registerCallback(callbackManager, new FacebookCallback<LoginResult>() {
            @Override
            public void onSuccess(LoginResult loginResult) {
                LoginManager.getInstance().logOut();
                Log.e("onSuccess", "success");
                AccessToken accessToken = loginResult.getAccessToken();
                Log.e("onSuccess", String.valueOf(loginResult.getAccessToken()));
                Log.e("onSuccess", EMAIL);
                useLoginInformation(accessToken);
            }

            @Override
            public void onCancel() {
                Log.e("onCancel", EMAIL);
            }

            @Override
            public void onError(FacebookException exception) {
                Log.e("onError", exception.getMessage());
            }
        });
        return view;
    }

    private void useLoginInformation(AccessToken accessToken) {
        GraphRequest request = GraphRequest.newMeRequest(accessToken, (object, response) -> {
            try {
                String name = object.getString("name");
                String email = object.getString("email");
                String image = object.getJSONObject("picture").getJSONObject("data").getString("url");
                String providerName = "facebook";
                Log.e("onCompleted", name);
                Log.e("onCompleted", email);
                Log.e("onCompleted", image);
                String profileID = null;
//                profileID = Profile.getCurrentProfile().getId();
//                Log.e("profile id", profileID);
            } catch (JSONException e) {
                e.printStackTrace();
            }
        });
        Bundle parameters = new Bundle();
        parameters.putString("fields", "id,name,email,picture.width(200)");
        request.setParameters(parameters);
        request.executeAsync();
    }

    private void loadFragment(Fragment fragment) {
        FragmentManager fragmentManager = getActivity().getSupportFragmentManager();
        FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
        fragmentTransaction.replace(R.id.main_fragment, fragment);
        fragmentTransaction.addToBackStack(null);
        fragmentTransaction.commit();
    } // Callback registration

    @Override
    public void onActivityResult(int requestCode, int resultCode, Intent data) {
        callbackManager.onActivityResult(requestCode, resultCode, data);
        super.onActivityResult(requestCode, resultCode, data);
    }
}