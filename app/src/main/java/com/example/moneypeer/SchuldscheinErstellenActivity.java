package com.example.moneypeer;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.ActivityCompat;
import androidx.core.content.ContextCompat;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.os.Bundle;
import android.util.Log;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;
import android.Manifest;

import com.google.android.gms.nearby.Nearby;
import com.google.android.gms.nearby.connection.ConnectionsClient;
import com.google.android.gms.nearby.connection.DiscoveredEndpointInfo;
import com.google.android.gms.nearby.connection.DiscoveryOptions;
import com.google.android.gms.nearby.connection.EndpointDiscoveryCallback;
import com.google.android.gms.nearby.connection.Strategy;

import java.util.ArrayList;
import java.util.List;


public class SchuldscheinErstellenActivity extends AppCompatActivity {

    private ConnectionsClient connectionsClient;
    private final List<NearbyDevice> nearbyDevicesList = new ArrayList<>();
    private NearbyDevicesAdapter nearbyDevicesAdapter;
    private static final int REQUEST_WIFI_STATE_PERMISSION = 1;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_schuldschein_erstellen);

        if (ContextCompat.checkSelfPermission(this, Manifest.permission.ACCESS_WIFI_STATE)
                != PackageManager.PERMISSION_GRANTED) {
            // Berechtigung anfordern
            ActivityCompat.requestPermissions(this,
                    new String[]{Manifest.permission.ACCESS_WIFI_STATE},
                    REQUEST_WIFI_STATE_PERMISSION);
        } else {
            // Die Berechtigung wurde bereits erteilt, starte die Nearby Connections-Logik
            initializeNearbyConnections();
        }

        // Geräte in der Nähe suchen
        connectionsClient = Nearby.getConnectionsClient(this);

        RecyclerView recyclerView = findViewById(R.id.creditorsList);
        nearbyDevicesAdapter = new NearbyDevicesAdapter(nearbyDevicesList);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        recyclerView.setAdapter(nearbyDevicesAdapter);

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

    private void startDiscovery() {
        connectionsClient.startDiscovery(
                "Your_Service_Id",
                new EndpointDiscoveryCallback() {
                    @SuppressLint("NotifyDataSetChanged")
                    @Override
                    public void onEndpointFound(@NonNull String endpointId, @NonNull DiscoveredEndpointInfo discoveredEndpointInfo) {
                        // Hier kannst du die gefundenen Geräte zur Liste hinzufügen und weitere Aktionen durchführen
                        String deviceName = discoveredEndpointInfo.getEndpointName();
                        NearbyDevice nearbyDevice = new NearbyDevice(endpointId, deviceName);
                        nearbyDevicesList.add(nearbyDevice);
                        Log.d("NearbyDevices", "Endpoint found: " + deviceName);


                        // Aktualisiere den Adapter
                        runOnUiThread(() -> nearbyDevicesAdapter.notifyDataSetChanged());

                    }

                    @Override
                    public void onEndpointLost(@NonNull String s) {
                        // Hier kannst du das verlorene Gerät aus der Liste entfernen und weitere Aktionen durchführen

                    }
                },
                new DiscoveryOptions.Builder().setStrategy(Strategy.P2P_STAR).build()
        );
    }

    private void initializeNearbyConnections() {
        // Hier kannst du die Initialisierung von Nearby Connections durchführen
        // z.B., die Entdeckung von Geräten starten
        startDiscovery();
    }

    @Override
    public void onRequestPermissionsResult(int requestCode, @NonNull String[] permissions, @NonNull int[] grantResults) {
        super.onRequestPermissionsResult(requestCode, permissions, grantResults);

        // Überprüfen, ob die Anfrage für die WiFi State-Berechtigung ist
        if (requestCode == REQUEST_WIFI_STATE_PERMISSION) {
            // Überprüfen, ob die Berechtigung gewährt wurde
            if (grantResults.length > 0 && grantResults[0] == PackageManager.PERMISSION_GRANTED) {
                // Berechtigung wurde erteilt, starte die Nearby Connections-Logik
                initializeNearbyConnections();
            } else {
                // Berechtigung wurde verweigert, implementiere geeignete Maßnahmen
                // z.B., informiere den Benutzer über die Notwendigkeit der Berechtigung
                Toast.makeText(this, "Die Berechtigung wurde verweigert. Nearby Connections kann nicht verwendet werden.", Toast.LENGTH_SHORT).show();
            }
        }
    }


}