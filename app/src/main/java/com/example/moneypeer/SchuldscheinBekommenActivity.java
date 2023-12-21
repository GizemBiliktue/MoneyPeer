package com.example.moneypeer;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;
import android.widget.TextView;

public class SchuldscheinBekommenActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_schuldschein_bekommen);

        // Verknüpfung mit den Views im Layout
        TextView header = findViewById(R.id.header);
        TextView gefallen = findViewById(R.id.gefallenText);
        TextView anzahl = findViewById(R.id.anzahlText);
        Button deny = findViewById(R.id.denyButton);
        Button change = findViewById(R.id.changeButton);
        Button accept = findViewById(R.id.acceptButton);

        // Hier kannst du weitere Aktionen für die Views festlegen, z. B. Klickereignisse usw.
        // Z.B.:
        deny.setOnClickListener(v -> {
            // Aktion für Deny Button
            Intent intent = new Intent(SchuldscheinBekommenActivity.this, DashboardActivity.class);
            startActivity(intent);
        });

        change.setOnClickListener(v -> {
            // Aktion für Change Button
            Intent intent = new Intent(SchuldscheinBekommenActivity.this, SchuldscheinAnfrageAendernActivity.class);
            startActivity(intent);
        });

        accept.setOnClickListener(v -> {
            // Aktion für Accept Button
            Intent intent = new Intent(SchuldscheinBekommenActivity.this, DashboardActivity.class);
            startActivity(intent);
        });
    }
}