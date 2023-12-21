package com.example.moneypeer;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;
import android.widget.TextView;

public class SchuldscheinAnfrageAendernActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_schuldscheinanfrage_aendern);

        // Verknüpfung mit den Views im Layout
        TextView header = findViewById(R.id.header);
        TextView gefallen = findViewById(R.id.gefallenText);
        TextView anzahl = findViewById(R.id.anzahlText);
        Button cancel = findViewById(R.id.cancelButton);
        Button submit = findViewById(R.id.submitButton);

        // Hier kannst du weitere Aktionen für die Views festlegen, z. B. Klickereignisse usw.
        // Z.B.:
        cancel.setOnClickListener(v -> {
            Intent intent = new Intent(SchuldscheinAnfrageAendernActivity.this, SchuldscheinBekommenActivity.class);
            startActivity(intent);
        });

        submit.setOnClickListener(v -> {
            // Aktion für Change Button
            Intent intent = new Intent(SchuldscheinAnfrageAendernActivity.this, DashboardActivity.class);
            startActivity(intent);
        });

    }
}