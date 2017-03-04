package com.jxnu.cic.adapter;

import android.content.Context;
import android.view.View;


import java.util.List;

/**
 * Created by yetwish on 2015-05-11
 */

public class SearchAdapter extends CommonAdapter<Bean>{

    public SearchAdapter(Context context, List<Bean> data, int layoutId) {
        super(context, data, layoutId);
    }

    @Override
    public void convert(ViewHolder holder, int position) {
        holder.setImageResource(com.jxnu.cic.R.id.item_search_iv_icon,mData.get(position).getIconId())
                .setText(com.jxnu.cic.R.id.item_search_tv_title,mData.get(position).getTitle())
                .setText(com.jxnu.cic.R.id.item_search_tv_content,mData.get(position).getContent())
                .setText(com.jxnu.cic.R.id.item_search_tv_comments,mData.get(position).getComments());
    }
}
