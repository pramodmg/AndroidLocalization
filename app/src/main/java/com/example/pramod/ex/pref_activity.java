package com.example.pramod.ex;

import android.annotation.TargetApi;
import android.content.Intent;
import android.content.SharedPreferences;
import android.content.res.Configuration;
import android.content.res.Resources;
import android.os.Build;
import android.os.Bundle;
import android.preference.ListPreference;
import android.preference.Preference;
import android.preference.PreferenceActivity;
import android.preference.PreferenceManager;
import android.support.v7.widget.Toolbar;
import android.util.DisplayMetrics;
import android.util.TypedValue;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.ListView;
import android.widget.Toast;

import java.util.Locale;

/**
 * Created by pramod on 12/2/15.
 */
public class pref_activity extends PreferenceActivity implements Preference.OnPreferenceChangeListener {

    Locale myLocale;
    protected void onCreate(Bundle sav) {
        super.onCreate(sav);
        addPreferencesFromResource(R.xml.pref);

        ListPreference listPreference = (ListPreference) findPreference("listpref");
        CharSequence currText = listPreference.getEntry();
        String currValue = listPreference.getValue();

        bindPref(listPreference);
    }

    @Override
    protected void onPostCreate(Bundle savedInstanceState) {
        super.onPostCreate(savedInstanceState);
        Toolbar bar;

        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.ICE_CREAM_SANDWICH) {
            LinearLayout root = (LinearLayout) findViewById(android.R.id.list).getParent().getParent().getParent();
            bar = (Toolbar) LayoutInflater.from(this).inflate(R.layout.toolbar, root, false);
            root.addView(bar, 0); // insert at top
        } else {
            ViewGroup root = (ViewGroup) findViewById(android.R.id.content);
            ListView content = (ListView) root.getChildAt(0);

            root.removeAllViews();

            bar = (Toolbar) LayoutInflater.from(this).inflate(R.layout.toolbar, root, false);
            root.addView(bar);

            int height;
            TypedValue tv = new TypedValue();
            if (getTheme().resolveAttribute(R.attr.actionBarSize, tv, true)) {
                height = TypedValue.complexToDimensionPixelSize(tv.data, getResources().getDisplayMetrics());
            } else {
                height = bar.getHeight();
            }

            content.setPadding(0, height, 0, 0);

            root.addView(content);
        }

        bar.setNavigationOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });
    }

    private void bindPref(Preference pref) {
        pref.setOnPreferenceChangeListener(this);
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

    @Override
    public boolean onPreferenceChange(Preference preference, Object newValue) {
        Toast.makeText(getApplicationContext(),"inside pref",Toast.LENGTH_SHORT).show();
        String value = (String) newValue;
        Toast.makeText(getApplicationContext(),value,Toast.LENGTH_SHORT).show();
        if (value.equals("Ta")) {
            Toast.makeText(getApplicationContext(), "Tamil is selected", Toast.LENGTH_SHORT).show();
            setLocale("ta");
        } else if (value.equals("En")) {
            Toast.makeText(getApplicationContext(),"English is selected",Toast.LENGTH_SHORT).show();
            setLocale("en");
        } else if (value.equals("Hi")) {
            Toast.makeText(getApplicationContext(),"Hindi is selected",Toast.LENGTH_SHORT).show();
            setLocale("hi");
        }
        return true;
    }

}
