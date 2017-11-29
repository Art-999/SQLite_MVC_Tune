package com.example.user.sqlite_mvc_tune;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {
    private EditText nameField;
    private EditText numberField;
    private Button addButton;

    private DBHelper helper=new DBHelper(this);

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        nameField=(EditText)findViewById(R.id.nameField);
        numberField=(EditText)findViewById(R.id.numberField);
        addButton=(Button)findViewById(R.id.button);
        addButton.setOnClickListener(this);
    }


    @Override
    public void onClick(View v) {
        if(v.getId()==R.id.button){
            Contact contact=new Contact();
            contact.setName(nameField.getText().toString());
            contact.setNumber(numberField.getText().toString());
            helper.addContact(contact);

            nameField.setText("");
            numberField.setText("");

            Log.d("mLog",(helper.getContact(4).toString()));

        }

    }
}
