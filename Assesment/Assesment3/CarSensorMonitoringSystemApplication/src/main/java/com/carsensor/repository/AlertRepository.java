package com.carsensor.repository;

import com.carsensor.entity.Alert;
import org.springframework.data.jpa.repository.JpaRepository;
import java.util.List;

public interface AlertRepository extends JpaRepository<Alert, Long> {

    List<Alert> findByVehicleId(Long vehicleId);
}