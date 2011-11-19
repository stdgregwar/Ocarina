package com.instruments.ocarina.ui;

import java.util.ArrayList;

import android.os.Bundle;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewGroup.LayoutParams;
import android.widget.TableLayout;
import android.widget.TableRow;

import com.instruments.ocarina.Keys;
import com.instruments.ocarina.service.SoundPlayer;

/**
 * Fancy Ocarina UI
 *
 */
@SuppressWarnings("unused")
public class Fancy extends OcarinaUI {

	@Override
	public void onCreate(Bundle savedInstanceState)
	{
		super.onCreate(savedInstanceState);
		
//		setContentView(createLayout());
		OcarinaButton ocarinaButton = new OcarinaButton(Keys.FIVE, getSoundPlayer(), this);
		ocarinaButton.setLayoutParams(new ViewGroup.LayoutParams(ViewGroup.LayoutParams.MATCH_PARENT, ViewGroup.LayoutParams.MATCH_PARENT));
		setContentView(ocarinaButton);
	}

//	private TableLayout createLayout() {
//		ArrayList<OcarinaButton> ocarinaButtons = new ArrayList<OcarinaButton>();
//		// iterate through all the buttons to set their layout parameters
//		for (int i = 0; i < Keys.values().length; i++)
//		{
//			OcarinaButton ocarinaButton = new OcarinaButton(Keys.values()[i], getSoundPlayer(), this);
//			ocarinaButton.setLayoutParams(new ViewGroup.LayoutParams(ViewGroup.LayoutParams.FILL_PARENT, ViewGroup.LayoutParams.FILL_PARENT));
//			ocarinaButtons.add(ocarinaButton);
//		}
//		
//		// create the layout
//		TableLayout tableLayout = new TableLayout(this);
//		tableLayout.setLayoutParams(new LayoutParams(LayoutParams.FILL_PARENT, LayoutParams.WRAP_CONTENT));
//		
//		// add ocarina buttons to a row and add the row to the parent table
//		for (OcarinaButton ocarinaButton : ocarinaButtons)
//		{
//			TableRow tableRow = new TableRow(this);
//			tableRow.setLayoutParams(new LayoutParams(LayoutParams.FILL_PARENT, LayoutParams.WRAP_CONTENT));
//			tableRow.addView((View)ocarinaButton);
//			tableLayout.addView((View)tableRow);
//		}
//		
//		return tableLayout;
//	}	
}
