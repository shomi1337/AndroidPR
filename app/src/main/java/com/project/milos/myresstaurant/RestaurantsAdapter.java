package com.project.milos.myresstaurant;

import android.content.Context;
import android.content.Intent;
import android.support.v7.app.AlertDialog;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;
import android.support.v7.app.AppCompatActivity;

import java.util.ArrayList;

/**
 * Created by Miloš on 1/11/2017.
 */

public class RestaurantsAdapter extends BaseAdapter {
    Context context;
    ArrayList<Restaurant> restaurants;
    private static LayoutInflater inflater = null;

    public RestaurantsAdapter(Context context, ArrayList<Restaurant> restaurants) {
        this.context = context;
        this.restaurants = restaurants;
        inflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
    }

    @Override
    public int getCount() {
        return restaurants.size();
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
            convertView = inflater.inflate(R.layout.restaurant_item, null);
        TextView nameTextView = (TextView) convertView.findViewById(R.id.tv_res_name);
        TextView addressTextView = (TextView) convertView.findViewById(R.id.tv_res_address);
        TextView emailTextView = (TextView) convertView.findViewById(R.id.tv_res_desc);
        Restaurant r = new Restaurant();
        r = restaurants.get(position);
//        codeTextView.setText("Id: " + String.valueOf(r.getId()));

        nameTextView.setText("Name: " + r.getName());
        addressTextView.setText("Address: " + r.getAddress());
        emailTextView.setText("Description: " + r.getDescription());

        nameTextView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view)
            {
                Toast.makeText(view.getContext(), "Selektovan restoran ", Toast.LENGTH_SHORT).show();

                Intent i = new Intent(context,MealsActivity.class);
                context.startActivity(i);

                Log.d("selektovan", "selektovan restoran");

            }
        });
        return convertView;
    }

}
