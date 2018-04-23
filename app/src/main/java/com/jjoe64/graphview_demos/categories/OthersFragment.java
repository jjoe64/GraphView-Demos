package com.jjoe64.graphview_demos.categories;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.jjoe64.graphview_demos.FullscreenExample;
import com.jjoe64.graphview_demos.ItemDetailFragment;
import com.jjoe64.graphview_demos.R;

/**
 * Created by jonas on 07.09.16.
 */
public class OthersFragment extends ItemDetailFragment {
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View rootView = inflater.inflate(R.layout.others_content, container, false);

        rootView.findViewById(R.id.cardSnapshotGraph).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                openFullscreen(FullscreenExample.SNAPSHOT_SHARE);
            }
        });
        rootView.findViewById(R.id.imgFullscreen1).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                openFullscreen(FullscreenExample.SNAPSHOT_SHARE);
            }
        });
        rootView.findViewById(R.id.imgSource1).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                openSource(FullscreenExample.SNAPSHOT_SHARE);
            }
        });

        return rootView;
    }
}
