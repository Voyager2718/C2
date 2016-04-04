package com.zhipengyang.bunnyc2.Fragments.Actives;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.RelativeLayout;

import com.zhipengyang.bunnyc2.Fragments.ActiveFragments;
import com.zhipengyang.bunnyc2.R;
import com.zhipengyang.bunnyc2.Structure.SceneCanvas;

public class HomeFragment extends ActiveFragments {
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_home, container, false);
        RelativeLayout relativeLayout = (RelativeLayout) view.findViewById(R.id.home_root_layout);
        relativeLayout.addView(new SceneCanvas(getActivity()));
        return view;
    }
}
