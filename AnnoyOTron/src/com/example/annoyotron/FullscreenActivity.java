package com.example.annoyotron;
 
import android.app.Activity;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.os.Handler;
import android.view.MotionEvent;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.View.OnTouchListener;
import android.widget.Button;
 
public class FullscreenActivity extends Activity {
 
    private Button buttonPlayStop;
    private MediaPlayer mediaPlayer;
    
    
    private final Handler handler = new Handler();
 
    // Here i override onCreate method.
    //
    // setContentView() method set the layout that you will see then
    // the application will starts
    //
    // initViews() method i create to init views components.
    @Override
    public void onCreate(Bundle icicle) {
            super.onCreate(icicle);
            setContentView(R.layout.activity_fullscreen);
            initViews();  
 
    }
 
    // This method set the setOnClickListener and method for it (buttonClick())
    private void initViews() {
        buttonPlayStop = (Button) findViewById(R.id.imageButton1);
        buttonPlayStop.setOnClickListener(new OnClickListener() {@Override public void onClick(View v) {buttonClick();}});
 
        mediaPlayer = MediaPlayer.create(this, R.raw.beep-6); 
 
        
		};
 
    
    
   
    // This is event handler for buttonClick event
    private void buttonClick(){
        if (buttonPlayStop.getText() == getString(R.string.play_str)) {
            buttonPlayStop.setText(getString(R.string.pause_str));
            try{
            	mediaPlayer.start();
             
            }catch (IllegalStateException e) {
            	mediaPlayer.pause();
            }
        }else {
            buttonPlayStop.setText(getString(R.string.play_str));
            mediaPlayer.pause();
        }
    }
}