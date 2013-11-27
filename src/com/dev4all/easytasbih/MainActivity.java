package com.dev4all.easytasbih;

import android.os.Bundle;
import android.app.Activity;
import android.view.KeyEvent;
import android.view.Menu;
import android.view.View;
import android.widget.TextView;

public class MainActivity extends Activity {
	
	private static int counterValue = 0;
	
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    @Override
    public boolean dispatchKeyEvent(KeyEvent event) {
        int action = event.getAction();
        int keyCode = event.getKeyCode();
            switch (keyCode) {
            /*
            case KeyEvent.KEYCODE_POWER:
                if (action == KeyEvent.FLAG_FROM_SYSTEM) {
                	counterValue += 1;
                	updateCurrentCounter();
                }
                return true;
            */
            case KeyEvent.KEYCODE_VOLUME_UP:
                if (action == KeyEvent.ACTION_UP) {
                	increaseCounter();
                }
                return true;
            case KeyEvent.KEYCODE_VOLUME_DOWN:
                if (action == KeyEvent.ACTION_DOWN) {
                	decreaseCounter();
                }
                return true;
            default:
                return super.dispatchKeyEvent(event);
            }
    }
    
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.main, menu);
        return true;
    }
    
    protected void updateCurrentCounter()
    {
    	TextView textView = (TextView) findViewById(R.id.counterNumber);
    	textView.setText(""+counterValue);
    }
    
    protected void increaseCounter()
    {
    	counterValue += 1;
    	updateCurrentCounter();    	
    }
    
    protected void decreaseCounter()
    {
    	counterValue -= 1;
    	
    	if(counterValue <0)
    		counterValue = 0;
    	
    	updateCurrentCounter();    	
    }
        
    public void counterClicked(View view)
    {
    	increaseCounter();
    }

    public void resetClicked(View view)
    {
    	counterValue = 0;
    	updateCurrentCounter();
    }

	public static int getCounterValue() {
		return counterValue;
	}


	public static void setCounterValue(int counterValue) {
		MainActivity.counterValue = counterValue;
	}
}
