package vn.luongvo.digits.demo;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

import com.digits.sdk.android.AuthCallback;
import com.digits.sdk.android.Digits;
import com.digits.sdk.android.DigitsAuthButton;
import com.digits.sdk.android.DigitsException;
import com.digits.sdk.android.DigitsSession;
import com.twitter.sdk.android.core.TwitterAuthConfig;
import com.twitter.sdk.android.core.TwitterCore;

import io.fabric.sdk.android.Fabric;

/**
 * @author Luong Vo
 */
public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        TwitterAuthConfig authConfig = new TwitterAuthConfig(BuildConfig.TWITTER_KEY,
                BuildConfig.TWITTER_SECRET);
        Fabric.with(this, new TwitterCore(authConfig), new Digits());

        updateUI();
    }

    private void updateUI() {
        DigitsAuthButton digitsButton = (DigitsAuthButton) findViewById(R.id.bt_digits_auth);

        DigitsSession digitsSession = Digits.getSessionManager().getActiveSession();
        if (digitsSession == null || digitsSession.isLoggedOutUser()) {
            digitsButton.setVisibility(View.VISIBLE);
            findViewById(R.id.ln_signed_in).setVisibility(View.GONE);

            digitsButton.setAuthTheme(R.style.CustomDigitsTheme);
            digitsButton.setCallback(new AuthCallback() {
                @Override
                public void success(DigitsSession session, String phoneNumber) {
                    // TODO: associate the session userID with your user model
                    Toast.makeText(getApplicationContext(), "Authentication successful for "
                            + phoneNumber, Toast.LENGTH_LONG).show();

                    updateUI();
                }

                @Override
                public void failure(DigitsException exception) {
                    Log.d("Digits", "Sign in with Digits failure", exception);
                }
            });
        } else {
            digitsButton.setVisibility(View.GONE);
            findViewById(R.id.ln_signed_in).setVisibility(View.VISIBLE);

            ((TextView) findViewById(R.id.tv_phone)).setText(digitsSession.getPhoneNumber());
            findViewById(R.id.bt_sign_out).setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    Digits.getSessionManager().clearActiveSession();
                    updateUI();
                }
            });
        }
    }
}
