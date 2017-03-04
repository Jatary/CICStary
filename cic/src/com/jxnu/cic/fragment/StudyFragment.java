package com.jxnu.cic.fragment;


import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.jxnu.cic.R;

import android.support.v4.app.Fragment;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.AbsListView;
import android.widget.AbsListView.OnScrollListener;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ListView;
import android.widget.RelativeLayout;
import android.widget.SimpleAdapter;
import android.widget.Toast;

public class StudyFragment extends Fragment implements OnItemClickListener,OnScrollListener,OnClickListener {
	private ListView sflistview;
	private SimpleAdapter simpleadapter;
	private List<Map<String,Object>> list;
	private RelativeLayout relativehot;
	@Override
	public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState)
	{
		View view=inflater.inflate(R.layout.fragment_study,container,false);
		sflistview=(ListView) view.findViewById(R.id.sflistview);
		relativehot=(RelativeLayout) view.findViewById(R.id.relativehot);
		list=new ArrayList<Map<String,Object>>();
		simpleadapter=new SimpleAdapter(getActivity(), data(), R.layout.activity_sfitem,
				new String[] {"sfphoto","sftext"},new int[] {R.id.sfphoto,
						R.id.sftext});
		sflistview.setAdapter(simpleadapter);
		sflistview.setOnItemClickListener(this);
		sflistview.setOnScrollListener(this);
		relativehot.setOnClickListener(this);
		return view;
		
	
	}
	public List<Map<String,Object>> data(){
		
			Map<String, Object>map=new HashMap<String, Object>();
			map.put("sfphoto", R.drawable.photo1);
			map.put("sftext","姜老师带你学Android");
			list.add(map);
			Map<String, Object>map1=new HashMap<String, Object>();
			map1.put("sfphoto", R.drawable.photo2);
			map1.put("sftext","无所不能的姜老师");
			list.add(map1);	
			Map<String, Object>map2=new HashMap<String, Object>();
			map2.put("sfphoto", R.drawable.show);
			map2.put("sftext","肖鑫平时傻吊");
			list.add(map2);	
			Map<String, Object>map3=new HashMap<String, Object>();
			map3.put("sfphoto", R.drawable.show1);
			map3.put("sftext","小姜学Android");
			list.add(map3);	
			Map<String, Object>map4=new HashMap<String, Object>();
			map4.put("sfphoto", R.drawable.show_list1);
			map4.put("sftext","难学的Java编程");
			list.add(map4);	
			Map<String, Object>map5=new HashMap<String, Object>();
			map5.put("sfphoto", R.drawable.photo2);
			map5.put("sftext","无所不能的姜老师");
			list.add(map5);	
			Map<String, Object>map6=new HashMap<String, Object>();
			map6.put("sfphoto", R.drawable.show);
			map6.put("sftext","肖鑫平时傻吊");
			list.add(map6);	
			Map<String, Object>map7=new HashMap<String, Object>();
			map7.put("sfphoto", R.drawable.show1);
			map7.put("sftext","小姜学Android");
			list.add(map7);	
		return list;
	
		
	
	}
	@Override
	public void onScrollStateChanged(AbsListView view, int scrollState) {
		// TODO Auto-generated method stub
		
	}
	@Override
	public void onScroll(AbsListView view, int firstVisibleItem, int visibleItemCount, int totalItemCount) {
		// TODO Auto-generated method stub
		
	}
	@Override
	public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
		// TODO Auto-generated method stub
		
		switch(position) {
		case 0:
			Intent it = new Intent(Intent.ACTION_VIEW, Uri.parse("http://www.baidu.com"));  
	        it.setClassName("com.android.browser", "com.android.browser.BrowserActivity");  
	        startActivity(it); 
	        Toast toast=Toast.makeText(getActivity(),"您点击的是第"+position+"个item",
					Toast.LENGTH_SHORT);		
			LinearLayout layout=(LinearLayout) toast.getView();
			ImageView iv=new ImageView(getActivity());
	        iv.setImageResource(R.drawable.photo1);
	        layout.addView(iv);
	        toast.show();
		case 1:
			Toast toast1=Toast.makeText(getActivity(),"您点击的是第"+position+"个item",		
					Toast.LENGTH_SHORT);		
			LinearLayout layout1=(LinearLayout) toast1.getView();
			ImageView iv1=new ImageView(getActivity());
	        iv1.setImageResource(R.drawable.photo2);
	        layout1.addView(iv1);
	        toast1.show();
	       
		}
	}
	@Override
	public void onClick(View v) {
		// TODO Auto-generated method stub
		relativehot.setOnClickListener(new View.OnClickListener() {
			
			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub
				Intent it = new Intent(Intent.ACTION_VIEW, Uri.parse("http://www.etest8.com/jiaoshi/zhinan/"));  
		        it.setClassName("com.android.browser", "com.android.browser.BrowserActivity");  
		        startActivity(it); 
			}
		});
		
	}

}
