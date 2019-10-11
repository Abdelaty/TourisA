package com.tourisa;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

public class SignupScreenFragment extends Fragment {
    ImageView huawiBtn;

    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_signup, container, false);
        huawiBtn = (ImageView) view.findViewById(R.id.huawi_btn);


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
///*  private void signIn(boolean forceLogin) {
//
//        HMSAgent.Hwid.signIn(forceLogin, new SignInHandler() {
//
//            @Override
//
//            public void onResult(int rtnCode, SignInHUAWEIId signInResult) {
//
//                if (rtnCode == HMSAgent.AgentResultCode.HMSAGENT_SUCCESS && signInResult != null) {
//
//                    //可以获取帐号的 openid，昵称，头像 at信息 | You can get the OpenID, nickname, Avatar, at etc information     of HUAWEI Account
//
//                    showLog("signIn successful=========");
//
//                    showLog("Nickname:" + signInResult.getDisplayName());
//
//                    showLog("openid:" + signInResult.getOpenId());
//
//                    showLog("accessToken:" + signInResult.getAccessToken());
//
//                    showLog("Head pic URL:" + signInResult.getPhotoUrl());
//
//                } else {
//
//                    showLog("signIn---error: " + rtnCode);
//
//                }
//
//            }
//
//        });
//
//    }
//
//
//
//    /**
//
//     * 退出。此接口调用后，下次再调用signIn会拉起界面，请谨慎调用。如果不确定就不要调用了。 | Exit。 After this method is called, the next time you call signIn will pull the activity, please call carefully. Do not call if you are unsure.
//
//     */
//
//    private void signOut(){
//
//        HMSAgent.Hwid.signOut(new SignOutHandler() {
//
//            @Override
//
//            public void onResult(int rtnCode, SignOutResult signOutResult) {
//
//                if (rtnCode == HMSAgent.AgentResultCode.HMSAGENT_SUCCESS && signOutResult != null) {
//
//                    showLog("SignOut successful");
//
//                } else {
//
//                    showLog("SignOut fail:" + rtnCode);
//
//                }
//
//            }
//
//        });
//
//    }
//
//
//
//    /**
//
//     * Called when a view has been clicked.
//
//     *
//
//     * @param v The view that was clicked.
//
//     */
//
//    @Override
//
//    public void onClick(View v) {
//
//        int id = v.getId();
//
//        if (id == R.id.btn_id) {
//
//            // 本页面切换到本页面的按钮事件不处理 | "This page switches to itself" button event does not need to be handled
//
//            return;
//
//        } else if (!onTabBtnClickListener(id)) {
//
//            // 如果不是tab切换按钮则处理业务按钮事件 | Handle Business button events without the TAB toggle button
//
//            switch (id) {
//
//                case R.id.btn_signin:
//
//                    signIn(false);
//
//                    break;
//
//                case R.id.btn_forcesignin:
//
//                    signIn(true);
//
//                    break;
//
//                case R.id.btn_signout:
//
//                    signOut();
//
//                    break;
//
//                default:
//
//            }
//
//        }
//
//    }
//
//}
