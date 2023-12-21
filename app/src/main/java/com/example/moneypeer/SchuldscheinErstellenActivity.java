package com.example.moneypeer;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;
import android.widget.TextView;

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