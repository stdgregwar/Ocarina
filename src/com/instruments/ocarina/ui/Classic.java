package com.instruments.ocarina.ui;

import android.os.Bundle;
import com.instruments.ocarina.R;


/**
 * Note to reviewer: This activity was delayed to Sprint 2, so it's still in barebones form
 * 
 */
public class Classic extends OcarinaUI {

	@Override
	public void onCreate(Bundle savedInstanceState)
	{
		super.onCreate(savedInstanceState);
		setContentView(R.layout.classic);
		
		initializeComponents();
	}

	private void initializeComponents() {
		// TODO Auto-generated method stub
					
	}
}
