package com.example.moneypeer;

import android.content.Context;
import android.graphics.Color;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import java.util.List;

public class AnfrageAdapter extends BaseAdapter {
    private Context context;
    private List<ListItem> dataList;

    public AnfrageAdapter(Context context, List<ListItem> dataList) {
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
            viewHolder.tick = itemView.findViewById(R.id.tick);
            viewHolder.cancel = itemView.findViewById(R.id.cancel);
            viewHolder.edit = itemView.findViewById(R.id.edit);
            itemView.setTag(viewHolder);
        } else {
            viewHolder = (ViewHolder) itemView.getTag();
        }

        ListItem currentItem = dataList.get(position);
        viewHolder.textView.setText(currentItem.getText());

        // Setze die Bilder basierend auf deinen Anforderungen
        viewHolder.tick.setImageResource(R.drawable.tick);
        viewHolder.cancel.setImageResource(R.drawable.cancel);
        viewHolder.edit.setImageResource(R.drawable.edit);

        // Füge den ClickListener für die Bilder hinzu
        viewHolder.tick.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // Hier die Aktion für das erste Bild definieren
                Toast.makeText(context, "Schuldschein bestätigt", Toast.LENGTH_SHORT).show();
                // Hier kannst du weitere Aktionen ausführen, z.B. eine neue Aktivität starten usw.
                dataList.get(position).setGreen(true);
                notifyDataSetChanged();
            }
        });

        viewHolder.cancel.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // Hier die Aktion für das zweite Bild definieren
                Toast.makeText(context, "Schuldschein abgelehnt", Toast.LENGTH_SHORT).show();
                // Hier weitere Aktionen ausführen
                dataList.get(position).setRed(true);
                notifyDataSetChanged();
            }
        });

        viewHolder.edit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // Hier die Aktion für das dritte Bild definieren
                //Toast.makeText(context, "Drittes Bild in Zeile " + position + " geklickt", Toast.LENGTH_SHORT).show();
                // Weitere Aktionen hier hinzufügen
            }
        });

        if(dataList.get(position).isGreen()) {
            int transparentGreen = Color.argb(150, 0, 255, 0); // Ändere den ersten Wert, um die Transparenz zu steuern (0 = transparent, 255 = undurchsichtig)
            itemView.setBackgroundColor(transparentGreen);
        } else if (dataList.get(position).isRed()) {
            itemView.setBackgroundColor(Color.RED);
        } else {
            int transparentRed = Color.argb(150, 255, 0, 0); // Ändere den ersten Wert, um die Transparenz zu steuern (0 = transparent, 255 = undurchsichtig)
            itemView.setBackgroundColor(transparentRed);
        }

        return itemView;
    }

    private static class ViewHolder {
        TextView textView;
        ImageView tick;
        ImageView cancel;
        ImageView edit;
    }

}
