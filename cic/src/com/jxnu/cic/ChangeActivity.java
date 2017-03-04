package com.jxnu.cic;

import android.app.Activity;
import android.app.AlertDialog;
import android.content.DialogInterface;
import android.os.Bundle;
import android.view.View;
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.widget.Toast;

public class ChangeActivity extends Activity{
	private RelativeLayout relativename,relativesex,relativeborntime,
	relativeschool,relativeacademy,relativeenterschool;
	private TextView tvnamechoice;
	private String[] sex= {"男生","女生","人妖"};
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_change);
		initname();
		initsex();
		initDialogAll();
		
		

	}
	private void initDialogAll() {
		// TODO Auto-generated method stub
		final AlertDialog.Builder builder=new AlertDialog.Builder(this);
		builder.setTitle("请选择性别:");
		builder.setSingleChoiceItems(sex, 0, 
				new DialogInterface.OnClickListener() {
			
			@Override
			public void onClick(DialogInterface dialog, int which) {
				// TODO Auto-generated method stub
				String str1=sex[which];				
			}			
		});
		AlertDialog dialog=builder.create();
		dialog.show();
		}
		
		
	
	private void initsex() {
		// TODO Auto-generated method stub
		relativesex=(RelativeLayout) findViewById(R.id.relativesex);
		relativesex.setOnClickListener(new View.OnClickListener() {
			
			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub
				initDialogAll();
			}
		});
		
	}
	private void initname() {
		// TODO Auto-generated method stub
		tvnamechoice = (TextView)findViewById(R.id.tvnamechoice);
		relativename = (RelativeLayout)findViewById(R.id.relativename);
		relativename.setOnClickListener(new View.OnClickListener() {
	            @Override
	            public void onClick(View v) {
	                //创建对话框对象的时候对对话框进行监听
	                NameDialog dialog = new NameDialog(ChangeActivity.this,
	                        new NameDialog.DataBackListener() {
	                            @Override
	                            public void getData(String data) {
	                                String result = data;
	                                tvnamechoice.setText(result);
	                            }
	                        });
	                dialog.setTitle("O(∩_∩)O~~请输入您的昵称:");	                	              	               
	                dialog.show();
	            }
	        });
	}

}
		
	


