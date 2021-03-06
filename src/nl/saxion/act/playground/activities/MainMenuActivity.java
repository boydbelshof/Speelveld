package nl.saxion.act.playground.activities;

import nl.noscope.data.DatabaseOperations;
import nl.saxion.act.playground.R;
import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.ImageButton;

public class MainMenuActivity extends Activity {
	private static MainMenuActivity instance;
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		instance = this;
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main_menu);

		setupNewGameButton();
		hideSystemUI();

		//Database operations
		Log.d("Database operations", "main menu activity oncreate //database operations");
		Context context = MainMenuActivity.getContext();
		DatabaseOperations DB = new DatabaseOperations(context);
		
		DB.appendNonExistingLevels(DB);
		Log.d("Database Operatsions main", "After append non existing Levels");
		
	}

	private void setupNewGameButton() {
		ImageButton newGameButton = (ImageButton) findViewById(R.id.imageButtonNewGame);
		newGameButton.setOnClickListener(new View.OnClickListener() {

			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub
				hideSystemUI();
				
				Log.d("setupNewGameButton onclick", "Start activity levelselect");
				startActivity(new Intent(MainMenuActivity.this,
						LevelSelect.class));

			}
		});
		Log.d("setupNewGameButton", "newGameButton setup");
	}

		private void hideSystemUI() {
			View mDecorView  = getWindow().getDecorView();
		    // Set the IMMERSIVE flag.
		    // Set the content to appear under the system bars so that the content
		    // doesn't resize when the system bars hide and show.
		    mDecorView.setSystemUiVisibility(
		            View.SYSTEM_UI_FLAG_LAYOUT_STABLE
		            | View.SYSTEM_UI_FLAG_LAYOUT_HIDE_NAVIGATION
		            | View.SYSTEM_UI_FLAG_LAYOUT_FULLSCREEN
		            | View.SYSTEM_UI_FLAG_HIDE_NAVIGATION // hide nav bar
		            | View.SYSTEM_UI_FLAG_FULLSCREEN // hide status bar
		            | View.SYSTEM_UI_FLAG_IMMERSIVE);
	
		Log.d("hideSystemUI", "hideSystemUI executed");
	}

	/** Get singleton instance of activity **/
	public static MainMenuActivity getInstance() {
	    return instance;
	}

	/** Returns context of this activity **/
	public static Context getContext(){
	    return instance.getApplicationContext();
	}
}
