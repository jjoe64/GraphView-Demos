package com.jjoe64.graphviewdemos;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.RadioButton;

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
	}

	private void startGraphActivity(Class<? extends Activity> activity) {
		Intent intent = new Intent(MainActivity.this, activity);
		if (((RadioButton) findViewById(R.id.radio_bar)).isChecked()) {
			intent.putExtra("type", "bar");
		} else {
			intent.putExtra("type", "line");
		}
		startActivity(intent);
	}
}
