package com.zhipengyang.bunnyc2.activities;

import android.app.Activity;
import android.content.Context;
import android.os.Bundle;
import android.util.AttributeSet;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import com.zhipengyang.bunnyc2.R;
import com.zhipengyang.bunnyc2.data_structure.GeneralFunctions;


public class SettingsActivity extends Activity {
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.settings);
        setTitle(R.string.settings);

        Button loginButton = (Button) findViewById(R.id.login_button);
        loginButton.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                Toast.makeText(getApplicationContext(), "Not been implemented yet.", Toast.LENGTH_LONG).show();
            }
        });

        final SettingsActivity activity = this;

        Button checkUpdates = (Button) findViewById(R.id.check);
        checkUpdates.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                GeneralFunctions.detectUpdates(getApplicationContext(), activity, MainActivity.internalVersion);
            }
        });
    }

    @Override
    public View onCreateView(String name, Context context, AttributeSet attrs) {
        return super.onCreateView(name, context, attrs);
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
    }
}
