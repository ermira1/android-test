package com.example.citiestoremember.test;

import android.graphics.Rect;
import android.test.ActivityInstrumentationTestCase2;
import com.example.citiestoremember.MainActivity;  
import com.example.citiestoremember.R;   
import android.view.View;  
import android.widget.Button;  

public class MainActivityLayoutTest extends
		ActivityInstrumentationTestCase2<MainActivity> {
	private Button addButton;  
	   private Button mapButton;  
	   private View mainLayout;  

	public MainActivityLayoutTest() {
		super("com.example.citiestoremember", MainActivity.class);
	}

	protected void setUp() throws Exception {
		super.setUp();
		MainActivity mainActivity = getActivity();  
	       addButton = (Button) mainActivity.findViewById(R.id.button1);  
	       mapButton = (Button) mainActivity  
	               .findViewById(R.id.button2);  
	       mainLayout = (View) mainActivity.findViewById(R.id.tableRow1);  
	}
	
	public void testAddButtonOnScreen() {  
		   int fullWidth = mainLayout.getWidth();  
		   int fullHeight = mainLayout.getHeight();  
		   int[] mainLayoutLocation = new int[2];  
		   mainLayout.getLocationOnScreen(mainLayoutLocation);  
		   int[] viewLocation = new int[2];  
		   addButton.getLocationOnScreen(viewLocation);  
		   Rect outRect = new Rect();  
		   addButton.getDrawingRect(outRect);  
		   assertTrue("Add button off the left of the screen", fullWidth  
		           + mainLayoutLocation[0] > outRect.width() + viewLocation[0]);  
		   assertTrue("Add button off the bottom of the screen", fullHeight  
		           + mainLayoutLocation[1] > outRect.height() + viewLocation[1]);  
		}

}
