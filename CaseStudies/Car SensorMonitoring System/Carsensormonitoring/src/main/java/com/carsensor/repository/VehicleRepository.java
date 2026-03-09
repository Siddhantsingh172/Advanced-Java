package com.carsensor.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import com.carsensor.entity.Vehicle;

public interface VehicleRepository extends JpaRepository<Vehicle, Long> {
}