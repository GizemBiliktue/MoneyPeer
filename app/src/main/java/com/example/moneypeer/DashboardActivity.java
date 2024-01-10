package com.example.moneypeer;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

public class DashboardActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_dashboard);

        // Verknüpfung mit den Views im Layout
        TextView header = findViewById(R.id.willkommenHeader);
        TextView credits = findViewById(R.id.creditsText);
        TextView depts = findViewById(R.id.deptsText);
        Button gefallenSenden = findViewById(R.id.gefallenSendenButton);
        Button gefallenBekommen = findViewById(R.id.gefallenBekommenButton);
        Button gefallenWeiterleiten = findViewById(R.id.gefallenWeiterleitenButton);

        if (getIntent().hasExtra("NAME_EXTRA")) {
            String name = getIntent().getStringExtra("NAME_EXTRA");
            String willkommenName = "Herzlich Willkommen "+ name + "!";
            header.setText(willkommenName);
        }
        //TODO Name muss man immer sehen können in bash

        // Hier kannst du weitere Aktionen für die Views festlegen, z. B. Klickereignisse usw.
        // Z.B.:
        gefallenSenden.setOnClickListener(v -> {
            // Aktion für Gefallen senden Button
            Intent intent = new Intent(DashboardActivity.this, SchuldscheinErstellenActivity.class);
            startActivity(intent);

        });

        gefallenBekommen.setOnClickListener(v -> {
            // Aktion für Gefallen anfordern Button
            Intent intent = new Intent(DashboardActivity.this, SchuldscheinBekommenListe.class);
            startActivity(intent);
        });

        gefallenWeiterleiten.setOnClickListener(v -> {
            Intent intent = new Intent(DashboardActivity.this, SchuldscheinWeiterleitenActivity.class);
            startActivity(intent);
        });
    }
}
