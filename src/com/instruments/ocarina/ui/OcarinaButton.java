package com.instruments.ocarina.ui;


import android.content.Context;
import android.graphics.Canvas;
import android.graphics.drawable.Drawable;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.View;

import com.instruments.ocarina.Keys;
import com.instruments.ocarina.R;
import com.instruments.ocarina.service.ISoundPlayer;

public abstract class OcarinaButton extends View {
	
	
	private Keys key;
	private ISoundPlayer soundPlayer;
	protected Drawable drawableIcon;
	protected Drawable drawableOverlayIcon;
	protected int buttonUp;
	protected int buttonDown;
	protected int buttonGlow;
	private boolean isPressed;
	
	public void setKey(Keys key) {
		this.key = key;
	}
	
	public Keys getKey() {
		return key;
	}

	public void setSoundPlayer(ISoundPlayer soundPlayer) {
		this.soundPlayer = soundPlayer;
	}

	/**
	 * Shows an overlay on the button, signaling the user to press the key
	 */
	public void showOverlay() {
		drawableOverlayIcon = getResources().getDrawable(buttonGlow);
		drawableOverlayIcon.setBounds(0, 0, drawableIcon.getIntrinsicWidth(), drawableIcon.getIntrinsicHeight());
		
		// force redraw
		postInvalidate();
	}
	
	/**
	 * Hides the overlay on the button
	 */
	public void hideOverlay() {
		drawableOverlayIcon = getResources().getDrawable(R.drawable.glow_off);
		drawableOverlayIcon.setBounds(0, 0, drawableIcon.getIntrinsicWidth(), drawableIcon.getIntrinsicHeight());
		
		// force redraw
		postInvalidate();
	}
	
	// needed to generate preview in the android dev kit
	public OcarinaButton(Context context, AttributeSet attrs) {
		this(context, attrs, 0);
	}
	
	public OcarinaButton(Context context, AttributeSet attrs, int defStyle) {
		super(context, attrs, defStyle);
		isPressed = false;
	}
	
	@Override
    public void onDraw(Canvas canvas) {
		super.onDraw(canvas);
        
		
        canvas.save();
        //canvas.translate(posX, posY);
        drawableIcon.draw(canvas);
        drawableOverlayIcon.draw(canvas);
        canvas.restore();
    }

	@Override
    public boolean onTouchEvent(MotionEvent ev) {
		
        switch(ev.getAction())
        {
	        case MotionEvent.ACTION_DOWN:
	        	// added for demonstration
	        	if (isPressed) {
	        		// reset drawableIcon state depending on the key (see above)
		        	drawableIcon = getResources().getDrawable(buttonUp);
		    		drawableIcon.setBounds(0, 0, drawableIcon.getIntrinsicWidth(), drawableIcon.getIntrinsicHeight());
		    		// force a redraw
		    		postInvalidate();
		    		// make service call to recognize button call
		    		soundPlayer.removeKey(key);
	        	} else {
	        		// set drawableIcon depending on the key (Keys.ONE is the blow hole, all others are normal keys)
	        		drawableIcon = getResources().getDrawable(buttonDown);
		    		drawableIcon.setBounds(0, 0, drawableIcon.getIntrinsicWidth(), drawableIcon.getIntrinsicHeight());
		    		// force a redraw
		    		postInvalidate();
		    		
		    		// make service call to recognize button call
		    		soundPlayer.addKey(key);
	        	}
	        	// toggle state
	        	isPressed = !isPressed;
	        	// end demo code
	        	
//	        	// set drawableIcon depending on the key (Keys.ONE is the blow hole, all others are normal keys)
//        		drawableIcon = getResources().getDrawable(buttonDown);
//	    		drawableIcon.setBounds(0, 0, drawableIcon.getIntrinsicWidth(), drawableIcon.getIntrinsicHeight());
//	    		// force a redraw
//	    		postInvalidate();
//	    		
//	    		// make service call to recognize button call
//	    		soundPlayer.addKey(key);
	        	break;
//	        default:
//	        	// reset drawableIcon state depending on the key (see above)
//	        	drawableIcon = getResources().getDrawable(buttonUp);
//	    		drawableIcon.setBounds(0, 0, drawableIcon.getIntrinsicWidth(), drawableIcon.getIntrinsicHeight());
//	    		// force a redraw
//	    		postInvalidate();
//	    		// make service call to recognize button call
//	    		soundPlayer.removeKey(key);
//	        	break;
        }
        return true;
    }
}
