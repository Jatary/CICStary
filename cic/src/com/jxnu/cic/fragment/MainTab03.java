package com.jxnu.cic.fragment;


import java.util.ArrayList;
import java.util.List;

import com.jxnu.cic.fragment.StudyFragment;
import com.jxnu.cic.fragment.TeacherFragment;
import com.jxnu.cic.fragment.MyFragmentPagerAdapter;
import com.jxnu.cic.R;

import android.content.res.Resources;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.view.ViewPager;
import android.support.v4.view.ViewPager.OnPageChangeListener;
import android.util.DisplayMetrics;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.Animation;
import android.view.animation.TranslateAnimation;
import android.widget.ImageView;
import android.widget.TextView;



public class MainTab03 extends Fragment{
	Resources resources ;
	private ViewPager viewpager;
    private ArrayList<Fragment> mfrag;
    private int currIndex = 0;
    private TextView study,teacher;
    private int bottomLineWidth;
    private int offset = 0;
    private int position_one;
    public final static int num = 2 ;
    private ImageView ivBottomLine;
    Fragment sf;
    Fragment tf;
    @Override
	public View onCreateView(LayoutInflater inflater, ViewGroup container,
			Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		View view = inflater.inflate(R.layout.main_tab_03, null);
		resources = getResources();
		InitWidth(view);
        InitTextView(view);
        InitViewPager(view);
        TranslateAnimation animation = new TranslateAnimation(position_one, offset, 0, 0);
        study.setTextColor(resources.getColor(R.color.myblue));
        animation.setFillAfter(true);
        animation.setDuration(300);
        ivBottomLine.startAnimation(animation);
		return view;
}
	private void InitWidth(View parentView) {
		// TODO Auto-generated method stub
		ivBottomLine = (ImageView) parentView.findViewById(R.id.iv_bottom_line);
        bottomLineWidth = ivBottomLine.getLayoutParams().width;
        DisplayMetrics dm = new DisplayMetrics();
        getActivity().getWindowManager().getDefaultDisplay().getMetrics(dm);
        int screenW = dm.widthPixels;
        int avg = (int) (screenW / num);
        offset = (int) ((screenW / num - bottomLineWidth) / 2);
        position_one = avg + offset;
		
	}
	
	private void InitViewPager(View parentView) {
		// TODO Auto-generated method stub
		viewpager = (ViewPager) parentView.findViewById(R.id.viewpager);
        mfrag = new ArrayList<Fragment>();

        sf = new StudyFragment();
        tf = new TeacherFragment();

        mfrag.add(sf);
        mfrag.add(tf);
        
        viewpager.setAdapter(new MyFragmentPagerAdapter(getChildFragmentManager(), mfrag));
        viewpager.setOnPageChangeListener(new MyOnPageChangeListener());
        viewpager.setCurrentItem(0);
		
	}
	private void InitTextView(View parentView) {
		// TODO Auto-generated method stub
		study= (TextView) parentView.findViewById(R.id.study);
        teacher = (TextView) parentView.findViewById(R.id.teacher);

        study.setOnClickListener(new MyOnClickListener(0));
        teacher.setOnClickListener(new MyOnClickListener(1));
		
	}
	public class MyOnClickListener implements View.OnClickListener {
        private int index = 0;

        public MyOnClickListener(int i) {
            index = i;
        }

        @Override
        public void onClick(View v) {
            viewpager.setCurrentItem(index);
        }
    };
	 public  class MyOnPageChangeListener implements OnPageChangeListener {
	        Animation animation = null;
	        @Override
	        public void onPageSelected(int arg0) {
	            switch (arg0) {
	            case 0:
	                if (currIndex == 1) {
	                	animation = new TranslateAnimation(position_one, offset, 0, 0);
	                    study.setTextColor(resources.getColor(R.color.myblue));
	                } 
	                teacher.setTextColor(resources.getColor(R.color.myblack));
	                break;
	            case 1:
	                if (currIndex == 0) {
	                	animation = new TranslateAnimation(offset, position_one, 0, 0);
	                    teacher.setTextColor(resources.getColor(R.color.myblue));
	                } 
	                study.setTextColor(resources.getColor(R.color.myblack));
	                break;
	                
	            }
	            currIndex = arg0;
	            animation.setFillAfter(true);
	            animation.setDuration(300);
	            ivBottomLine.startAnimation(animation);
	            
	        }

			@Override
			public void onPageScrollStateChanged(int arg0) {
				// TODO Auto-generated method stub
				
			}

			@Override
			public void onPageScrolled(int arg0, float arg1, int arg2) {
				// TODO Auto-generated method stub
				
			}

	    }
}
    
	
	


	