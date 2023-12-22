package com.example.moneypeer;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import com.example.moneypeer.DashboardActivity;

public class WillkommenActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_willkommen);

        // Verknüpfung mit den Views im Layout
        TextView header = findViewById(R.id.willkommenHeader);
        TextView identifizierenText = findViewById(R.id.identifizierenText);
        EditText editNameText = findViewById(R.id.editNameText);
        Button weiter = findViewById(R.id.weiterButton);

        DashboardActivity dash = new DashboardActivity();

        // Hier kannst du weitere Aktionen für die Views festlegen, z. B. Klickereignisse usw.
        // Z.B.:
        weiter.setOnClickListener(v -> continueOnClick(editNameText.getText().toString().trim()));
    }

    public void continueOnClick(String name) {
        if (name.isEmpty()) {
            Toast.makeText(getApplicationContext(), "Bitte gib einen Namen ein. ", Toast.LENGTH_SHORT).show();
        } else if (name.matches(".*\\d.*")) {
            Toast.makeText(getApplicationContext(), "Der Name darf keine Zahlen enthalten.", Toast.LENGTH_SHORT).show();
        } else {
            Intent intent = new Intent(WillkommenActivity.this, DashboardActivity.class);
            intent.putExtra("NAME_EXTRA", name);
            startActivity(intent);
        }
    }

    // Kann ich pushen
}
