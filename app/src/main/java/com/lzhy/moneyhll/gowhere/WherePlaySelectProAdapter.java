package com.lzhy.moneyhll.gowhere;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import com.lzhy.moneyhll.R;
import com.lzhy.moneyhll.utils.Utils;

import java.util.List;

/**
 * 城市选择弹出框Adapter
 */
public class WherePlaySelectProAdapter extends BaseAdapter {
    private Context mContext;
    private List<String> cities;

    private int lastPosition = -1;
    private int grey;
    private int black;

    public WherePlaySelectProAdapter(Context mContext, List<String> cities){
        this.mContext = mContext;
        this.cities = cities;

        grey = Utils.getColor(mContext, R.color.gray_999);
        black = Utils.getColor(mContext, R.color.red);
    }

    @Override
    public int getCount() {
        return cities.size();
    }

    @Override
    public String getItem(int i) {
        return cities.get(i);
    }

    @Override
    public long getItemId(int i) {
        return i;
    }

    @Override
    public View getView(int i, View view, ViewGroup viewGroup) {
        ViewHolder holder;
        if(null == view){
            view  = LayoutInflater.from(mContext).inflate(R.layout.item_whereplay_pro,null);
            holder = new ViewHolder();
            holder.tv= (TextView) view.findViewById(R.id.tv_pro);
            view.setTag(holder);
        }else{
            holder = (ViewHolder) view.getTag();
        }
        holder.tv.setText(cities.get(i));

        if(lastPosition == i){
            holder.tv.setTextColor(black);
        }else{
            holder.tv.setTextColor(grey);
        }
        return view;
    }

    public String clearSelect(int i){
        lastPosition = i;
        notifyDataSetChanged();
        return cities.get(i);
    }

    class ViewHolder{
        TextView tv;
    }
}
