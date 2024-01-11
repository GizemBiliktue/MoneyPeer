package com.example.moneypeer;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

public class NearbyDevicesAdapter extends RecyclerView.Adapter<NearbyDevicesAdapter.ViewHolder> {

    private List<NearbyDevice> nearbyDevices;

    public NearbyDevicesAdapter(List<NearbyDevice> nearbyDevices) {
        this.nearbyDevices = nearbyDevices;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_nearby_device, parent, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        NearbyDevice device = nearbyDevices.get(position);
        holder.deviceNameTextView.setText(device.getDeviceName());
        // Weitere Anpassungen, falls erforderlich
    }

    @Override
    public int getItemCount() {
        return nearbyDevices.size();
    }

    public static class ViewHolder extends RecyclerView.ViewHolder {
        public TextView deviceNameTextView;

        public ViewHolder(View itemView) {
            super(itemView);
            deviceNameTextView = itemView.findViewById(R.id.deviceNameTextView);
            // Weitere Views hinzufügen, falls erforderlich
        }
    }
}

