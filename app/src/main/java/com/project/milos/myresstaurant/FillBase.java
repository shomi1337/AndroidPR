package com.project.milos.myresstaurant;

import android.app.Activity;
import android.content.ContentValues;
import android.database.sqlite.SQLiteDatabase;

/**
 * Created by Miloš on 1/11/2017.
 */

public class FillBase {
    public static void initDB(Activity activity) {
        RestaurantsHelper dbHelper = new RestaurantsHelper(activity);

        Restaurant rest = new Restaurant();
        rest.setName("Caribic");
        rest.setDescription(" Počeli smo kao mali porodični posao");
//            entry.put(RestaurantsHelper.COLUMN_ICON_ID, R.drawable.logo_caribic_red);
        rest.setAddress("Bulevar Oslobodjenja 22b");
        rest.setStartHour(8);
        rest.setStartMinute( 0);
        rest.setEndHour(23);
        rest.setEndMinute(59);
        rest.setPhone("0649699815");
        rest.setEmail("caribic@example.com");
        rest.setSite("http://www.caribic.rs/");

        dbHelper.insertRestaurant(rest);

//
//        db.close();
    }

}

