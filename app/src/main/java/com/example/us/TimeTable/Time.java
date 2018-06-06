package com.example.us.TimeTable;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;



public class Time extends SQLiteOpenHelper{

    private static final String DATABASE_NAME = "xedb";
    private static final int DATABASE_VERSION = 1;
    private static final String TABLE_NAME = "tb_xe";
    private static final String KEY_ID = "_id";
    private static final String MA_XE = "maxe";
    private static final String TEN_XE = "tenxe";
    private static final String NAM_SX = "namsx";


    public Time(Context context) {
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase sqLiteDatabase) {
        String sql = " create table " + TABLE_NAME +
                "("+
                KEY_ID + " integer primary key autoincrement, " +
                MA_XE + " text, " +
                TEN_XE + " text, " +
                NAM_SX + " text, " +

                ")";
        sqLiteDatabase.execSQL(sql);
        ;

    }

    @Override
    public void onUpgrade(SQLiteDatabase sqLiteDatabase, int i, int i1) {
        sqLiteDatabase.execSQL("drop table if exists "+TABLE_NAME);
        onCreate(sqLiteDatabase);

    }


    public void taocar(String maxe, String tenxe, String namsx){
        SQLiteDatabase db = this.getWritableDatabase();

        ContentValues noidung = new ContentValues();
        noidung.put(MA_XE, maxe);
        noidung.put(TEN_XE,tenxe);
        noidung.put(NAM_SX,namsx);


        String nullColumHack = null;
        db.insert(TABLE_NAME, nullColumHack, noidung);
    }
    public Cursor getAllCar(){
        SQLiteDatabase db = this.getReadableDatabase();
        Cursor con_tro = db.rawQuery("select * from " + TABLE_NAME, null);
        return con_tro;
    }
    public boolean xoacar(String maxe){
        SQLiteDatabase db = this.getWritableDatabase();
        return db.delete(TABLE_NAME,MA_XE + " = " +"'"+maxe+"'",null)>0;
    }
    public  boolean suacar(String maxe, String tenxe, String namsx){
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues noidung = new ContentValues();
        noidung.put(MA_XE,maxe);
        noidung.put(TEN_XE,tenxe);
        noidung.put(NAM_SX,namsx);

        return db.update(TABLE_NAME,noidung,MA_XE+ " = " +"'"+maxe+"'",null)>0;
    }
}
