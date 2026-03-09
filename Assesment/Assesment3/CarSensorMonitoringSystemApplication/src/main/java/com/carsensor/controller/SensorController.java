package com.carsensor.controller;

import com.carsensor.entity.Alert;
import com.carsensor.entity.SensorReading;
import com.carsensor.service.SensorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api")
public class SensorController {

    @Autowired
    private SensorService service;

    @PostMapping("/sensors")
    public SensorReading sendData(@RequestBody SensorReading reading) {
        return service.saveReading(reading);
    }

    @GetMapping("/vehicles/{id}/latest")
    public SensorReading getLatest(@PathVariable Long id) {
        return service.getLatest(id);
    }

    @GetMapping("/vehicles/{id}/history")
    public List<SensorReading> getHistory(@PathVariable Long id) {
        return service.getHistory(id);
    }

    @GetMapping("/vehicles/{id}/alerts")
    public List<Alert> getAlerts(@PathVariable Long id) {
        return service.getAlerts(id);
    }
}