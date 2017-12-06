package com.westernreduce.wreduce;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.content.Intent;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.TranslateAnimation;
import android.widget.Button;
import android.widget.ImageView;
import android.animation.Animator;
import android.widget.TextView;


public class MainMenu extends AppCompatActivity implements View.OnClickListener
{

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main_menu);
        Button button2 = (Button) findViewById(R.id.button2) ;
        button2.setOnClickListener(this);
       // Button button3 = (Button) findViewById(R.id.button3) ;
       // button3.setOnClickListener(this);

        ImageView horsey = (ImageView) findViewById(R.id.imageView4);

        TranslateAnimation animation = new TranslateAnimation(0.0f,0.0f,0.0f,70.0f);
        animation.setDuration(1000);
        animation.setRepeatCount(Animation.INFINITE);
        animation.setRepeatMode(2);

        horsey.startAnimation(animation);

        final TextView points = (TextView) findViewById(R.id.textView);


        Runnable updateText = new Runnable()
        {
            @Override
            public void run()
            {
                try  {
                    Thread.sleep(1000); // Waits for 1 second (1000 milliseconds)
                }
                catch (InterruptedException iex)
                {

                }
                 points.setText(Integer.toString(ScanMenu.points));
             }
        };

        updateText.run();

    }


    public void goToSecondActivity(View view) {


        Intent pointcollect = new Intent(this, ScanMenu.class);
        Intent redeem = new Intent(this, Redeem.class);

        if (view.getId() == R.id.button2)
            startActivity(pointcollect);
        if (view.getId() == R.id.button3)
            startActivity(redeem);

    }

    public void onClick(View view)
    {
        goToSecondActivity(view);
    }


}
