package com.haseebazeem.sampleGif;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.Toast;

import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

public class MainActivity extends AppCompatActivity {

	GifImageView gifImageView;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate( savedInstanceState );
		setContentView( R.layout.activity_main );

		gifImageView = (GifImageView) findViewById( R.id.gifImage );
		// gifImageView.setGifImageResource(R.drawable.splashscreen);

		Executors.newSingleThreadScheduledExecutor()
				.schedule( ()->runOnUiThread( ()->gifImageView.stop() ), 5, TimeUnit.SECONDS );

		Executors.newSingleThreadScheduledExecutor()
				.schedule( ()->runOnUiThread( ()->gifImageView.start()), 10, TimeUnit.SECONDS );

	}
}
