package com.carsensor.service;

import com.carsensor.entity.Alert;
import com.carsensor.entity.SensorReading;
import com.carsensor.repository.AlertRepository;
import com.carsensor.repository.SensorRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;

@Service
public class SensorService {

    @Autowired
    private SensorRepository sensorRepo;

    @Autowired
    private AlertRepository alertRepo;

    public SensorReading saveReading(SensorReading reading) {

        reading.setTimestamp(LocalDateTime.now());
        sensorRepo.save(reading);

        checkForAlerts(reading);

        return reading;
    }

    private void checkForAlerts(SensorReading r) {

        if (r.getEngineTemperature() > 100) {
            createAlert(r.getVehicleId(), "High Engine Temperature", "HIGH");
        }

        if (r.getFuelLevel() < 15) {
            createAlert(r.getVehicleId(), "Low Fuel Level", "MEDIUM");
        }

        if (r.getTirePressure() < 28) {
            createAlert(r.getVehicleId(), "Low Tire Pressure", "MEDIUM");
        }

        if (r.getSpeed() > 120) {
            createAlert(r.getVehicleId(), "Over Speeding", "HIGH");
        }
    }

    private void createAlert(Long vehicleId, String message, String severity) {
        Alert alert = new Alert();
        alert.setVehicleId(vehicleId);
        alert.setMessage(message);
        alert.setSeverity(severity);
        alert.setTimestamp(LocalDateTime.now());

        alertRepo.save(alert);
    }

    public SensorReading getLatest(Long vehicleId) {
        return sensorRepo.findTopByVehicleIdOrderByTimestampDesc(vehicleId);
    }

    public List<SensorReading> getHistory(Long vehicleId) {
        return sensorRepo.findByVehicleId(vehicleId);
    }

    public List<Alert> getAlerts(Long vehicleId) {
        return alertRepo.findByVehicleId(vehicleId);
    }
}