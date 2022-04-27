package com.logan.contactmanager;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;

import com.logan.contactmanager.data.DatabaseHandler;
import com.logan.contactmanager.model.Contact;

import java.util.List;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        DatabaseHandler db = new DatabaseHandler(MainActivity.this);

        // Create contact obj
        Contact jeremy = new Contact();
        jeremy.setName("Jeremy");
        jeremy.setPhoneNumber("985747374");

        // Add contact obj to db
        db.addContact(jeremy);

//        // Get 1 contact from db
//        Contact c = db.getContact(5);
//        Log.d("TEST", "onCreate: " + c.getPhoneNumber() + ", " + c.getName());
//
//        // Update data in db
//        Contact tmp = new Contact();
//        tmp.setId(7);
//        tmp.setName("ludi");
//        tmp.setPhoneNumber("777777777");
//
//        //The return value of the update() method is the number of rows affected in the database.
//        int updateRow = db.updateContact(tmp);
//
//        // Get All contact from db
//        List<Contact> contactList = db.getAllContacts();
//        for (Contact contact: contactList){
//            Log.d("TEST", "onCreate: " + contact.getName() + ", id = " + contact.getId());
//        }
//
//        // Delete data in db
////        db.deleteContact(c);

        Log.d("TEST", "Total rows: " + db.getCount());
    }
}