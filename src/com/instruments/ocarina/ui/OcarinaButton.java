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
	private Keys key;
	private Drawable mIcon;
	private ISoundPlayer soundPlayer;
	
	public OcarinaButton(Keys key, ISoundPlayer soundPlayer, Context context) {
		this(key, soundPlayer, context, null, 0);
	}
	
	public OcarinaButton(Keys key, ISoundPlayer soundPlayer, Context context, AttributeSet attrs) {
		this(key, soundPlayer, context, attrs, 0);
	}
	
	public OcarinaButton(Keys key, ISoundPlayer soundPlayer, Context context, AttributeSet attrs, int defStyle) {
		super(context, attrs, defStyle);
		
		this.key = key;
		this.soundPlayer = soundPlayer;
		
		mIcon = context.getResources().getDrawable(R.drawable.blow1);
		mIcon.setBounds(0, 0, mIcon.getIntrinsicWidth(), mIcon.getIntrinsicHeight());
	}
	
	@Override
    public void onDraw(Canvas canvas) {
		super.onDraw(canvas);
        
//		Log.d("yeah", Integer.toString(canvas.getHeight()));
//		Log.d("yeah", Integer.toString(canvas.getWidth()));
		
        canvas.save();
        //canvas.translate(posX, posY);
        mIcon.draw(canvas);
        canvas.restore();
    }

	@Override
    public boolean onTouchEvent(MotionEvent ev) {
        switch(ev.getAction())
        {
	        case MotionEvent.ACTION_DOWN:
	        	mIcon = getResources().getDrawable(R.drawable.fancy_button_b);
	    		mIcon.setBounds(0, 0, mIcon.getIntrinsicWidth(), mIcon.getIntrinsicHeight());
	    		// force a redraw
	    		postInvalidate();
	    		
	    		// make service call to recognize button call
	    		soundPlayer.addKey(key);
	        	break;
	        default:
	        	mIcon = getResources().getDrawable(R.drawable.fancy_button_a);
	    		mIcon.setBounds(0, 0, mIcon.getIntrinsicWidth(), mIcon.getIntrinsicHeight());
	    		// force a redraw
	    		postInvalidate();
	    		// make service call to recognize button call
	    		soundPlayer.removeKey(key);
	        	break;
        }
        return true;
    }
}
