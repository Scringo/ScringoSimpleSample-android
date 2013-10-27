package com.scringo.scringosimplesample;

import com.scringo.Scringo;

import android.os.Bundle;
import android.app.Activity;
import android.view.Menu;
import android.view.View;
import android.widget.Button;

public class MainActivity extends Activity {

	private Scringo scringo;
	
	private static final boolean withSidebar = true; // change this to false to open Scringo programmatically

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		Scringo.setAppId("<YOUR_SCRINGO_APP_ID>"); // Create an app at https://dev.scringo.com
		scringo = new Scringo(this);
		scringo.init();
		Button myButton = (Button) findViewById(R.id.myButton);
		myButton.setOnClickListener(new View.OnClickListener() {
			@Override
			public void onClick(View arg0) {
				Scringo.openMenu(MainActivity.this);
			}
		});
		if (withSidebar) {
			scringo.addSidebar();
		} else {
			myButton.setVisibility(View.VISIBLE);
		}
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.main, menu);
		return true;
	}
	
	@Override
	protected void onStart() {
		super.onStart();
		scringo.onStart();
	}
	
	@Override
	protected void onStop() {
		super.onStop();
		scringo.onStop();
	}

	@Override
	public void onBackPressed() {
        if (!scringo.onBackPressed()) {
            super.onBackPressed();
        }
	}
}
