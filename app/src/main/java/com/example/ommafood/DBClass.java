package com.example.ommafood;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import java.util.ArrayList;
import java.util.List;

public class DBClass extends SQLiteOpenHelper {

    public DBClass(Context context) {
        super(context, "ommafood.db", null, 1);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL("CREATE TABLE user (id INTEGER PRIMARY KEY AUTOINCREMENT, login VARCHAR(50), password VARCHAR(50));");
        db.execSQL("CREATE TABLE food (id INTEGER PRIMARY KEY AUTOINCREMENT, meal VARCHAR(50), addr VARCHAR(50), phone VARCHAR(50));");
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int i, int i1) {
        db.execSQL("DROP TABLE IF EXISTS user;");
        db.execSQL("DROP TABLE IF EXISTS food;");

        onCreate(db);
    }

    public boolean addCommande(String meal, String addr, String phone) {
        try {
            SQLiteDatabase db = this.getWritableDatabase();
            ContentValues cv = new ContentValues();
            cv.put("meal", meal);
            cv.put("addr", addr);
            cv.put("phone", phone);

            db.insert("food", null, cv);
            db.close();
            return true;
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }


    public boolean addUser(String login, String password) {
        try {
            SQLiteDatabase db = this.getWritableDatabase();
            ContentValues cv = new ContentValues();
            cv.put("login", login);
            cv.put("password", password);

            db.insert("user", null, cv);
            db.close();

            return true;
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }

    }



    public  List<Commande> getCommande(){
        List<Commande> list = new ArrayList<Commande>();

        try {
            SQLiteDatabase db = this.getReadableDatabase();
            Cursor cursor = db.query("food", null, null, null, null, null, null);
            if(cursor != null && cursor.getCount()>0){
                cursor.moveToFirst();
               do {
                   Commande commande = new Commande();

                   commande.setRepas(cursor.getString(1));
                   commande.setAddresse(cursor.getString(2));
                   commande.setTelephone(cursor.getString(3));

                   list.add(commande);
               }while (cursor.moveToNext());

            }
        }catch (Exception e){
            e.printStackTrace();
        }
        return list;
    }

    public boolean checkUserLogin(String login){
        SQLiteDatabase db = this.getWritableDatabase();
        Cursor cursor = db.rawQuery("SELECT * FROM user WHERE login=?", new String[] {login});
        if(cursor.getCount()>0)
            return true;
        else
            return false;
    }

    public boolean checkUserPassword(String login, String password){
        SQLiteDatabase db = this.getWritableDatabase();
        Cursor cursor = db.rawQuery("SELECT * FROM user WHERE login=?  AND password=?", new String[] {login,password});
        if(cursor.getCount()>0)
            return true;
        else
            return false;
    }

}
