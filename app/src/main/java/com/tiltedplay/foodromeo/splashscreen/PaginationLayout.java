package com.tiltedplay.foodromeo.splashscreen;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.MotionEvent;
import android.view.View;
import android.widget.Button;
import android.widget.ViewFlipper;

import com.tiltedplay.foodromeo.R;


public class PaginationLayout extends AppCompatActivity {

    private ViewFlipper viewFlipper;
    private float lastX;

    Button prevButton;
    Button nxtButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.view_pager);

        Toolbar tbar = (Toolbar)findViewById(R.id.toolbar);
        setSupportActionBar(tbar);

        tbar.setNavigationIcon(R.drawable.back_button);

//
//        viewFlipper = (ViewFlipper)findViewById(R.id.viewFlipper);
//        prevButton = (Button)findViewById(R.id.previous_button);
//        nxtButton = (Button)findViewById(R.id.next_button);

        prevButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
//                viewFlipper.setDisplayedChild();
            }
        });

    }

    public boolean onTouchEvent(MotionEvent touchEvent){
        switch (touchEvent.getAction()){
            case MotionEvent.ACTION_DOWN:
                lastX = touchEvent.getX();
                break;
            case MotionEvent.ACTION_UP:
                float currentX = touchEvent.getX();

                if (lastX < currentX){
                    if (viewFlipper.getDisplayedChild() == 0)
                        break;

                    viewFlipper.setInAnimation(this, R.anim.slide_in_from_left);

                    viewFlipper.setOutAnimation(this,R.anim.slide_out_to_right);

                    viewFlipper.showNext();
                }

                if (lastX > currentX){
                    if (viewFlipper.getDisplayedChild() == 1)
                        break;

                    viewFlipper.setInAnimation(this,R.anim.slide_in_from_right);

                    viewFlipper.setOutAnimation(this,R.anim.slide_out_to_left);

                    viewFlipper.showPrevious();
                }
            break;
        }
        return false;
    }
}
