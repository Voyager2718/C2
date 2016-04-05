package com.zhipengyang.bunnyc2.fragments;

import android.app.Fragment;
import android.os.Bundle;
import android.view.View;

import com.zhipengyang.bunnyc2.structure.SceneCanvas;

public class ActiveFragments extends Fragment {
    protected SceneCanvas sceneCanvas;

    public View getCanvas() {
        return sceneCanvas;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }
}