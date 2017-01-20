package com.project.milos.myresstaurant;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import org.w3c.dom.Text;

public class MainActivity extends AppCompatActivity {

    TextView totalTextView;
    EditText percentageText;
    EditText numberText;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Button calculateButton = (Button) findViewById(R.id.calculate);

        totalTextView = (TextView)findViewById(R.id.totalTextView);
        percentageText = (EditText)findViewById(R.id.percentage);
        numberText = (EditText)findViewById(R.id.number);

        calculateButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                float percentage = Float.parseFloat(percentageText.getText().toString());
                float dec =percentage/100;
                float result = dec * Float.parseFloat(numberText.getText().toString());
                totalTextView.setText(Float.toString(result));
            }

            });
    }
}
