package com.project.milos.myresstaurant;

import android.content.Context;
import android.content.Intent;
import android.database.Cursor;
import android.database.DatabaseErrorHandler;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.GridView;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Miloš on 1/11/2017.
 */

public class MealsActivity extends AppCompatActivity {
    private GridView gridMeals;
    public static ArrayList<String> ArrayofName = new ArrayList<String>();
    MealsAdapter mAdapter;
    Toolbar toolbar;
    Button mealsButton;
    Button orderButton;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_meals);

        toolbar = (Toolbar)  findViewById(R.id.app_bar);
        setSupportActionBar(toolbar);

        RestaurantsHelper db = new RestaurantsHelper(this);
        gridMeals = (GridView) findViewById(R.id.gridMeals);

        mealsButton = (Button) findViewById(R.id.mealsButton);
//        orderButton = (Button) findViewById(R.id.tv_order);

        Log.d("Reading: ", "Reading all meals..");
        Cursor cursorMeals = db.getAllData();
        ArrayList<Meal> mealsList = new ArrayList<Meal>();
        while (cursorMeals.moveToNext()) {
            Meal mealIteration = new Meal();
            mealIteration.setId(Integer.parseInt(cursorMeals.getString(0)));
            mealIteration.setName(cursorMeals.getString(1));
            mealIteration.setDescription(cursorMeals.getString(2));
            mealIteration.setPrice(Integer.parseInt(cursorMeals.getString(3)));
            mealsList.add(mealIteration);
        }

        for (Meal meal : mealsList) {
            String log = "Id: " + meal.getId() + " ,Name: " + meal.getName() + " ,Description: " + meal.getDescription();
            // Writing Contacts to log
            Log.d("Name: ", log);
        }

        mAdapter = new MealsAdapter(MealsActivity.this, mealsList);
        gridMeals.setAdapter(mAdapter);

        mealsButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view)
            {
                Intent i = new Intent(getBaseContext(),AddMeal.class);
                startActivity(i);
            }
        });

        /*orderButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view)
            {
//                Intent i = new Intent(getBaseContext(),AddMeal.class);
                Toast.makeText(getApplicationContext(),"Processing order :)",Toast.LENGTH_LONG).show();
                Toast.makeText(getApplicationContext(),"Order completed :)",Toast.LENGTH_SHORT).show();
            }
        });*/
//        @Override
//        public boolean onCreateOptionsMenu(Menu menu) {
//            // Inflate the menu; this adds items to the action bar if it is present.
//            getMenuInflater().inflate(R.menu.main, menu);
//            return true;
//        }
//
//        @Override
//        public boolean onOptionsItemSelected(MenuItem item) {
//            // Handle action bar item clicks here. The action bar will
//            // automatically handle clicks on the Home/Up button, so long
//            // as you specify a parent activity in AndroidManifest.xml.
//            int id = item.getItemId();
//            if (id == R.id.action_settings) {
//                return true;
//            }
//            return super.onOptionsItemSelected(item);
//        }



//        gridMeals.setOnItemClickListener(new AdapterView.OnItemClickListener() {
//            public void onItemClick(AdapterView<?> parent, View v,
//                                    int position, long id) {
//                Toast.makeText(getApplicationContext(),
//                        ((TextView) v).getText(), Toast.LENGTH_SHORT).show();
//            }
//        });
    }
}
