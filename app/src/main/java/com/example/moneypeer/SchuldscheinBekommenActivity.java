package com.example.moneypeer;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.widget.Button;
import android.widget.TextView;

public class SchuldscheinBekommenActivity extends AppCompatActivity {
    private SharedPreferences sharedPreferences;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_schuldschein_bekommen);
        sharedPreferences = getSharedPreferences("StatusPrefs", MODE_PRIVATE);

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
            SharedPreferences.Editor editor = sharedPreferences.edit();
            editor.putString("item1_status", "denied"); // Beispiel: Aktualisiere den Status für das erste Element
            editor.apply();

            Intent intent = new Intent(SchuldscheinBekommenActivity.this, SchuldscheinBekommenListe.class);
            intent.putExtra("position", 0); // Beispiel: Position des ersten Elements
            intent.putExtra("status", "denied");
            startActivity(intent);
        });

        change.setOnClickListener(v -> {
            // Aktion für Change Button
            Intent intent = new Intent(SchuldscheinBekommenActivity.this, SchuldscheinAnfrageAendernActivity.class);
            startActivity(intent);
        });

        accept.setOnClickListener(v -> {
            // Aktion für Accept Button
            SharedPreferences.Editor editor = sharedPreferences.edit();
            editor.putString("item1_status", "accepted"); // Beispiel: Aktualisiere den Status für das erste Element
            editor.apply();

            Intent intent = new Intent(SchuldscheinBekommenActivity.this, SchuldscheinBekommenListe.class);
            intent.putExtra("position", 0); // Beispiel: Position des ersten Elements
            intent.putExtra("status", "accepted");
            startActivity(intent);
        });
    }
}