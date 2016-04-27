package com.zhipengyang.bunnyc2.fragments.actives;

import android.app.Fragment;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

import com.zhipengyang.bunnyc2.R;

public class HomeFragment extends Fragment {
    private Button properties;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_home, container, false);
        properties = (Button) view.findViewById(R.id.properties);
        properties.setOnTouchListener(new View.OnTouchListener() {
            @Override
            public boolean onTouch(View v, MotionEvent event) {
                if (event.getAction() == MotionEvent.ACTION_DOWN)
                    properties.setBackgroundResource(R.drawable.properties_clicked);
                if (event.getAction() == MotionEvent.ACTION_UP)
                    properties.setBackgroundResource(R.drawable.properties);
                return false;
            }
        });
        return view;
    }
}
