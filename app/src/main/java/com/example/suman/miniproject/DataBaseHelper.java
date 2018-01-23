package com.example.suman.miniproject;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.SQLException;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

/**
 * Created by suman on 27-09-2017.
 */

public class DataBaseHelper extends SQLiteOpenHelper {
    private static final int DATABASE_VERSION = 1;
    private static final String DATABASE_NAME = "miniprojectFINAL.db";
    private static final String TABLE_NAME = "user2";
     private static final String COLUMN_ID = "id";
    private static final String COLUMN_NAME = "name";
    private static final String COLUMN_DOB = "DOB";
    private static final String COLUMN_EMAIL = "email";
    private static final String COLUMN_PASS = "password";
    SQLiteDatabase db;
    public Context context;
    //private static final String TABLE_CREATE = "create table user( id integer primary key not null auto_increment, name text not null ,DOB text not null,email text not null, password text not null);";
    private String TABLE_CREATE = "CREATE TABLE " + TABLE_NAME + "("
            + COLUMN_ID + " INTEGER PRIMARY KEY AUTOINCREMENT," + COLUMN_NAME + " TEXT," + COLUMN_DOB + " TEXT,"
            + COLUMN_EMAIL + " TEXT," + COLUMN_PASS+ " TEXT" + ")";

    public DataBaseHelper(Context context) {

        super(context, DATABASE_NAME, null, DATABASE_VERSION);

    }


    @Override
    public void onCreate(SQLiteDatabase db) {
         DataBaseHelper helper = new DataBaseHelper(context);
        db.execSQL(TABLE_CREATE);
        this.db = db;


    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        String query = "DROP TABLE IF EXISTS" + TABLE_NAME;
        db.execSQL(query);
        this.onCreate(db);


    }

    /*public void insertContact(Contact c) {

        db = this.getWritableDatabase();
        ContentValues values = new ContentValues();

        String query="select * from "+TABLE_NAME;
        Cursor cursor=db.rawQuery(query,null);
        int count= cursor.getCount();

        values.put(COLUMN_ID,count);
        values.put(COLUMN_NAME, c.getName());
        values.put(COLUMN_DOB, c.getDOB());
        values.put(COLUMN_EMAIL, c.getEmail());
        values.put(COLUMN_PASS, c.getPass());

        db.insert(TABLE_NAME, null, values);
        db.close();
    }*/
    public void insertContact(Contact c) {
        SQLiteDatabase db = this.getWritableDatabase();

        ContentValues values = new ContentValues();
        values.put(COLUMN_NAME,c.getName());
        values.put(COLUMN_DOB,c.getDOB());
        values.put(COLUMN_EMAIL,c.getEmail());
        values.put(COLUMN_PASS,c.getPass());

        // Inserting Row
        db.insert(TABLE_NAME,null,values);
        db.close();
    }

    /* public String searchPass(String em)
     {
         db=this.getReadableDatabase();
         String query ="select email,password from contacts where email='"+em+"'";
         Cursor cursor= db.rawQuery(query,null);
         String a,c;
         c ="not found";
         if(cursor.moveToFirst())
         {
            // do{
                 a=cursor.getString(0);

                 if(a.equals(em))
                 {
                     c =cursor.getString(1);

                     //break;
                 }

             }
             //while(cursor.moveToNext());

         cursor.close();

         return c;



     }

     /*public String searchPass(String em) {
         db = this.getReadableDatabase();
         //String query = "select password from contacts where email='" + em + "'";
         Cursor c = db.rawQuery("select * from contacts where email='" + em + "'", null);
         String a="nothing";
         if (c.moveToFirst()) {
             // Displaying record if found
             a=c.getString(0);

             // editMarks.setText(c.getString(2));
         }
         //else
         return a;
         //{
         //  showMessage("Error", "Invalid Rollno");
         //clearText();
         //}

 */  /*public String searchPass(String em) {
        String[] columns = {


                DataBaseHelper.COLUMN_NAME, DataBaseHelper.COLUMN_DOB,
                DataBaseHelper.COLUMN_EMAIL,
                DataBaseHelper.COLUMN_PASS,

        };

        Cursor cursor = db.query(DataBaseHelper.TABLE_NAME, columns, null, null, null, null, null, null);
        String password = "is null";
        if (cursor.getCount() > 0) {
            while (cursor.moveToNext()) {

                String name = cursor.getString(cursor.getColumnIndex(DataBaseHelper.COLUMN_NAME));
                String DOB = cursor.getString(cursor.getColumnIndex(DataBaseHelper.COLUMN_DOB));
                String email = cursor.getString(cursor.getColumnIndex(DataBaseHelper.COLUMN_EMAIL));
                password = cursor.getString(cursor.getColumnIndex(DataBaseHelper.COLUMN_PASS));
            }
        }

        return password;
    }*/
    public boolean searchPass(String email, String password) {

        // array of columns to fetch
        String[] columns = {
                COLUMN_ID
        };
        SQLiteDatabase db = this.getReadableDatabase();
        // selection criteria
        String selection = COLUMN_EMAIL + " = ?" + " AND " + COLUMN_PASS + " = ?";

        // selection arguments
        String[] selectionArgs = {email, password};

        // query user table with conditions
        /**
         * Here query function is used to fetch records from user table this function works like we use sql query.
         * SQL query equivalent to this query function is
         * SELECT user_id FROM user WHERE user_email = 'jack@androidtutorialshub.com' AND user_password = 'qwerty';
         */
        Cursor cursor = db.query(TABLE_NAME, //Table to query
                columns,                    //columns to return
                selection,                  //columns for the WHERE clause
                selectionArgs,              //The values for the WHERE clause
                null,                       //group the rows
                null,                       //filter by row groups
                null);                      //The sort order

        int cursorCount = cursor.getCount();

        cursor.close();
        db.close();
        if (cursorCount>0) {
            return true;
        }

        return false;
    }
}




