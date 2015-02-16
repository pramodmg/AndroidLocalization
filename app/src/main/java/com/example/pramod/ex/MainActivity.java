package com.example.pramod.ex;

import android.content.Intent;
import android.content.SharedPreferences;
import android.content.res.Configuration;
import android.content.res.Resources;
import android.preference.PreferenceManager;
import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.util.DisplayMetrics;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.Spinner;
import android.widget.Switch;
import android.widget.TextView;
import android.widget.Toast;

import java.util.Locale;


public class MainActivity extends ActionBarActivity {

    TextView textView;
    Spinner spin;
    Locale myLocale;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }


    public void setLocale(String lang) {

        myLocale = new Locale(lang);
        Resources res = getResources();
        DisplayMetrics dm = res.getDisplayMetrics();
        Configuration conf = res.getConfiguration();
        conf.locale = myLocale;
        res.updateConfiguration(conf, dm);
        Intent refresh = new Intent(this, MainActivity.class);
        startActivity(refresh);
    }

    private  void dpsharedpref() {
        SharedPreferences prefs = PreferenceManager.getDefaultSharedPreferences(MainActivity.this);

        String username = prefs.getString("username", "Default NickName");
        String passw = prefs.getString("password", "Default Password");
        boolean checkBox = prefs.getBoolean("checkBox", false);
        String listPrefs = prefs.getString("listpref", "Default list prefs");

//        StringBuilder builder = new StringBuilder();
//        builder.append("Username: " + username + "\n");
//        builder.append("Password: " + passw + "\n");
//        builder.append("Keep me logged in: " + String.valueOf(checkBox) + "\n");
//        builder.append("List preference: " + listPrefs);

        if (listPrefs.equals("Ta")) {
            Toast.makeText(getApplicationContext(),"Tamil is selected",Toast.LENGTH_SHORT).show();
            setLocale("ta");
        } else if (listPrefs.equals("En")) {
            Toast.makeText(getApplicationContext(),"English is selected",Toast.LENGTH_SHORT).show();
            setLocale("en");
        } else if (listPrefs.equals("Hi")) {
            Toast.makeText(getApplicationContext(),"Hindi is selected",Toast.LENGTH_SHORT).show();
            setLocale("hi");
        }
//        textView.setText(builder.toString());

    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement

        if (id == R.id.pref) {
            Intent intent = new Intent(MainActivity.this,pref_activity.class);
            startActivity(intent);
        }

        return super.onOptionsItemSelected(item);
    }
}
