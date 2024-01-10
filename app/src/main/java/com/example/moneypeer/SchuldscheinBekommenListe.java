package com.example.moneypeer;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.ImageButton;
import android.widget.ListView;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class SchuldscheinBekommenListe extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activitiy_schuldschein_bekommen_liste);

        ListView listView = findViewById(R.id.anfragenListview);
        ImageButton back = findViewById(R.id.backButton);

        // Erstelle eine Liste von ListItem-Objekten anstatt von Strings
        List<ListItem> anfragen = new ArrayList<>();
        anfragen.add(new ListItem("Wäsche waschen"));
        anfragen.add(new ListItem("Hausaufgaben machen"));
        anfragen.add(new ListItem("Käsekuchen backen"));

        AnfrageAdapter adapter = new AnfrageAdapter(this, anfragen);
        listView.setAdapter(adapter);

        back.setOnClickListener(v -> {
            // Aktion für Gefallen anfordern Button
            Intent intent = new Intent(SchuldscheinBekommenListe.this, DashboardActivity.class);
            startActivity(intent);
        });
    }
}