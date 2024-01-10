package com.example.moneypeer;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.ListView;

import java.util.Arrays;
import java.util.List;

public class SchuldscheinBekommenListe extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activitiy_schuldschein_bekommen_liste);

        ListView listView = findViewById(R.id.anfragenListview);
        List<String> anfragen = Arrays.asList("Wäsche waschen","Hausaufgaben machen" , "Käsekuchen backen");
        AnfrageAdapter adapter = new AnfrageAdapter(this, anfragen);
        listView.setAdapter(adapter);
    }
}