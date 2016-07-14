package com.zl.list.listviewdelete;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import java.util.List;

/**
 * Created by zhanglin on 2016/6/24.
 */
public class ListAdapter extends BaseAdapter {
    Context mContext;
    List<String> listData;
    LayoutInflater layoutInflater;
    public ListAdapter( Context mContext,List<String> listData){
        this.mContext = mContext;
        this.listData = listData;
        this.layoutInflater=LayoutInflater.from(mContext);
    }
    @Override
    public int getCount() {
        return listData.size();
    }

    @Override
    public Object getItem(int position) {
        return listData.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
       ViewHolder viewHolder;
        if(convertView==null){
            viewHolder = new ViewHolder();
            //获得组件，实例化组件
            convertView=layoutInflater.inflate(R.layout.item, null);
            viewHolder.text = (TextView) convertView.findViewById(R.id.tv_text);
            viewHolder.text.setText("测试数据");
            convertView.setTag(viewHolder);
        }else{
            viewHolder=(ViewHolder) convertView.getTag();
        }
        return convertView;
    }
    class ViewHolder{
        TextView text;
    }
}
