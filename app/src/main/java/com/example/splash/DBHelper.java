package com.example.splash;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import androidx.annotation.Nullable;

public class DBHelper extends SQLiteOpenHelper {
    public static final String DBNAME= "Login.db";
    public static final String Table_name="Customer";
    public static final String COL_1="NAME";
    public static final String COL_2="AGE";
    public static final String COL_3="DATE";


    public DBHelper(Context context)
    {
        super(context, " Login.db",null,1 );
    }

    @Override
    public void onCreate(SQLiteDatabase MyDB) {
        MyDB.execSQL("create table "+Table_name+"(NAME TEXT, AGE INTEGER,DATE STRING)");

    }

    @Override
    public void onUpgrade(SQLiteDatabase MyDB, int i, int i1) {
MyDB.execSQL("drop Table if EXISTS "+Table_name);

    }
    public Boolean insertData (String name, String age,String date ){
        SQLiteDatabase MyDB= this.getWritableDatabase();
        ContentValues contentValues= new ContentValues();
        contentValues.put(COL_1,name);
        contentValues.put(COL_2,age);
        contentValues.put(COL_3,date);
        long result = MyDB.insert(Table_name, null,contentValues);
        if(result==-1)
            return false;
        else
            return true;
    }
    public boolean updateData(String name, String age,String date)
    {
        SQLiteDatabase db=this.getWritableDatabase();
        ContentValues contentValues=new ContentValues();
        contentValues.put(COL_1,name);
        contentValues.put(COL_2,age);
        contentValues.put(COL_3,date);
        db.update(Table_name,contentValues,"name",new String[]{name});
        return true;

    }
    public Integer deleteData( String name)
    {
        SQLiteDatabase db=this.getWritableDatabase();
        return db.delete(Table_name,"name?",new String[]{name});

    }
    public Cursor getAllData()
    {
        SQLiteDatabase db=this.getWritableDatabase();
        Cursor cursor=db.rawQuery("select * from " +Table_name,null);
        return cursor;
    }
    public boolean checkusername(String username){
        SQLiteDatabase MyDB= this.getWritableDatabase();
        Cursor cursor= MyDB.rawQuery("Select * from users where username=?", new String[] {username});
        if(cursor.getCount() > 0)
            return true;
        else
            return false;
    }
    public boolean checkusernamepassword(String username,String password){
        SQLiteDatabase MyDB=this.getWritableDatabase();
        Cursor cursor= MyDB.rawQuery("Select * from user where username=? and password=?", new String[]{username,password} );
        if(cursor.getCount()>0)
            return true;
        else
            return false;
    }
}
