package com.example.moneypeer;

public class NearbyDevice {
    private String deviceId;
    private String deviceName;

    public NearbyDevice(String deviceId, String deviceName) {
        this.deviceId = deviceId;
        this.deviceName = deviceName;
    }

    public String getDeviceId() {
        return deviceId;
    }

    public String getDeviceName() {
        return deviceName;
    }
}

