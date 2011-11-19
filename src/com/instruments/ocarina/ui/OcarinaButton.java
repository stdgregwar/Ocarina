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

public class OcarinaButton extends View {
	
	private Drawable drawableIcon;
	private Keys key;
	private ISoundPlayer soundPlayer;
	
	public void setKey(Keys key) {
		this.key = key;
	}

	public void setSoundPlayer(ISoundPlayer soundPlayer) {
		this.soundPlayer = soundPlayer;
	}

//	public OcarinaButton(Context context) {
//		this(context, null, 0);
//	}

	public OcarinaButton(Context context, AttributeSet attrs) {
		this(context, attrs, 0);
	}
	
	public OcarinaButton(Context context, AttributeSet attrs, int defStyle) {
		super(context, attrs, defStyle);
		
		drawableIcon = context.getResources().getDrawable(R.drawable.button_up);
		drawableIcon.setBounds(0, 0, drawableIcon.getIntrinsicWidth(), drawableIcon.getIntrinsicHeight());
	}
	
	@Override
    public void onDraw(Canvas canvas) {
		super.onDraw(canvas);
        
		
        canvas.save();
        //canvas.translate(posX, posY);
        drawableIcon.draw(canvas);
        canvas.restore();
    }

	@Override
    public boolean onTouchEvent(MotionEvent ev) {
		// TODO: refine motion event actions
        switch(ev.getAction())
        {
	        case MotionEvent.ACTION_DOWN:
	        	drawableIcon = getResources().getDrawable(R.drawable.button_down);
	    		drawableIcon.setBounds(0, 0, drawableIcon.getIntrinsicWidth(), drawableIcon.getIntrinsicHeight());
	    		// force a redraw
	    		postInvalidate();
	    		
	    		// make service call to recognize button call
	    		soundPlayer.addKey(key);
	        	break;
	        default:
	        	drawableIcon = getResources().getDrawable(R.drawable.button_up);
	    		drawableIcon.setBounds(0, 0, drawableIcon.getIntrinsicWidth(), drawableIcon.getIntrinsicHeight());
	    		// force a redraw
	    		postInvalidate();
	    		// make service call to recognize button call
	    		soundPlayer.removeKey(key);
	        	break;
        }
        return true;
    }
}
