package com.carsensor.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.carsensor.entity.*;
import com.carsensor.repository.*;

import java.time.LocalDateTime;
import java.util.List;

@Service
public class SensorServiceImpl implements SensorService {

    @Autowired
    private SensorReadingRepository sensorRepo;

    @Autowired
    private AlertRepository alertRepo;

    @Override
    public SensorReading saveReading(SensorReading reading) {

        reading.setTimestamp(LocalDateTime.now());

        checkThresholds(reading);

        return sensorRepo.save(reading);
    }

    private void checkThresholds(SensorReading reading) {

        if (reading.getEngineTemperature() > 105) {
            createAlert(reading.getVehicle(), "High Engine Temperature");
        }

        if (reading.getFuelLevel() < 10) {
            createAlert(reading.getVehicle(), "Low Fuel Level");
        }

        if (reading.getTirePressure() < 30) {
            createAlert(reading.getVehicle(), "Low Tire Pressure");
        }
    }

    private void createAlert(Vehicle vehicle, String message) {

        Alert alert = new Alert();
        alert.setVehicle(vehicle);
        alert.setAlertType("CRITICAL");
        alert.setMessage(message);
        alert.setTimestamp(LocalDateTime.now());
        alert.setStatus("ACTIVE");

        alertRepo.save(alert);
    }

    @Override
    public List<SensorReading> getHistory(Long vehicleId) {
        return sensorRepo.findByVehicleId(vehicleId);
    }
}