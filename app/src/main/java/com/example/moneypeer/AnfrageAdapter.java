package com.example.moneypeer;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.List;

public class AnfrageAdapter extends BaseAdapter {
    private Context context;
    private List<String> dataList;

    public AnfrageAdapter(Context context, List<String> dataList) {
        this.context = context;
        this.dataList = dataList;
    }

    @Override
    public int getCount() {
        return dataList.size();
    }

    @Override
    public Object getItem(int position) {
        return dataList.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        View itemView = convertView;
        ViewHolder viewHolder;

        if (itemView == null) {
            itemView = LayoutInflater.from(context).inflate(R.layout.list_anfragen, parent, false);
            viewHolder = new ViewHolder();
            viewHolder.textView = itemView.findViewById(R.id.textViewElement);
            viewHolder.imageView1 = itemView.findViewById(R.id.imageView1);
            viewHolder.imageView2 = itemView.findViewById(R.id.imageView2);
            viewHolder.imageView3 = itemView.findViewById(R.id.imageView3);
            itemView.setTag(viewHolder);
        } else {
            viewHolder = (ViewHolder) itemView.getTag();
        }

        String currentItem = (String) getItem(position);
        viewHolder.textView.setText(currentItem);

        // Setze die Bilder basierend auf deinen Anforderungen
        viewHolder.imageView1.setImageResource(R.drawable.tick);
        viewHolder.imageView2.setImageResource(R.drawable.cancel);
        viewHolder.imageView3.setImageResource(R.drawable.edit);

        return itemView;
    }

    private static class ViewHolder {
        TextView textView;
        ImageView imageView1;
        ImageView imageView2;
        ImageView imageView3;
    }
}
