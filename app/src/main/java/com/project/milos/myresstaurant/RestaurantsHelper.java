package com.project.milos.myresstaurant;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

/**
 * Created by Miloš on 1/9/2017.
 */

public class RestaurantsHelper extends SQLiteOpenHelper {
    private static final int DATABASE_VERSION = 1;
    private static final String DATABASE_NAME = "contacts.db";
    private static final String TABLE_NAME = "meals";
    private static final String TABLE_NAME2 = "restaurants";
    private static final String TABLE_NAME3 = "tags";
    private static final String COLUMN_ID = "_id";
    private static final String COLUMN_NAME = "name";
    private static final String COLUMN_DESC = "description";
    private static final String COLUMN_PRICE = "price";
    private static final String COLUMN_ICON = "icon";
    private static final String COLUMN_ADDRESS = "address";
    private static final String COLUMN_STARTH = "starth";
    private static final String COLUMN_ENDH = "endh";
    private static final String COLUMN_STARTM = "startm";
    private static final String COLUMN_ENDM = "endm";
    private static final String COLUMN_EMAIL = "email";
    private static final String COLUMN_SITE = "site";
    private static final String COLUMN_PHONE = "phone";

    SQLiteDatabase db;
    private static final String TABLE_CREATE = "create table meals (_id integer primary key autoincrement, " +
            "name text not null, description text not null, price integer)";

    private static final String TABLE_TAGS = "create table tags (_id integer primary key autoincrement, " +
            "tag text not null)";

    private static final String TABLE_RESTAURANTS = "create table restaurants (_id integer primary key autoincrement, " +
            "name text not null, description text not null, icon integer, address text, starth integer, endh integer, "  +
            "startm integer, endm integer, email text, site text, phone text)";



    public RestaurantsHelper(Context context) {
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
    }


    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL(TABLE_CREATE);
        db.execSQL(TABLE_RESTAURANTS);
        db.execSQL(TABLE_TAGS);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        String dropMeals = "DROP TABLE IF EXISTS " + TABLE_NAME;
        String dropRestaurants = "DROP TABLE IF EXISTS " + TABLE_NAME2;
        String dropTags = "DROP TABLE IF EXISTS " + TABLE_NAME3;
        db.execSQL(dropMeals);
        db.execSQL(dropRestaurants);
        db.execSQL(dropTags);
        this.onCreate(db);
    }

    public  void insertMeal(Meal meal){
        db = this.getWritableDatabase();
        ContentValues values = new ContentValues();
        values.put(COLUMN_NAME, meal.getName());
        values.put(COLUMN_DESC, meal.getDescription());
        values.put(COLUMN_PRICE, meal.getPrice());
        db.insert(TABLE_NAME, null, values);
    }

    public void insertRestaurant(Restaurant restaurant){
        db = this.getWritableDatabase();
        ContentValues values = new ContentValues();
        values.put(COLUMN_NAME, restaurant.getName());
        values.put(COLUMN_DESC, restaurant.getDescription());
        values.put(COLUMN_ADDRESS, restaurant.getAddress());
        values.put(COLUMN_STARTH, restaurant.getStartHour());
        values.put(COLUMN_ENDH, restaurant.getEndHour());
        values.put(COLUMN_STARTM, restaurant.getStartMinute());
        values.put(COLUMN_ENDM, restaurant.getEndMinute());
        values.put(COLUMN_EMAIL, restaurant.getEmail());
        values.put(COLUMN_SITE, restaurant.getSite());
        values.put(COLUMN_PHONE, restaurant.getPhone());

        db.insert(TABLE_NAME2, null, values);
    }

    public void dropMeals() {
        db.execSQL("DROP TABLE IF EXISTS meals");
    }

    public Cursor getAllData() {
        SQLiteDatabase db = this.getWritableDatabase();
        Cursor res = db.rawQuery("select _id,name,description,price from " + TABLE_NAME, null);
        return res;
    }

    public Cursor getRestaurants() {
        SQLiteDatabase db = this.getWritableDatabase();
        Cursor res = db.rawQuery("select * from " + TABLE_NAME2, null);
        return res;
    }

}
