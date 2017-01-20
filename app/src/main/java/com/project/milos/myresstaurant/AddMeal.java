package com.project.milos.myresstaurant;

import android.content.Intent;
import android.database.Cursor;
import android.os.Bundle;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

/**
 * Created by Miloš on 1/10/2017.
 */

public class AddMeal extends AppCompatActivity {
//    Button viewAll;
    private Toolbar toolbar;
    EditText nameText;
    EditText descText;
    EditText priceText;
    RestaurantsHelper helper = new RestaurantsHelper(this);



    @Override
    protected  void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add);
        toolbar = (Toolbar)  findViewById(R.id.app_bar);
        setSupportActionBar(toolbar);

        Button addButton = (Button) findViewById(R.id.addmeal);
        Button viewButton = (Button) findViewById(R.id.viewmeals);
        Button settingsButton = (Button) findViewById(R.id.settingsbtn);
        nameText = (EditText)findViewById(R.id.name);
        descText = (EditText)findViewById(R.id.description);
        priceText = (EditText)findViewById(R.id.price);

        addButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view)
            {
                String name = nameText.getText().toString();
                String desc = descText.getText().toString();
                float price = Float.parseFloat(priceText.getText().toString());

                Meal m = new Meal();
                m.setName(name);
                m.setDescription(desc);
                m.setPrice(price);

                helper.insertMeal(m);
                nameText.setText("");
                descText.setText("");
                priceText.setText("");


                Toast.makeText(getApplicationContext(), "Meal successfully added!", Toast.LENGTH_LONG).show();
//                showMessage("Meal added", "Meal successfully added!");
            }
        });


        viewButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view)
            {
                Cursor res = helper.getAllData();
                    if(res.getCount() == 0) {
                        //message
                        showMessage("Error", "Nothing Found!");
                        return;
                    }
                StringBuffer buffer = new StringBuffer();
                while (res.moveToNext()) {
                    buffer.append("Id: " + res.getString(0)+ " ");
                    buffer.append("Name: " + res.getString(1)+" \n");
                }
                showMessage("Data", buffer.toString());
            }
        });

        settingsButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view)
            {
                Intent i = new Intent(getApplicationContext(),Settings.class);
                startActivity(i);
            }
        });
    }

    public void showMessage(String title, String message) {
        AlertDialog.Builder builder = new AlertDialog.Builder(this);
        builder.setCancelable(true);
        builder.setTitle(title);
        builder.setMessage(message);
        builder.show();
    }
}

