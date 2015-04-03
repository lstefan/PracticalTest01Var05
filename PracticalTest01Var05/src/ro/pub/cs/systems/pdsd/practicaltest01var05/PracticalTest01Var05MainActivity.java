package ro.pub.cs.systems.pdsd.practicaltest01var05;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;


public class PracticalTest01Var05MainActivity extends Activity {

	protected final int[] buttonIds  = {
		R.id.button_north,
		R.id.button_west,
		R.id.button_east,
		R.id.button_south
	};
	

	protected Button nav;
	
	protected EditText textBox;
	
	protected int nr, counter;
	
	private ButtonClickListener lis = new ButtonClickListener();
	
	
	
	private class ButtonClickListener implements Button.OnClickListener {

		@Override
		public void onClick(View view) {
			switch(view.getId()) {
			case R.id.button_east:
				textBox.append("East");
				counter++;
				break;				
			case R.id.button_west:		
				textBox.append("West");
				counter++;
				break;				
			case R.id.button_south:		
				textBox.append("South");
				counter++;
				break;				
			case R.id.button_north:			
				textBox.append("North");
				counter++;
				break;				
			
			case R.id.button_nav:
				Intent intent = new Intent("ro.pub.cs.systems.pdsd.Second");
		          intent.putExtra("number_of_coord", String.valueOf(counter));
		          startActivityForResult(intent,1);
		          break;				
			}
			
		}
		
	}
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_practical_test01_var05_main);
		nav = (Button) findViewById(R.id.button_nav);
		textBox = (EditText) findViewById(R.id.edit_text);
		
		textBox.setText("");
		
		//add listener
		nav.setOnClickListener(lis);
		
		for(int i = 0; i < buttonIds.length; i++) {
			((Button) findViewById(buttonIds[i])).setOnClickListener(lis);
		}
		
		nr = 0;
		counter = 0;
		
		
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.practical_test01_var05_main, menu);
		return true;
	}

	@Override
	public boolean onOptionsItemSelected(MenuItem item) {
		// Handle action bar item clicks here. The action bar will
		// automatically handle clicks on the Home/Up button, so long
		// as you specify a parent activity in AndroidManifest.xml.
		int id = item.getItemId();
		if (id == R.id.action_settings) {
			return true;
		}
		return super.onOptionsItemSelected(item);
	}
	
	@Override
	  protected void onSaveInstanceState(Bundle savedInstanceState) {
	    savedInstanceState.putString("nr", String.valueOf(nr));
	  }	
	
	@Override
	  protected void onRestoreInstanceState(Bundle savedInstanceState) {
		if(savedInstanceState.containsKey("nr"))
			nr = Integer.parseInt(savedInstanceState.getString("nr"));
	  }		
}
