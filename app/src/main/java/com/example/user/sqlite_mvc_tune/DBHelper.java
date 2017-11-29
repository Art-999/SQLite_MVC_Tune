package com.example.user.sqlite_mvc_tune;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

/**
 * Created by user on 17.02.2017.
 */

public class DBHelper extends SQLiteOpenHelper {
    public static final String DBNAME="contactDB1";
    public static final int DBVERSION=1;

    public SQLiteDatabase db;

    public DBHelper(Context context) {
        super(context, DBNAME, null, DBVERSION);
    }

    public void addContact(Contact contact){
        ContentValues cv=new ContentValues();
        cv.put("name",contact.getName());
        cv.put("number",contact.getNumber());

         db=getWritableDatabase();
        db.insert("contacts",null,cv);

    }

    //sarqum enq metod vor iran aktivitiic id kam tiv tanq inq@ mez tox@ veradarzni
    public Contact getContact(int id){
        db=getWritableDatabase();

        Contact contact=new Contact();
        Cursor c=db.query("contacts",null,id+"",null,null,null,null);

        c.moveToFirst();
            contact.setId(id);
            contact.setName(c.getString(1));
            contact.setNumber(c.getString(2));
        c.close();
        db.close();


        return contact;
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        String queryCreateTable="create table contacts"+
                "(id integer primary key autoincrement,name text,number text);";
        db.execSQL(queryCreateTable);

    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {

    }
}
