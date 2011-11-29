package com.instruments.ocarina.ui;

import com.instruments.ocarina.R;
import android.content.Context;
import android.util.AttributeSet;

public class FingerHole extends OcarinaButton {

	// needed to generate preview in the android dev kit
	public FingerHole(Context context, AttributeSet attrs) {
		this(context, attrs, 0);
	}

	public FingerHole(Context context, AttributeSet attrs, int defStyle) {
		super(context, attrs, defStyle);

		buttonUp = R.drawable.button_up;
		buttonDown = R.drawable.button_down;
		drawableIcon = context.getResources().getDrawable(buttonUp);
		drawableIcon.setBounds(0, 0, drawableIcon.getIntrinsicWidth(), drawableIcon.getIntrinsicHeight());
	}

}
