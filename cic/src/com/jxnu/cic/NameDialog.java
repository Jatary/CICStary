package com.jxnu.cic;

import android.app.Dialog;
import android.content.Context;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class NameDialog extends Dialog{
	private EditText etdialogname;
    private Button btdialogname;
    DataBackListener listener;   //创建监听对象
	public NameDialog(Context context,final DataBackListener listener) {
		super(context);
		//用传递过来的监听器来初始化
        this.listener = listener;
        setContentView(R.layout.dialog_name);
        etdialogname = (EditText)findViewById(R.id.etdialogname);
        btdialogname = (Button)findViewById(R.id.btdialogname);
        btdialogname.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String str = etdialogname.getText().toString();
                //这里调用接口，将数据传递出去。
                listener.getData(str);
                dismiss();
            }
        });
    }
	public interface DataBackListener{
        public void getData(String data);
    }
		// TODO Auto-generated constructor stub
	}
    

