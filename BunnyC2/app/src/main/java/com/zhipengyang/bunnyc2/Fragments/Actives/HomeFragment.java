package com.zhipengyang.bunnyc2.fragments.actives;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.zhipengyang.bunnyc2.fragments.ActiveFragments;
import com.zhipengyang.bunnyc2.R;

public class HomeFragment extends ActiveFragments {
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_home, container, false);

        //RelativeLayout relativeLayout = (RelativeLayout) view.findViewById(R.id.home_root_layout);
        //relativeLayout.addView(new SceneCanvas(getActivity()));

        return view;
    }
}
