package com.carsensor.service;

import com.carsensor.entity.SensorReading;
import java.util.List;

public interface SensorService {

    SensorReading saveReading(SensorReading reading);

    List<SensorReading> getHistory(Long vehicleId);
}