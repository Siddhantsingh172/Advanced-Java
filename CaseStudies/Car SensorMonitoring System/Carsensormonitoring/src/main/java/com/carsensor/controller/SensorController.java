package com.carsensor.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import com.carsensor.entity.SensorReading;
import com.carsensor.service.SensorService;
import java.util.List;

@RestController
@RequestMapping("/api")
public class SensorController {

    @Autowired
    private SensorService service;

    // Send sensor data
    @PostMapping("/sensors")
    public SensorReading sendData(@RequestBody SensorReading reading) {
        return service.saveReading(reading);
    }

    // Get history
    @GetMapping("/history/{vehicleId}")
    public List<SensorReading> getHistory(@PathVariable Long vehicleId) {
        return service.getHistory(vehicleId);
    }
}