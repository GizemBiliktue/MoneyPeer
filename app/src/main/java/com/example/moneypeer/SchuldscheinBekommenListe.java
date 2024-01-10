package com.example.moneypeer;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.widget.ImageButton;
import android.widget.ListView;

import java.util.ArrayList;
import java.util.List;

public class SchuldscheinBekommenListe extends AppCompatActivity {
    private SharedPreferences sharedPreferences;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activitiy_schuldschein_bekommen_liste);

        Intent intent = getIntent();
        if (intent != null) {
            int position = intent.getIntExtra("position", -1);
            String status = intent.getStringExtra("status");
            if (position != -1 && status != null) {
                sharedPreferences = getSharedPreferences("StatusPrefs", MODE_PRIVATE);
                String key = "item" + (position + 1) + "_status";
                SharedPreferences.Editor editor = sharedPreferences.edit();
                editor.putString(key, status);
                editor.apply();

                // Lade die Liste neu und aktualisiere die Anzeige
                updateListFromSharedPreferences(); // Hier den vorgeschlagenen Code einfügen
            }
        }

        ListView listView = findViewById(R.id.anfragenListview);
        ImageButton back = findViewById(R.id.backButton);

        List<ListItem> anfragen = new ArrayList<>();

        // Hier rufst du für jedes Element den entsprechenden Status aus SharedPreferences ab
        sharedPreferences = getSharedPreferences("StatusPrefs", MODE_PRIVATE);
        String statusItem1 = sharedPreferences.getString("item1_status", "");
        String statusItem2 = sharedPreferences.getString("item2_status", "");
        String statusItem3 = sharedPreferences.getString("item3_status", "");

        // Dann erstellst du die ListItems mit ihren jeweiligen Status
        anfragen.add(new ListItem("Wäsche waschen", statusItem1));
        anfragen.add(new ListItem("Hausaufgaben machen", statusItem2));
        anfragen.add(new ListItem("Käsekuchen backen", statusItem3));

        AnfrageAdapter adapter = new AnfrageAdapter(this, anfragen);
        listView.setAdapter(adapter);

        back.setOnClickListener(v -> {
            // Aktion für Gefallen anfordern Button
            Intent intent2 = new Intent(SchuldscheinBekommenListe.this, DashboardActivity.class);
            startActivity(intent2);
        });
    }

    // Die Methode, um die Liste basierend auf den Werten in SharedPreferences zu aktualisieren
    private void updateListFromSharedPreferences() {
        ListView listView = findViewById(R.id.anfragenListview);
        String[] itemKeys = {"item1_status", "item2_status", "item3_status"}; // Beispiel: Namen der Schlüssel für die Statuswerte der Elemente
        List<ListItem> anfragen = new ArrayList<>();

        for (String key : itemKeys) {
            String status = sharedPreferences.getString(key, ""); // Status aus den SharedPreferences abrufen
            anfragen.add(new ListItem(key, status));
        }

        AnfrageAdapter adapter = new AnfrageAdapter(this, anfragen);
        listView.setAdapter(adapter);
    }
}