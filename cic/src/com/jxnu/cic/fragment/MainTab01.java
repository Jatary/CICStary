package com.jxnu.cic.fragment;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.jxnu.cic.LoginActivity;
import com.jxnu.cic.MainActivity;
import com.jxnu.cic.R;
import com.jxnu.cic.RegisterActivity;

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
import android.widget.AdapterView.OnItemClickListener;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ListView;
import android.widget.RelativeLayout;
import android.widget.SimpleAdapter;
import android.widget.ImageView.ScaleType;
import android.widget.Toast;


public class MainTab01 extends Fragment
{
	private ListView information_listview;
    private SimpleAdapter simp1_adapter;
    protected Context mContext;
    private MyImgScroll myPager; // 图片容器  
    private LinearLayout ovalLayout ;
    private RelativeLayout info_click; // 圆点容器  
    private List<View> listViews; // 图片组  


	public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState)
	{
		View informationLayout = inflater.inflate(R.layout.main_tab_01, container, false);
		information_listview=(ListView)informationLayout.findViewById(R.id.info_listview);
		 myPager = (MyImgScroll) informationLayout.findViewById(R.id.info_viewpager);  
	        ovalLayout = (LinearLayout) informationLayout.findViewById(R.id.view);  
	        
	        InitViewPager();//初始化图片  
	        //开始滚动  
	        myPager.start(this.getActivity(), listViews, 5000, ovalLayout,  
	                R.layout.item, R.id.ad_item_v,
	                R.drawable.imgshape, R.drawable.imgshape_un);  
		//simp_adapter=new SimpleAdapter(mContext, getData(),R.layout.item, new String[]{"pic","text"}, new int []{R.id.img,R.id.text});
		 simp1_adapter = new SimpleAdapter(  
                 getActivity(),           
               getData(),  
               R.layout.info_list_item,  
               new String[]{"img1","title1"},  
               new int[]{R.id.info_list_img,R.id.info_list_title}  
               );   
		 
		if(information_listview==null)
          {
                  Log.d("debug","hislist null");
                  
          }
	      
		 information_listview.setAdapter(simp1_adapter);
		 information_listview.setOnItemClickListener(new OnItemClickListener(){
			 
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
	    
		return informationLayout;
	}
	  @Override
	public void onStart() {  
	        myPager.startTimer();  
	        super.onStart();  
	    }  
	      
	    @Override
		public void onStop() {  
	        myPager.stopTimer();  
	        super.onStop();  
	    }  
		private void InitViewPager() {
		// TODO Auto-generated method stub
			  listViews = new ArrayList<View>();  
		        int[] imageResId = new int[] { R.drawable.information_list5, R.drawable.information_list2,  
		                R.drawable. information_list3, R.drawable.information_list4, R.drawable.information_list1 };  
		        for (int i = 0; i < imageResId.length; i++) {  
		            ImageView imageView = new ImageView(mContext);  
		            imageView.setOnClickListener(new OnClickListener() {  
		                public void onClick(View v) {// 设置图片点击事件  
		                  
		                }  
		            });  
		            imageView.setImageResource(imageResId[i]);  
		            imageView.setScaleType(ScaleType.CENTER_CROP);  
		            listViews.add(imageView);  
		        }  
	}

		//String[]arr_data={"1","1","1","1"};
	   /*  
	     */
	      //arr_adapter=new ArrayAdapter<String>(getActivity(),android.R.layout.simple_list_item_1,arr_data);
		private void link() {
			// TODO Auto-generated method stub
			String url = "http://news.jxnu.edu.cn/s/271/t/910/cf/1f/info53023.htm"; // web address
			Intent intent = new Intent(Intent.ACTION_VIEW);
			intent.setData(Uri.parse(url));
			startActivity(intent);
			}
	
	private  List<? extends Map<String, ?>> getData() {
		// TODO Auto-generated method stub
		List<Map<String, Object>> list = new ArrayList<Map<String, Object>>();  
	
			Map<String,Object>map=new HashMap<String,Object>();
			map.put("img1", R.drawable.information_list2);
			map.put("title1","青春、冲刺");
			Map<String,Object>map1=new HashMap<String,Object>();
			map1.put("img1", R.drawable.information_list3);
			map1.put("title1", "宣讲党的十八届六中");
			Map<String,Object>map2=new HashMap<String,Object>();
			map2.put("img1", R.drawable.information_list4);
			map2.put("title1","”西子杯”国际创新设计大赛");
			list.add(map);
			list.add(map1);
			list.add(map2);
			
		
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
	@Override
	public void onAttach(Activity activity) {
		super.onAttach(activity);
		mContext = activity.getApplicationContext();

}

	}
