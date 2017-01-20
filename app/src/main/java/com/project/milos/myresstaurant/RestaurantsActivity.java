package com.project.milos.myresstaurant;

import android.content.Intent;
import android.database.Cursor;
import android.os.Bundle;
import android.support.v4.app.FragmentManager;
import android.support.v7.app.ActionBar;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.GridView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Miloš on 1/11/2017.
 */

public class RestaurantsActivity extends AppCompatActivity {
    private GridView gridRestaurants;
    public static ArrayList<String> ArrayofName = new ArrayList<String>();
    RestaurantsAdapter rAdapter;
    Toolbar toolbar;
    Button editMealsButton;
    Button mealsButton;
    Button menuButton;
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_restaurants);

//        FillBase.initDB(this);

        toolbar = (Toolbar) findViewById(R.id.app_bar);
        setSupportActionBar(toolbar);

        RestaurantsHelper db = new RestaurantsHelper(this);
        gridRestaurants = (GridView) findViewById(R.id.gridRestaurants);

        editMealsButton = (Button) findViewById(R.id.editmeals);
        mealsButton = (Button) findViewById(R.id.listofmeals);
//        menuButton = (Button) findViewById(R.id.tv_res_menu);

        Log.d("Reading: ", "Reading all restaurants..");
//        Cursor cursorRestaurants = db.getRestaurants();
        ArrayList<Restaurant> restList = new ArrayList<Restaurant>();
        Restaurant restExample = new Restaurant();
        restExample.setName("Caribic");
        restExample.setDescription(" Počeli smo kao mali porodični posao");
//            entry.put(RestaurantsHelper.COLUMN_ICON_ID, R.drawable.logo_caribic_red);
        restExample.setAddress("Bulevar Oslobodjenja 22b");
        restExample.setStartHour(8);
        restExample.setStartMinute(0);
//        restExample.setSmallPhoto(R.drawable.kfc);
        restExample.setEndHour(23);
        restExample.setEndMinute(59);
        restExample.setPhone("0649699815");
        restExample.setEmail("caribic@example.com");
        restExample.setSite("http://www.caribic.rs/");
        Restaurant restExample2 = new Restaurant();
        restExample2.setName("Big Blue");
        restExample2.setDescription("Caffe Restaurant");
//            entry.put(RestaurantsHelper.COLUMN_ICON_ID, R.drawable.logo_caribic_red);
        restExample2.setAddress("Liman 2");
        restExample2.setStartHour(8);
        restExample2.setStartMinute( 0);
        restExample2.setEndHour(23);
        restExample2.setEndMinute(59);
        restExample2.setPhone("0649699815");
        restExample2.setEmail("bigblue@example.com");
        restExample2.setSite("http://www.bigblue.rs/");
        restList.add(restExample);
        restList.add(restExample2);
//        while (cursorRestaurants.moveToNext()) {
//            Restaurant restaurantIteration = new Restaurant();
//            restaurantIteration.setId(Integer.parseInt(cursorRestaurants.getString(0)));
//            restaurantIteration.setName(cursorRestaurants.getString(1));
//            restaurantIteration.setDescription(cursorRestaurants.getString(2));
//            restaurantIteration.setAddress(cursorRestaurants.getString(3));
//            restList.add(restaurantIteration);
//        }

        for (Restaurant rest : restList) {
            String log = "Id: " + rest.getId() + " ,Name: " + rest.getName() + " ,Description: " + rest.getDescription();
            // Writing Contacts to log
            Log.d("Name: ", log);
        }

        rAdapter = new RestaurantsAdapter(RestaurantsActivity.this, restList);
        gridRestaurants.setAdapter(rAdapter);

        mealsButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i = new Intent(getBaseContext(), MealsActivity.class);
                startActivity(i);
            }
        });

        editMealsButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i = new Intent(getBaseContext(), AddMeal.class);
                startActivity(i);
            }
        });

//        menuButton.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View view)
//            {
//                Toast.makeText(getApplicationContext(),"Processing order :)",Toast.LENGTH_LONG).show();
//                Toast.makeText(getApplicationContext(),"Order completed :)",Toast.LENGTH_SHORT).show();
//                Intent i = new Intent(getBaseContext(),MealsActivity.class);
//                startActivity(i);
//            }
//        });
    }


//    @Override
//    public void onNavigationDrawerItemSelected(int position) {
//        // update the main content by replacing fragments
//        FragmentManager fragmentManager = getSupportFragmentManager();
//
//        // NEW STUFF
//        if (position == 0) {
//            fragmentManager.beginTransaction()
//                    .replace(R.id.la, AboutMeFragment.newInstance())
//                    .commit();
//        } else if (position == 1) {
//            fragmentManager.beginTransaction()
//                    .replace(R.id.container, ContactInfoFragment.newInstance())
//                    .commit();
//        }
//
//
////        else if (position == 2){
////            fragmentManager.beginTransaction()
////                    .replace(R.id.container, MyCompanyFragment.newInstance())
////                    .commit();
////        }
//    }
}
