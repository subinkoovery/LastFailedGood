package in.dreamseed.thanbee;

import android.accounts.Account;
import android.accounts.AccountManager;
import android.app.Activity;
import android.content.Intent;
import android.content.SharedPreferences;
import android.graphics.Typeface;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.support.v7.app.ActionBar;
import android.support.v7.app.ActionBarActivity;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.parse.ParseException;
import com.parse.ParseUser;
import com.parse.SignUpCallback;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;


public class MyActivity extends ActionBarActivity {
    TextView eventTittle,company_name,company_site;
    Drawable event_logo;
    ImageView mosque;
    String email="";
    private String MY_APP_NAME="THANBEE";
    private String REG_STATUS="reGsATUS";
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,
                WindowManager.LayoutParams.FLAG_FULLSCREEN);

        getSupportActionBar().hide();
        setContentView(R.layout.activity_my);
        checkUserRegisteredandDoIT();
        eventTittle= (TextView) findViewById(R.id.eventName);
        Typeface swasdee=Typeface.createFromAsset(getAssets(), "sawasdee.ttf");
        eventTittle.setTypeface(swasdee);


    }

    @Override
    protected void onStart() {
        super.onStart();
    }

    public void next(View view)
    {
        Intent Frag=new Intent(this,mainHome.class);
        finish();
        startActivity(Frag);
    }
    public void checkUserRegisteredandDoIT() {
        Boolean RegStatus = false;

        SharedPreferences prefs = getSharedPreferences(MY_APP_NAME, MODE_PRIVATE);
         RegStatus = prefs.getBoolean(REG_STATUS, false);
        Log.e("REG","Caallled");
        if (!RegStatus)
        {
            register();
        }


    }

    private void register() {

        ParseUser user = new ParseUser();
        user.setUsername(getUsername());
        user.setPassword(getUsername()+"12345");
        user.setEmail(email);

        Log.e("REG","Caallled");

        user.signUpInBackground(new SignUpCallback() {



            public void done(ParseException e) {
                if (e == null) {
                    SharedPreferences.Editor mEditor=getSharedPreferences(MY_APP_NAME,MODE_PRIVATE).edit();
                    mEditor.putBoolean(REG_STATUS,true);
                    mEditor.commit();
                    Log.e("REG","SUCCESS");
                } else {
                    e.printStackTrace();
                    Log.e("REG","FAIL");
                    // Sign up didn't succeed. Look at the ParseException
                    // to figure out what went wrong
                }
            }
        });
    }
    public String getUsername(){
        AccountManager manager = AccountManager.get(this);
        Account[] accounts = manager.getAccountsByType("com.google");
        List<String> possibleEmails = new LinkedList<String>();

        for (Account account : accounts) {
            // TODO: Check possibleEmail against an email regex or treat
            // account.name as an email address only for certain account.type values.
            possibleEmails.add(account.name);

        }

        if(!possibleEmails.isEmpty() && possibleEmails.get(0) != null){
             email = possibleEmails.get(0);
            String[] parts = email.split("@");
            if(parts.length > 0 && parts[0] != null)
                return parts[0];
            else
                return null;
        }else
            return null;
    }
}
