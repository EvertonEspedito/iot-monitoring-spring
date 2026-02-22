package com.everton.iot_monitoring.repository;

import com.everton.iot_monitoring.domain.model.SensorReading;
import org.springframework.data.jpa.repository.JpaRepository;

public interface SensorReadingRepository
        extends JpaRepository<SensorReading, Long> {
}