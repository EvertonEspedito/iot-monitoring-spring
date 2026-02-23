package com.everton.iot_monitoring.repository;

import com.everton.iot_monitoring.domain.model.SensorReading;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

public interface SensorReadingRepository extends JpaRepository<SensorReading, Long> {

    @Query("SELECT COUNT(sr) FROM SensorReading sr")
    long countAll();

    @Query("SELECT AVG(sr.temperature) FROM SensorReading sr")
    Double avgTemperature();

    @Query("SELECT MIN(sr.temperature) FROM SensorReading sr")
    Double minTemperature();

    @Query("SELECT MAX(sr.temperature) FROM SensorReading sr")
    Double maxTemperature();

    @Query("SELECT AVG(sr.humidity) FROM SensorReading sr")
    Double avgHumidity();
}