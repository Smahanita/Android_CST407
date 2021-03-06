package com.example.finalproject2;

import java.util.ArrayList;

import android.app.Activity;
import android.database.Cursor;
import android.os.Bundle;
import android.provider.ContactsContract;
import android.provider.ContactsContract.PhoneLookup;
import android.widget.ArrayAdapter;
import android.widget.ListView;

public class contactListActivity extends Activity {

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_contactlist);
		
		//Get list of contact on the phone
		Cursor people = getContentResolver().query(ContactsContract.Contacts.CONTENT_URI, null, null, null, null);  
		
		ArrayList<String> contactList = new ArrayList<String>();
		
		while (people.moveToNext()){
			int nameIndex = people.getColumnIndex(PhoneLookup.DISPLAY_NAME);
			String name = people.getString(nameIndex);
			
			contactList.add(name);
		}
			ListView dropdown = (ListView)findViewById(R.id.listContactList);
			ArrayAdapter<String> adapter = new ArrayAdapter<String>(this, android.R.layout.simple_list_item_1, android.R.id.text1, contactList);
			dropdown.setAdapter(adapter);
		}
}


