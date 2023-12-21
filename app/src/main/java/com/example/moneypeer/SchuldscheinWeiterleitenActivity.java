package com.example.moneypeer;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;
import android.widget.TextView;
import androidx.recyclerview.widget.RecyclerView;
import androidx.recyclerview.widget.LinearLayoutManager;

import java.util.ArrayList;
import java.util.List;


public class SchuldscheinWeiterleitenActivity extends AppCompatActivity {

    private RecyclerView deptsList, creditsList;
    private RecyclerView.Adapter creditsAdapter, deptsAdapter;

    private String[] beispielCredits = {
            "Einen neuen Laptop kaufen",
            "Freund beim Umzug helfen",
            "Geburtstagsgeschenk besorgen",
            "Autoscheiben waschen",
            "Blumen für die Nachbarin gießen"
    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_schuldschein_weiterleiten);

        // Verknüpfung mit den Views im Layout
        TextView header = findViewById(R.id.header);
        TextView credits = findViewById(R.id.creditsText);
        TextView depts = findViewById(R.id.deptsText);
        Button weiterleiten = findViewById(R.id.weiterleitenButton);
        Button cancel = findViewById(R.id.cancelButton);
        deptsList = findViewById(R.id.deptsList);
        creditsList = findViewById(R.id.creditsList);

        // Hier kannst du weitere Aktionen für die Views festlegen, z. B. Klickereignisse usw.
        // Z.B.:
        weiterleiten.setOnClickListener(v -> {
            // Aktion für Deny Button
            Intent intent = new Intent(SchuldscheinWeiterleitenActivity.this, DashboardActivity.class);
            startActivity(intent);
        });

        cancel.setOnClickListener(v -> {
            // Aktion für Deny Button
            Intent intent = new Intent(SchuldscheinWeiterleitenActivity.this, DashboardActivity.class);
            startActivity(intent);
        });
    }
}