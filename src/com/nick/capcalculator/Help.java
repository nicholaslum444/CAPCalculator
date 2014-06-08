package com.nick.capcalculator;

import java.io.*;
import java.util.List;

import android.os.*;
import android.app.*;
import android.database.sqlite.SQLiteDatabase;
import android.view.*;
import android.widget.*;

public class Help extends Activity {

	DictionaryOpenHelper db;
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_help);
		getActionBar().setDisplayHomeAsUpEnabled(true); 
		db = new DictionaryOpenHelper(this);
		
		try {
			setHelp();
		} catch (IOException e) {
			e.printStackTrace();
		}
		
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.help, menu);
		return true;
	}
	
	public void setHelp() throws IOException {
		TextView helpView = (TextView) findViewById(R.id.help_txt);
		StringBuffer helpText = new StringBuffer();
		InputStream iStream = this.getResources().openRawResource(R.drawable.help);
		BufferedReader bReader = new BufferedReader(new InputStreamReader(iStream));
		if (iStream != null) {
			String temp = bReader.readLine();
			while (temp != null) {
				helpText.append(temp + "\n");
				temp = bReader.readLine();
			}
		}
		bReader.close();
		helpView.setText(helpText);
	}
	

	public void add(View v) {
        /**
         * CRUD Operations
         * */
        // add Books
        db.addBook(new Book("Android Application Development Cookbook", "Wei Meng Lee"));   
        db.addBook(new Book("Android Programming: The Big Nerd Ranch Guide", "Bill Phillips and Brian Hardy"));       
        db.addBook(new Book("Learn Android App Development", "Wallace Jackson"));
 
        // get all books
        List<Book> list = db.getAllBooks();
 
        // get all books
        db.getAllBooks();
	}
	
	public void del(View v) {
		db.deleteTable();
	}

}
