package com.jxnu.cic.fragment;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.jxnu.cic.MainActivity;
import com.jxnu.cic.R;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.support.v4.app.Fragment; 
import android.support.v4.view.PagerAdapter;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ListView;
import android.widget.RelativeLayout;
import android.widget.SimpleAdapter;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.ImageView.ScaleType;
import android.widget.Toast;


public class MainTab04 extends Fragment
{
	private ListView show_listview;
    private SimpleAdapter simp_adapter_show;
    protected Context show_mContext;
    private MyImgScroll show_myPager; // 图片容器  
    private LinearLayout show_ovalLayout; // 圆点容器  
    private List<View> show_listViews; // 图片组  
    private RelativeLayout info_click;


	public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState)
	{
		View showLayout = inflater.inflate(R.layout.main_tab_04, container, false);
		show_listview=(ListView)showLayout.findViewById(R.id.show_listview);
		 show_myPager = (MyImgScroll) showLayout.findViewById(R.id.show_viewpager);  
	        show_ovalLayout = (LinearLayout) showLayout.findViewById(R.id.show_view);  
	        InitViewPager();//初始化图片  
	        //开始滚动  
	        show_myPager.start(this.getActivity(),show_listViews, 5000, show_ovalLayout,  
	                R.layout.item, R.id.ad_item_v,
	                R.drawable.imgshape, R.drawable.imgshape_un);  
		//simp_adapter=new SimpleAdapter(mContext, getData(),R.layout.item, new String[]{"pic","text"}, new int []{R.id.img,R.id.text});
		 simp_adapter_show = new SimpleAdapter(  
                 getActivity(),           
               getData(),  
               R.layout.info_list_item,  
               new String[]{"img1","title1"},  
               new int[]{R.id.info_list_img,R.id.info_list_title}  
               );   
		 
		if(show_listview==null)
          {
                  Log.d("debug","hislist null");
                  
          }
	      
		 show_listview.setAdapter(simp_adapter_show);
		 show_listview.setOnItemClickListener(new OnItemClickListener(){
			 
	            @Override
	            public void onItemClick(AdapterView<?> arg0, View arg1, int arg2,
	                    long arg3) {
	                // TODO Auto-generated method stub
	            	info_click=(RelativeLayout)arg1.findViewById(R.id.info_click);
	            	info_click.setOnClickListener(new View.OnClickListener() {
						
						@Override
						public void onClick(View v) {
							// TODO Auto-generated method stub
							/*Intent intent=new Intent();
							intent.setClass(getActivity(), InfoActivity.class);
							startActivity(intent);*/link();
						}
					});
	            }
	             
	        });
		return showLayout;
	}
	  @Override
	public void onStart() {  
	        show_myPager.startTimer();  
	        super.onStart();  
	    }  
	      
	    @Override
		public void onStop() {  
	        show_myPager.stopTimer();  
	        super.onStop();  
	    }  
		private void InitViewPager() {
		// TODO Auto-generated method stub
			  show_listViews = new ArrayList<View>();  
		        int[] imageResId = new int[] { R.drawable.show_list1, R.drawable.show_list2,  
		                R.drawable.show_list3, R.drawable.information_list4, R.drawable.information_list5 };  
		        for (int i = 0; i < imageResId.length; i++) {  
		            ImageView show_imageView = new ImageView(show_mContext);  
		            show_imageView.setOnClickListener(new OnClickListener() {  
		                public void onClick(View v) {// 设置图片点击事件  
		                  
		                }  
		            });  
		            show_imageView.setImageResource(imageResId[i]);  
		            show_imageView.setScaleType(ScaleType.CENTER_CROP);  
		            show_listViews.add(show_imageView);  
		        }  
	}

		//String[]arr_data={"1","1","1","1"};
	   /*  
	     */
	      //arr_adapter=new ArrayAdapter<String>(getActivity(),android.R.layout.simple_list_item_1,arr_data);
	    
	
	private  List<? extends Map<String, ?>> getData() {
		// TODO Auto-generated method stub
		List<Map<String, Object>> list = new ArrayList<Map<String, Object>>();  
		for(int i=0;i<3;i++)
		{
			Map<String,Object>map=new HashMap<String,Object>();
			map.put("img1", R.drawable.show_list1);
			map.put("title1","校历");
			Map<String,Object>map1=new HashMap<String,Object>();
			map1.put("img1", R.drawable.show_list2);
			map1.put("title1", "“师大感动人物投票”");
			Map<String,Object>map2=new HashMap<String,Object>();
			map2.put("img1", R.drawable.show_list3);
			map2.put("title1","2017年高层次人才招聘");
			list.add(map);
			list.add(map1);
			list.add(map2);
		}
		//Log.d("debug",""+list);
		return list;
		/*for(int i=0;i<20;i++)
		{
			Map<String,Object>map=new HashMap<String,Object>();
			map.put("pic", R.drawable.ic_launcher);
			map.put("text","慕课网"+i);
			list.add(map);
		}
		Log.d("debug",""+list);
		return list;
		 */
	}
	private void link() {
		// TODO Auto-generated method stub
		String url = "http://www.jxnu.edu.cn/s/2/t/690/54/86/info87174.htm"; // web address
		Intent intent = new Intent(Intent.ACTION_VIEW);
		intent.setData(Uri.parse(url));
		startActivity(intent);
		}
	@Override
	public void onAttach(Activity activity) {
		super.onAttach(activity);
		show_mContext = activity.getApplicationContext();

}

	}
