package com.tourisa.helpers;

import android.app.Activity;
import android.content.Context;
import android.content.ContextWrapper;
import android.content.Intent;
import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.drawable.Drawable;
import android.os.AsyncTask;
import android.text.Editable;
import android.text.Html;
import android.text.TextUtils;
import android.text.TextWatcher;
import android.util.DisplayMetrics;
import android.util.Log;
import android.util.Patterns;
import android.view.View;
import android.view.inputmethod.InputMethodManager;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import androidx.core.widget.NestedScrollView;

import com.google.android.gms.auth.api.signin.GoogleSignInAccount;
import com.google.android.gms.common.api.ApiException;
import com.google.android.gms.tasks.Task;
import com.google.android.material.textfield.TextInputEditText;
import com.google.android.material.textfield.TextInputLayout;
import com.google.gson.Gson;
import com.squareup.picasso.Picasso;
import com.squareup.picasso.Target;
import com.tourisa.R;

import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import org.json.JSONObject;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.List;
import java.util.Locale;
import java.util.Objects;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import okhttp3.Call;
import okhttp3.Callback;
import okhttp3.FormBody;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.RequestBody;
import okhttp3.Response;

public class StaticMembers {

    public static final String domain = "https://blacksquaressolutions.com/api/";
    public static final String USERS = "users";
    public static final String USER = "user";
    public static final String FAV = "fav";
    public static final String ISO_DATE_FORMAT = "yyyy-MM-dd'T'HH:mm:ssZ";
    public static final String DATE_FORMAT_VIEW = "yyyy-M-dd hh:mm";
    public static final String DATE_ONLY_FORMAT_VIEW = "yyyy-M-dd";
    public static final String SIGN_UP = "sign_up";
    public static final String PIN_CODE = "pincode";
    public static final String PIN_CODE_TOKEN = "pincodetoken";
    public static final String DATE_FORMAT_DATABASE = "yyyy-MM-dd HH:mm:ss";
    public static final String DATE_FORMAT_BID = "dd MMM yy";
    public static final String PRODUCT = "product";
    public static final String REASONS = "reasons";
    public static final String REASONS_CANCEL_BID = "reasons bid cancel";
    public static final String ZARI_IMAGES_PATH = "/Zari/images";
    public static final int CLOSE_CODE = 1004;
    public static final String BID = "bid";
    public static final int MAX_CHAR_DESIGN = 23;
    public static final int CODE_GOOGLE_SIGN_IN = 9009;
    public static final int TYPE_LIVE = 0;
    public static final int TYPE_SOLD = 1;
    public static final int TYPE_EXPIRED = 2;
    public static final String CHOOSE_USER = "choose user";
    public static final String COMMENT = "comment";
    public static final String COMMENT_ID = "comment id";
    public static final String IS_EDIT = "is edit";
    public static final String EXTEND = "extend";
    public static final String ANDROID = "android";
    private static final String LANGUAGE = "language";
    public static final String EMAIL = "email";
    public static final String PASSWORD = "password";
    public static final String LAT = "latitude";
    public static final String LONG = "longitude";
    public static final String ADDRESS = "address";
    public static final String TOKEN = "token";
    public static final String PAGE = "page";
    public static final String register = "user/register";
    public static final String getPinCode = "user/getPinCode";
    public static final String login = "user/login";
    public static final String verifyPinCode = "user/testpincode";
    public static final String reset = "user/password";
    public static final int PIX_CODE = 119;
    @Nullable
    public static final String IMAGES = "images";
    public static final int EDIT_CODE = 1003;
    public static final int EDIT_PROFILE_CODE = 1005;
    @Nullable
    public static final String OPENED = "pix_opened";
    @Nullable
    public static final String STOPPED = "stopped";
    private static final String TAG = "Zari";
    private static final String ACCESS_TOKEN = "access_token";
    public static final int REFRESH = 7888;

  /*  ////////////////// ////////////////////
    public static void getAccessTokenOfGoogle(Intent data, OnAccessCodeFinishedListener onAccessCodeFinishedListener) {
        Task<GoogleSignInAccount> task = GoogleSignIn.getSignedInAccountFromIntent(data);
        try {
            GoogleSignInAccount account = task.getResult(ApiException.class);
            assert account != null;
            Log.w("google", account.getServerAuthCode());
            OkHttpClient client = new OkHttpClient();
            RequestBody requestBody = new FormBody.Builder()
                    .add("grant_type", "authorization_code")
                    .add("client_id", BuildConfig.ZARI_WEB_CLIENT_ID)
                    .add("client_secret", BuildConfig.ZARI_WEB_SECRET)
                    .add("redirect_uri", "")
                    .add("code", Objects.requireNonNull(account.getServerAuthCode()))
                    .build();
            final Request request = new Request.Builder()
                    .url("https://www.googleapis.com/oauth2/v4/token")
                    .post(requestBody)
                    .build();
            onAccessCodeFinishedListener.showProgress();
            client.newCall(request).enqueue(new Callback() {
                @Override
                public void onFailure(@NotNull Call call, @NotNull IOException e) {
                    Log.e(StaticMembers.TAG, e.toString());
                    onAccessCodeFinishedListener.hideProgress();
                }

                @Override
                public void onResponse(@NotNull Call call, @NotNull Response response) throws IOException {
                    onAccessCodeFinishedListener.hideProgress();
                    try {
                        onAccessCodeFinishedListener
                                .OnAccessCodeFinished(
                                        new JSONObject(Objects.requireNonNull(response.body()).string())
                                                .get(StaticMembers.ACCESS_TOKEN).toString());
                    } catch (Exception e) {
                        e.printStackTrace();
                    }
                }
            });
        } catch (ApiException e) {
            Log.w("google", "signInResult:failed code=" + e.getStatusCode());
            onAccessCodeFinishedListener.hideProgress();
        }
    }
*/
    public interface OnAccessCodeFinishedListener {
        public void OnAccessCodeFinished(String accessToken);

        public void showProgress();

        public void hideProgress();
    }

    ////////////////// Download////////////////////
    public static void showKeyboard(Context context) {
        InputMethodManager inputMethodManager = (InputMethodManager) context.getSystemService(Context.INPUT_METHOD_SERVICE);
        inputMethodManager.toggleSoftInput(InputMethodManager.SHOW_FORCED, 0);
    }

    //////////////////Picasso Download////////////////////
    public interface OnImageSaved {
        public void onImageSavedListener(String dirPath);
    }

    public static Target picassoImageTarget(Context context, final String imageName, OnImageSaved onImageSaved) {
        Log.d("picassoImageTarget", " picassoImageTarget");
        // path to /data/data/yourapp/app_imageDir
        return new Target() {
            @Override
            public void onBitmapLoaded(final Bitmap bitmap, Picasso.LoadedFrom from) {
                SaveTask saveTask = new SaveTask(context, bitmap, onImageSaved);
                saveTask.execute(imageName);
            }

            @Override
            public void onBitmapFailed(Exception e, Drawable errorDrawable) {

            }

            @Override
            public void onPrepareLoad(Drawable placeHolderDrawable) {
                if (placeHolderDrawable != null) {
                }
            }
        };
    }

    public static class SaveTask extends AsyncTask<String, String, String> {
        private Context context;
        Bitmap bitmap;
        OnImageSaved onImageSaved;

        public SaveTask(Context context, Bitmap bitmap, OnImageSaved onImageSaved) {
            this.context = context;
            this.bitmap = bitmap;
            this.onImageSaved = onImageSaved;
        }

        @Override
        protected String doInBackground(String... strings) {
            ContextWrapper cw = new ContextWrapper(context);
            final File directory = cw.getDir(StaticMembers.IMAGES, Context.MODE_PRIVATE);
            final File myImageFile = new File(directory, strings[0]); // Create image file
            FileOutputStream fos = null;
            try {
                fos = new FileOutputStream(myImageFile);
                bitmap.compress(Bitmap.CompressFormat.PNG, 100, fos);
                fos.close();
                return directory.getAbsolutePath() + "/" + strings[0];
            } catch (Exception e) {
                e.printStackTrace();
            }
            return "";
        }

        @Override
        protected void onPostExecute(String s) {
            super.onPostExecute(s);
            onImageSaved.onImageSavedListener(s);
        }
    }

    ////////////////// change Dots////////////////////
    public static void changeDots(int currentPage, int count, LinearLayout dotsLayout, Context context) {
        ImageView[] dots = new ImageView[count];
        dotsLayout.removeAllViews();
        for (int i = 0; i < dots.length; i++) {
            dots[i] = new ImageView(context);
            dots[i].setImageResource(R.drawable.bullet_unselected);
            dotsLayout.addView(dots[i]);
        }

        if (dots.length > currentPage)
            dots[currentPage].setImageResource(R.drawable.bullet_selected);
    }

    public static String getJson(Object o) {
        return new Gson().toJson(o);
    }

    public static Object getObjectFromJson(String json, Class<?> c) {
        try {
            if (json.isEmpty())
                return null;
            return new Gson().fromJson(json, c);
        } catch (Exception e) {
            return null;
        }
    }


    /////////////////Dates converter/////////////////////
    public static String changeDateFromIsoToView(String dateFrom) {
        SimpleDateFormat sdf = new SimpleDateFormat(StaticMembers.ISO_DATE_FORMAT, Locale.US);
        SimpleDateFormat sdfTo = new SimpleDateFormat(StaticMembers.DATE_FORMAT_VIEW, Locale.getDefault());
        try {
            return sdfTo.format(sdf.parse(dateFrom));
        } catch (ParseException e) {
            e.printStackTrace();
        }
        return dateFrom;
    }

    public static String changeDateFromDatabaseToBid(String dateFrom) {
        SimpleDateFormat sdf = new SimpleDateFormat(DATE_FORMAT_DATABASE, Locale.US);
        SimpleDateFormat sdfTo = new SimpleDateFormat(DATE_FORMAT_BID, Locale.getDefault());
        try {
            return sdfTo.format(sdf.parse(dateFrom));
        } catch (ParseException e) {
            e.printStackTrace();
        }
        return dateFrom;
    }

    public static <T extends Activity> void startActivityOverAll(T activity, Class<?> destinationActivity) {
        Intent intent = new Intent(activity, destinationActivity);
        intent.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
        activity.startActivity(intent);
        activity.finishAffinity();
    }

    public static <T extends Activity> void startActivityOverAll(Intent intent, T activity) {
        intent.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
        activity.startActivity(intent);
        activity.finishAffinity();
    }

    public static <T extends View> void hideKeyboard(T view, Context context) {
        InputMethodManager inputMethodManager = (InputMethodManager) context.getSystemService(Activity.INPUT_METHOD_SERVICE);
        if (inputMethodManager != null) {
            inputMethodManager.hideSoftInputFromWindow(view.getWindowToken(), 0);
        }
    }

    public static <A extends Activity> void hideKeyboard(A activity) {
        InputMethodManager inputMethodManager = (InputMethodManager) activity.getSystemService(Activity.INPUT_METHOD_SERVICE);
        if (inputMethodManager != null && activity.getCurrentFocus() != null) {
            inputMethodManager.hideSoftInputFromWindow(activity.getCurrentFocus().getWindowToken(), 0);
        }
    }

    //////////////////////Password validation/////////////////////
    public static boolean isValidPassword(final String password) {
        Pattern pattern;
        Matcher matcher;
        final String PASSWORD_PATTERN = "^(?=.*[0-9])(?=.*[a-z])(?=.*[A-Z])(?=\\S+$).{8,}$";
        pattern = Pattern.compile(PASSWORD_PATTERN);
        matcher = pattern.matcher(password);
        return matcher.matches();
    }

    public static boolean checkValidationPassword(TextInputEditText editText, final TextInputLayout textInputLayout, final String errorMessage, final String errorMessage2) {

        editText.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {

            }

            @Override
            public void afterTextChanged(Editable s) {
                if (s.length() == 0) {
                    textInputLayout.setError(errorMessage);
                    textInputLayout.setErrorEnabled(true);
                } else {
                    if (!isValidPassword(s.toString())) {

                        textInputLayout.setError(errorMessage2);
                        textInputLayout.setErrorEnabled(true);
                    } else {
                        textInputLayout.setErrorEnabled(false);
                    }
                }

            }
        });
        if (TextUtils.isEmpty(editText.getText())) {
            textInputLayout.setError(errorMessage);
            textInputLayout.setErrorEnabled(true);
            return false;
        } else {
            if (!isValidPassword(editText.getText().toString())) {
                textInputLayout.setError(errorMessage2);
                textInputLayout.setErrorEnabled(true);
                return false;
            } else {
                textInputLayout.setErrorEnabled(false);
                return true;
            }
        }
    } //////////////////////Password validation/////////////////////

    public static boolean isValidEmail(final String email) {
        return Patterns.EMAIL_ADDRESS.matcher(email).matches();
    }

    public static boolean checkValidationEmail(TextInputEditText editText, final TextInputLayout textInputLayout, final String errorMessage, final String errorMessage2) {

        editText.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {

            }

            @Override
            public void afterTextChanged(Editable s) {
                if (s.length() == 0) {
                    textInputLayout.setError(errorMessage);
                    textInputLayout.setErrorEnabled(true);
                } else {
                    if (!isValidPassword(s.toString())) {

                        textInputLayout.setError(errorMessage2);
                        textInputLayout.setErrorEnabled(true);
                    } else {
                        textInputLayout.setErrorEnabled(false);
                    }
                }

            }
        });
        if (TextUtils.isEmpty(editText.getText())) {
            textInputLayout.setError(errorMessage);
            textInputLayout.setErrorEnabled(true);
            return false;
        } else {
            if (!isValidEmail(editText.getText().toString())) {
                textInputLayout.setError(errorMessage2);
                textInputLayout.setErrorEnabled(true);
                return false;
            } else {
                textInputLayout.setErrorEnabled(false);
                return true;
            }
        }
    }
    //////////////////////Visiblity with Animation/////////////////////

    public static <V extends View> void makeVisible(V layout) {
        layout.setVisibility(View.VISIBLE);
        layout.setAlpha(0.0f);
        layout.animate()
                .translationY(0)
                .alpha(1.0f)
                .setListener(null);
    }

    public static <V extends View> void makeGone(V layout) {
        layout.setVisibility(View.GONE);
    }
    //////////////////////Toasts/////////////////////

    private static Toast toast;

    public static void toastMessageShort(Context context, String messaage) {
        if (toast != null)
            toast.cancel();
        toast = Toast.makeText(context, messaage, Toast.LENGTH_SHORT);
        toast.show();
    }

    public static void toastMessageShort(Context context, int messaage) {
        if (toast != null)
            toast.cancel();
        toast = Toast.makeText(context, messaage, Toast.LENGTH_SHORT);
        toast.show();
    }

    public static void toastMessageShort(Context context, CharSequence messaage) {
        if (toast != null)
            toast.cancel();
        toast = Toast.makeText(context, messaage, Toast.LENGTH_SHORT);
        toast.show();
    }

    public static void toastMessageLong(Context context, int messaage) {
        if (toast != null)
            toast.cancel();
        toast = Toast.makeText(context, messaage, Toast.LENGTH_LONG);
        toast.show();
    }

    public static void toastMessageLong(Context context, String messaage) {
        if (toast != null)
            toast.cancel();
        toast = Toast.makeText(context, messaage, Toast.LENGTH_LONG);
        toast.show();
    }

    public static boolean checkTextInputEditText(TextInputEditText editText, final TextInputLayout textInputLayout, final String errorMessage) {
        return checkTextInputEditText(editText, textInputLayout, 0, errorMessage, errorMessage);
    }

    public static boolean checkTextInputEditText
            (TextInputEditText editText, final TextInputLayout textInputLayout, int min, final String errorMessage, final String errorMessageMin) {

        editText.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {

            }

            @Override
            public void afterTextChanged(Editable s) {
                if (s.length() == 0) {
                    textInputLayout.setError(errorMessage);
                    textInputLayout.setErrorEnabled(true);
                } else if (s.length() < min) {
                    textInputLayout.setError(errorMessageMin);
                    textInputLayout.setErrorEnabled(true);
                }
                {
                    textInputLayout.setErrorEnabled(false);
                }
            }
        });
        if (TextUtils.isEmpty(editText.getText())) {
            textInputLayout.setError(errorMessage);
            textInputLayout.setErrorEnabled(true);
            editText.requestFocus();
            return false;
        } else if (Objects.requireNonNull(editText.getText()).length() < min) {
            textInputLayout.setError(errorMessageMin);
            textInputLayout.setErrorEnabled(true);
            editText.requestFocus();
            return false;
        } else {
            textInputLayout.setErrorEnabled(false);
            return true;
        }
    }

    public static String getLanguage(Context context) {
        return PrefManager.getInstance(context).getStringData(LANGUAGE);
    }

    public static void setLanguage(Context context, String langStr) {
        PrefManager.getInstance(context).setStringData(LANGUAGE, langStr);
    }

    public static void changeLocale(Context context, String langStr) {
        setLanguage(context, langStr);
        Resources res = context.getResources();
        // Change locale settings in the app.
        DisplayMetrics dm = res.getDisplayMetrics();
        android.content.res.Configuration conf = res.getConfiguration();
        conf.setLocale(new Locale(langStr.toLowerCase())); // API 17+ only.
        // Use conf.locale = new Locale(...) if targeting lower versions
        res.updateConfiguration(conf, dm);
        Locale locale = context.getResources().getConfiguration().locale;
        Locale.setDefault(locale);
    }

    public static String getDate() {
        return getDate(false);
    }

    public static String getDate(boolean dateOnly) {
        Calendar calendar = Calendar.getInstance();
        return new SimpleDateFormat(dateOnly ? DATE_ONLY_FORMAT_VIEW : DATE_FORMAT_VIEW, Locale.getDefault()).format(calendar.getTime());

    }

    public static String getDate(@NotNull Calendar calendar) {
        return new SimpleDateFormat(DATE_ONLY_FORMAT_VIEW, Locale.getDefault()).format(calendar.getTime());
    }

    public static String getDate(@NotNull Date date) {
        return getDate(date, false);
    }

    public static String getDate(@NotNull Date date, boolean hasMonths) {
        return new SimpleDateFormat(hasMonths ? DATE_FORMAT_BID : DATE_ONLY_FORMAT_VIEW, Locale.getDefault()).format(date);
    }

    public static <T> boolean checkNotNullList(NestedScrollView scrollView, Context context, List<T> list, int selected, String s) {
        if (selected > -1 && list != null && !list.isEmpty()) {
            return true;
        } else {
            toastMessageShort(context, s);
            scrollView.scrollTo(0, scrollView.getBottom());
            return false;
        }
    }

    public static <T> boolean checkNotNullListSpinner
            (NestedScrollView scrollView, Spinner spinner, Context context, List<T> list, int selected, String s) {
        if (spinner != null && spinner.getSelectedView() != null) {
            TextView textView = spinner.getSelectedView().findViewById(android.R.id.text1);
            if (selected > -1 && list != null && !list.isEmpty()) {
                //textView.setTextColor(context.getResources().getColor(R.color.textColorGrey));
                return true;
            } else {

                textView.setText(getTextHTML(s));
                //textView.setTextColor(Color.parseColor("#f65828"));
                //((TextInputLayout) spinner.getSelectedView()).setErrorEnabled(true);
                scrollView.post(() -> scrollView.scrollTo(0, spinner.getBottom()));
                return false;
            }
        }
        return false;
    }

    public static CharSequence getTextHTML(String s) {
        return Html.fromHtml(s);
    }
}
