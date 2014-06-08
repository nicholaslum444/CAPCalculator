package com.nick.capcalculator;

import java.util.List;

import android.os.Bundle;
import android.app.Activity;
import android.content.Intent;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.EditText;

public class Home extends Activity {
	
	
	DictionaryOpenHelper db;
	
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_home);
		db = new DictionaryOpenHelper(this);
	}
	
	public void add(View v) {
        /**
         * CRUD Operations
         * */
        // add Books
		EditText e = (EditText) findViewById(R.id.edittext_add);
        db.addBook(new Book(e.getText().toString(), "Wei Meng Lee"));
 
        // get all books
        List<Book> list = db.getAllBooks();
 
        // get all books
        db.getAllBooks();
	}
	
	public void del(View v) {
		// get all books
        List<Book> list = db.getAllBooks();
        // delete one book
        db.deleteBook(list.get(0));
		
 
        // get all books
        db.getAllBooks();
		
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.home, menu);
		return true;
	}
	
	@Override
	public boolean onOptionsItemSelected(MenuItem item) {
	    // Handle presses on the action bar items
	    switch (item.getItemId()) {
	        case R.id.help_txt:
	        	Intent intent = new Intent(this, Help.class);
	    		startActivity(intent);
	            return true;
	        default:
	            return super.onOptionsItemSelected(item);
	    }
	}
	
	public void startCalc(View v) {
		Intent intent = new Intent(this, Calc.class);
		startActivity(intent);
	}

}
