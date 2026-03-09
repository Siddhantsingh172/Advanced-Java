package com.carsensor.repository;

import com.carsensor.entity.SensorReading;
import org.springframework.data.jpa.repository.JpaRepository;
import java.util.List;

public interface SensorRepository extends JpaRepository<SensorReading, Long> {

    List<SensorReading> findByVehicleId(Long vehicleId);

    SensorReading findTopByVehicleIdOrderByTimestampDesc(Long vehicleId);
}