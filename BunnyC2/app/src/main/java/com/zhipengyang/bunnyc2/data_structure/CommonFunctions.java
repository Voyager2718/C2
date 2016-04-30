package com.zhipengyang.bunnyc2.data_structure;

import android.app.Activity;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.net.Uri;
import android.support.v7.app.AlertDialog;
import android.widget.Toast;

import com.zhipengyang.bunnyc2.R;

import org.json.JSONException;
import org.json.JSONObject;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;

public final class CommonFunctions {
    private static void alertUpdate(final Context applicationContext, final Activity activityContext, final String ver, final String description, final String releaseDate, final String url) {
        activityContext.runOnUiThread(new Runnable() {
            @Override
            public void run() {
                AlertDialog.Builder builder = new AlertDialog.Builder(activityContext);//TODO: Here should use Activity
                builder.setMessage(applicationContext.getString(R.string.update_available) + ver + "@" + releaseDate + "\n\n" + description + "\n\n" + applicationContext.getString(R.string.go_update))
                        .setCancelable(true)
                        .setPositiveButton(applicationContext.getString(R.string.yes),
                                new DialogInterface.OnClickListener() {
                                    @Override
                                    public void onClick(DialogInterface dialog, int which) {
                                        Intent browserIntent = new Intent(Intent.ACTION_VIEW, Uri.parse(url));
                                        activityContext.startActivity(browserIntent);
                                    }
                                })
                        .setNegativeButton(applicationContext.getString(R.string.no), new DialogInterface.OnClickListener() {
                            @Override
                            public void onClick(DialogInterface dialog, int which) {
                                dialog.cancel();
                            }
                        });
                builder.create().show();
            }
        });
    }

    public static void detectUpdates(final Context applicationContext, final Activity activityContext, final int internalVersion) {
        //Version detect and update
        new Thread(new Runnable() {
            @Override
            public void run() {
                //Establish Connectivity Manager
                ConnectivityManager connectivityManager = (ConnectivityManager) applicationContext.getSystemService(Context.CONNECTIVITY_SERVICE);
                NetworkInfo networkInfo = connectivityManager.getActiveNetworkInfo();

                //If connected
                if (networkInfo != null && networkInfo.isConnected()) {
                    HttpURLConnection connection = null;
                    StringBuffer stringBuffer;
                    BufferedReader bufferedReader = null;
                    try {
                        //Establish connection
                        URL url = new URL("https://raw.githubusercontent.com/Voyager2718/Voyager2718.github.io/master/C2/App/Android/ver.json");
                        connection = (HttpURLConnection) url.openConnection();
                        connection.connect();

                        //Get JSON
                        InputStream inputStream = connection.getInputStream();

                        bufferedReader = new BufferedReader(new InputStreamReader(inputStream));

                        stringBuffer = new StringBuffer();
                        String line;
                        while ((line = bufferedReader.readLine()) != null)
                            stringBuffer.append(line);

                        final String str = stringBuffer.toString();

                        //UI thread and interpret JSON
                        activityContext.runOnUiThread(new Runnable() {
                            @Override
                            public void run() {
                                try {
                                    JSONObject jsonObject = new JSONObject(str);
                                    String ver = jsonObject.getString("version");
                                    String description = jsonObject.getString("description");
                                    String releaseDate = jsonObject.getString("release_date");
                                    int internalVer = Integer.parseInt(jsonObject.getString("internal_version"));
                                    String updateUrl = jsonObject.getString("URL");
                                    if (internalVersion < internalVer) {
                                        alertUpdate(applicationContext, activityContext, ver, description, releaseDate, updateUrl);
                                    } else
                                        Toast.makeText(applicationContext.getApplicationContext(), applicationContext.getString(R.string.up_to_date) + ver, Toast.LENGTH_SHORT).show();
                                } catch (JSONException e) {
                                    e.printStackTrace();
                                }
                            }
                        });
                    } catch (MalformedURLException e) {
                        e.printStackTrace();
                    } catch (IOException e) {
                        e.printStackTrace();
                    } finally {
                        if (connection != null)
                            connection.disconnect();
                        try {
                            if (bufferedReader != null)
                                bufferedReader.close();
                        } catch (IOException e) {
                            e.printStackTrace();
                        }
                    }
                } else {
                    //If not connected
                    activityContext.runOnUiThread(new Runnable() {
                        @Override
                        public void run() {
                            Toast.makeText(applicationContext.getApplicationContext(), applicationContext.getString(R.string.network_error), Toast.LENGTH_LONG).show();
                        }
                    });
                }
            }
        }).start();
        //Update detection ended
    }
}
