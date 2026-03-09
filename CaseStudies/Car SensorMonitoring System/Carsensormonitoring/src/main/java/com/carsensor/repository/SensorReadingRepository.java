package com.carsensor.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import com.carsensor.entity.SensorReading;
import java.util.List;

public interface SensorReadingRepository extends JpaRepository<SensorReading, Long> {

    List<SensorReading> findByVehicleId(Long vehicleId);
}