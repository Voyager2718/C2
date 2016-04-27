package com.zhipengyang.bunnyc2.fragments.actives;

import android.app.Fragment;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

import com.zhipengyang.bunnyc2.R;
import com.zhipengyang.bunnyc2.canvas.HomeCanvas;

public class HomeFragment extends Fragment {
    private Button properties;
    private HomeCanvas homeCanvas;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_home, container, false);

        //Find views
        properties = (Button) view.findViewById(R.id.properties);
        homeCanvas = (HomeCanvas) view.findViewById(R.id.home_canvas);


        //Listeners
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

        properties.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

            }
        });

        return view;
    }
}
