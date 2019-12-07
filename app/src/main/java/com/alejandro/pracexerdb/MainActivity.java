package com.alejandro.pracexerdb;

import androidx.appcompat.app.AppCompatActivity;

import android.database.Cursor;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    EditText firstname, lastname, section;
    DBHelper helper;
    Cursor cursor;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        helper = new DBHelper(this);

        firstname = findViewById(R.id.etFname);
        lastname = findViewById(R.id.etLname);
        section = findViewById(R.id.etSect);
    }

    public void addRecord(View view){
        String first = firstname.getText().toString();
        String last = lastname.getText().toString();
        String sec = section.getText().toString();
        long isInserted = helper.insert(first, last, sec);
        if(isInserted == 1) {
            Toast.makeText(this, "Inserted", Toast.LENGTH_LONG).show();
        }else {
            Toast.makeText(this, "Not Inserted", Toast.LENGTH_LONG).show();
        }
    }

    public void moveFirst(View view){
        cursor = helper.getRecord();
        cursor.moveToFirst();
        firstname.setText(cursor.getString(1));
        lastname.setText(cursor.getString(2));
        section.setText(cursor.getString(3));
    }
}
