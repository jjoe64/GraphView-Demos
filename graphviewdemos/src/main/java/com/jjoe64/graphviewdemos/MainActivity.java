package com.jjoe64.graphviewdemos;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.RadioButton;
import android.widget.Toast;

public class MainActivity extends Activity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main);

        ((Button) findViewById(R.id.btn_simple)).setOnClickListener(new OnClickListener() {
            @Override
            public void onClick(View v) {
                startGraphActivity(SimpleGraph.class);
            }
        });
        ((Button) findViewById(R.id.btn_advanced)).setOnClickListener(new OnClickListener() {
            @Override
            public void onClick(View v) {
                startGraphActivity(AdvancedGraph.class);
            }
        });
        ((Button) findViewById(R.id.btn_muliple_series)).setOnClickListener(new OnClickListener() {
            @Override
            public void onClick(View v) {
                startGraphActivity(AdvancedMultipleSeriesGraph.class);
            }
        });
        ((Button) findViewById(R.id.btn_realtime)).setOnClickListener(new OnClickListener() {
            @Override
            public void onClick(View v) {
                startGraphActivity(RealtimeGraph.class);
            }
        });
        ((Button) findViewById(R.id.btn_styles)).setOnClickListener(new OnClickListener() {
            @Override
            public void onClick(View v) {
                startGraphActivity(StylesGraph.class);
            }
        });
        ((Button) findViewById(R.id.btn_removeadd)).setOnClickListener(new OnClickListener() {
            @Override
            public void onClick(View v) {
                startGraphActivity(RemoveAddSeries.class);
            }
        });
        ((Button) findViewById(R.id.btn_customlabelformatter)).setOnClickListener(new OnClickListener() {
            @Override
            public void onClick(View v) {
                startGraphActivity(CustomLabelFormatterActivity.class);
            }
        });
        ((Button) findViewById(R.id.btn_ownmodelasdata)).setOnClickListener(new OnClickListener() {
            @Override
            public void onClick(View v) {
                startGraphActivity(OwnModelAsData.class);
            }
        });
        ((Button) findViewById(R.id.btn_negativevalues)).setOnClickListener(new OnClickListener() {
            @Override
            public void onClick(View v) {
                startGraphActivity(NegativeValuesGraph.class);
            }
        });
        ((Button) findViewById(R.id.btn_labels)).setOnClickListener(new OnClickListener() {
            @Override
            public void onClick(View v) {
                startGraphActivity(LabelsGraph.class);
            }
        });
    }

    private void startGraphActivity(Class<? extends Activity> activity) {
        Intent intent = new Intent(MainActivity.this, activity);
        if (((RadioButton) findViewById(R.id.radio_bar)).isChecked()) {
            if (activity == AdvancedMultipleSeriesGraph.class) {
                Toast.makeText(this, "Bar Charts are not implemented for multiple series, yet.", Toast.LENGTH_LONG).show();
                return;
            }
            intent.putExtra("type", "bar");
        } else {
            intent.putExtra("type", "line");
        }
        startActivity(intent);
    }
}
