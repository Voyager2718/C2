package com.zhipengyang.bunnyc2.fragments.actives;

import android.app.Fragment;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

import com.zhipengyang.bunnyc2.R;
import com.zhipengyang.bunnyc2.canvas.SchoolCanvas;

public class SchoolFragment extends Fragment {
    private Button properties;
    private SchoolCanvas schoolCanvas;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_school, container, false);
        schoolCanvas = (SchoolCanvas) view.findViewById(R.id.school_canvas);
        return view;
    }
}
