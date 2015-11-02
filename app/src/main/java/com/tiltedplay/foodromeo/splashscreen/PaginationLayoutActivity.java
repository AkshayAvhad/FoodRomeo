package com.tiltedplay.foodromeo.splashscreen;

import android.content.Context;
import android.os.Bundle;
import android.support.v4.view.PagerAdapter;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ViewFlipper;

import com.tiltedplay.foodromeo.R;


public class PaginationLayoutActivity extends AppCompatActivity {

    private ViewFlipper viewFlipper;
    private float lastX;

    Button prevButton;
    Button nxtButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_pagination);

//        Toolbar tbar = (Toolbar)findViewById(R.id.toolbar);
//        setSupportActionBar(tbar);
//
//        tbar.setNavigationIcon(R.drawable.back_button);

//
//        viewFlipper = (ViewFlipper)findViewById(R.id.viewFlipper);
//        prevButton = (Button)findViewById(R.id.previous_button);
//        nxtButton = (Button)findViewById(R.id.next_button);

//        prevButton.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
////                viewFlipper.setDisplayedChild();
//            }
//        });

        CustomPagerAdapter mCustomPagerAdapter = new CustomPagerAdapter(this);

        ViewPager mViewPager = (ViewPager) findViewById(R.id.pager);
        mViewPager.setAdapter(mCustomPagerAdapter);
    }

//    public boolean onTouchEvent(MotionEvent touchEvent){
//        switch (touchEvent.getAction()){
//            case MotionEvent.ACTION_DOWN:
//                lastX = touchEvent.getX();
//                break;
//            case MotionEvent.ACTION_UP:
//                float currentX = touchEvent.getX();
//
//                if (lastX < currentX){
//                    if (viewFlipper.getDisplayedChild() == 0)
//                        break;
//
//                    viewFlipper.setInAnimation(this, R.anim.slide_in_from_left);
//
//                    viewFlipper.setOutAnimation(this,R.anim.slide_out_to_right);
//
//                    viewFlipper.showNext();
//                }
//
//                if (lastX > currentX){
//                    if (viewFlipper.getDisplayedChild() == 1)
//                        break;
//
//                    viewFlipper.setInAnimation(this,R.anim.slide_in_from_right);
//
//                    viewFlipper.setOutAnimation(this,R.anim.slide_out_to_left);
//
//                    viewFlipper.showPrevious();
//                }
//            break;
//        }
//        return false;
//    }

    class CustomPagerAdapter extends PagerAdapter {

        Context mContext;
        LayoutInflater mLayoutInflater;

        int[] mResources = {
                R.drawable.search,
                R.drawable.choose,
                R.drawable.pay,
                R.drawable.enjoy
        };

        public CustomPagerAdapter(Context context) {
            mContext = context;
            mLayoutInflater = (LayoutInflater) mContext.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        }

        @Override
        public int getCount() {
            return mResources.length;
        }

        @Override
        public boolean isViewFromObject(View view, Object object) {
            return view == ((LinearLayout) object);
        }

        @Override
        public Object instantiateItem(ViewGroup container, int position) {
            View itemView = mLayoutInflater.inflate(R.layout.view_pager, container, false);

            ImageView imageView = (ImageView) itemView.findViewById(R.id.imageView);
            imageView.setImageResource(mResources[position]);

            container.addView(itemView);

            return itemView;
        }

        @Override
        public void destroyItem(ViewGroup container, int position, Object object) {
            container.removeView((LinearLayout) object);
        }
    }
}
