package com.jjoe64.graphview_demos;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;

import com.jjoe64.graphview_demos.examples.BaseExample;

/**
 * Created by jonas on 10.09.16.
 */
public class FullscreenActivity extends AppCompatActivity {
    private BaseExample mLogic;

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        String name = getIntent().getStringExtra(FullscreenExample.ARG_ID);
        FullscreenExample example = FullscreenExample.valueOf(name);

        setContentView(example.contentView);
        try {
            mLogic = example.exampleClass.newInstance();
            mLogic.onCreate(this);
        } catch (InstantiationException e) {
            e.printStackTrace();
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        }
    }

    @Override
    protected void onResume() {
        super.onResume();
        mLogic.onResume();
    }

    @Override
    protected void onPause() {
        mLogic.onPause();
        super.onPause();
    }
}
