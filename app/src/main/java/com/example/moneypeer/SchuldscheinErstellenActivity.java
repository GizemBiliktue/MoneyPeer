package com.example.moneypeer;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.ActivityCompat;
import androidx.core.content.ContextCompat;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.os.Bundle;
import android.util.Log;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;
import android.Manifest;

import java.util.ArrayList;
import java.util.List;


public class SchuldscheinErstellenActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_schuldschein_erstellen);

        // Verknüpfung mit den Views im Layout
        TextView header = findViewById(R.id.header);
        TextView gefallen = findViewById(R.id.gefallenText);
        TextView anzahl = findViewById(R.id.anzahlText);
        TextView creditor = findViewById(R.id.creditorText);
        Button cancel = findViewById(R.id.cancelButton);
        Button senden = findViewById(R.id.sendenButton);

        // Hier kannst du weitere Aktionen für die Views festlegen, z. B. Klickereignisse usw.
        // Z.B.:
        cancel.setOnClickListener(v -> {
            // Aktion für Cancel Button
            Intent intent = new Intent(SchuldscheinErstellenActivity.this, DashboardActivity.class);
            startActivity(intent);
        });

        senden.setOnClickListener(v -> {
            // Aktion für Senden Button
            Intent intent = new Intent(SchuldscheinErstellenActivity.this, DashboardActivity.class);
            startActivity(intent);
        });
    }



}