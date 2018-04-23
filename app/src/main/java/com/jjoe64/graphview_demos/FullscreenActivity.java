package com.jjoe64.graphview_demos;

import android.content.pm.PackageManager;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.widget.Toast;

import com.jjoe64.graphview_demos.examples.BaseExample;
import com.jjoe64.graphview_demos.examples.SnapshotShareGraph;

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

    @Override
    public void onRequestPermissionsResult(int requestCode,
                                           String permissions[], int[] grantResults) {
        switch (requestCode) {
            case SnapshotShareGraph.REQUEST_CODE_PERMISSION: {
                // If request is cancelled, the result arrays are empty.
                if (grantResults.length > 0
                        && grantResults[0] == PackageManager.PERMISSION_GRANTED) {

                    SnapshotShareGraph example = (SnapshotShareGraph) mLogic;
                    example.snapshot();

                } else {
                    Toast.makeText(this, "Permission denied. Not possible to show example.", Toast.LENGTH_SHORT).show();
                }
                return;
            }
        }
    }

}
