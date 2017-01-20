package com.project.milos.myresstaurant;

import android.content.Context;
import android.content.Intent;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;

/**
 * Created by Miloš on 1/11/2017.
 */

public class MealsAdapter extends BaseAdapter {
    Context context;
    ArrayList<Meal> meals;
    private static LayoutInflater inflater = null;

    public MealsAdapter(Context context, ArrayList<Meal> meals) {
        this.context = context;
        this.meals = meals;
        inflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
    }

    @Override
    public int getCount() {
        return meals.size();
    }

    @Override
    public Object getItem(int position) {
        return position;
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {

        if (convertView == null)
            convertView = inflater.inflate(R.layout.meal_item, null);

//        TextView codeTextView = (TextView) convertView.findViewById(R.id.tv_mea_id);
        TextView nameTextView = (TextView) convertView.findViewById(R.id.tv_mea_name);
        TextView emailTextView = (TextView) convertView.findViewById(R.id.tv_mea_desc);
        TextView addressTextView = (TextView) convertView.findViewById(R.id.tv_mea_price);

        Meal m = new Meal();
        m = meals.get(position);
//        codeTextView.setText("Id: " + String.valueOf(m.getId()));
        nameTextView.setText("Name: " + m.getName());
        emailTextView.setText("Description: " + m.getDescription());
        addressTextView.setText("Price: " + String.valueOf(m.getPrice()));

        nameTextView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view)
            {
                Toast.makeText(view.getContext(), "Processing order... ", Toast.LENGTH_LONG).show();
                Toast.makeText(view.getContext(), "Order complete! ", Toast.LENGTH_SHORT).show();

                Log.d("selekcija", "selektovan obrok");

            }
        });

        return convertView;
    }
}
