package com.project.milos.myresstaurant;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.ImageView;

import com.project.milos.myresstaurant.R;

/**
 * Created by Miloš on 12/28/2016.
 */

public class Splash extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.splash);

        final ImageView iv = (ImageView) findViewById(R.id.yin);
        final Animation an = AnimationUtils.loadAnimation(getBaseContext(),R.anim.rotate);
        final Animation anSecond = AnimationUtils.loadAnimation(getBaseContext(),R.anim.abc_fade_out);
//
//        FillBase.initDB(this);

        iv.startAnimation(an);
        an.setAnimationListener(new Animation.AnimationListener() {
        @Override
        public void onAnimationStart(Animation animation) {


        }

        @Override
        public void onAnimationEnd(Animation animation) {
            iv.startAnimation(anSecond);
            finish();
            Intent i = new Intent(getBaseContext(), com.project.milos.myresstaurant.RestaurantsActivity.class);
            startActivity(i);
        }

        @Override
        public void onAnimationRepeat(Animation animation) {

        }
        }

        );
    }
}
