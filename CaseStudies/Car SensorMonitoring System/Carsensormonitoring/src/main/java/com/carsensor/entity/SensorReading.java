package com.carsensor.entity;

import jakarta.persistence.*;
import java.time.LocalDateTime;

@Entity
public class SensorReading {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private double speed;
    private double engineTemperature;
    private double fuelLevel;
    private double tirePressure;

    private LocalDateTime timestamp;

    @ManyToOne
    private Vehicle vehicle;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public double getSpeed() {
		return speed;
	}

	public void setSpeed(double speed) {
		this.speed = speed;
	}

	public double getEngineTemperature() {
		return engineTemperature;
	}

	public void setEngineTemperature(double engineTemperature) {
		this.engineTemperature = engineTemperature;
	}

	public double getFuelLevel() {
		return fuelLevel;
	}

	public void setFuelLevel(double fuelLevel) {
		this.fuelLevel = fuelLevel;
	}

	public double getTirePressure() {
		return tirePressure;
	}

	public void setTirePressure(double tirePressure) {
		this.tirePressure = tirePressure;
	}

	public LocalDateTime getTimestamp() {
		return timestamp;
	}

	public void setTimestamp(LocalDateTime timestamp) {
		this.timestamp = timestamp;
	}

	public Vehicle getVehicle() {
		return vehicle;
	}

	public void setVehicle(Vehicle vehicle) {
		this.vehicle = vehicle;
	}

    // getters and setters
}