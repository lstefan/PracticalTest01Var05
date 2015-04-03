package ro.pub.cs.systems.pdsd.practicaltest01var05;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class PracticalTest01Var05SecondaryActivity extends Activity {

	
	EditText edit1;
	EditText edit2; 
	
	Button register; 
	Button cancel;  
	
	private ButtonClickListener lis = new ButtonClickListener();
	
	private class ButtonClickListener implements Button.OnClickListener {

		@Override
		public void onClick(View view) {
			int nrRegistered = Integer.parseInt(edit1.getText().toString());
			
			switch(view.getId()) {
	        case R.id.button_register:
	          nrRegistered++;
	          edit1.setText(String.valueOf(edit1));
	          Intent i1 = new Intent();
	          i1.putExtra("val",nrRegistered);
	          setResult(RESULT_OK, i1);
	          finish();	          
	          break;
	        case R.id.button_cancel:

	          break;
	      }			
		}
	}
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_practical_test01_var05_secondary);
		
		edit1 = (EditText) findViewById(R.id.edit_text1);
		 edit2 = (EditText) findViewById(R.id.edit_text2);
		
		 edit1.setText(String.valueOf(0));
		 edit2.setText("");
		 
		 register = (Button) findViewById(R.id.button_register);
		 cancel  = (Button) findViewById(R.id.button_cancel);		
		 
		 
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater()
				.inflate(R.menu.practical_test01_var05_secondary, menu);
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
}
