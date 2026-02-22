package com.everton.iot_monitoring.domain.model;

import com.everton.iot_monitoring.domain.enums.DataSource;
import jakarta.persistence.*;

import java.time.LocalDateTime;

@Entity
@Table(name = "sensor_readings")
public class SensorReading {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private Double temperature;
    private Double humidity;

    @Column(nullable = false)
    private String deviceId;

    @Enumerated(EnumType.STRING)
    @Column(nullable = false)
    private DataSource dataSource;

    @Column(nullable = false)
    private LocalDateTime createdAt;

    public SensorReading() {
    }

    public SensorReading(Double temperature,
                         Double humidity,
                         String deviceId,
                         DataSource dataSource) {
        this.temperature = temperature;
        this.humidity = humidity;
        this.deviceId = deviceId;
        this.dataSource = dataSource;
        this.createdAt = LocalDateTime.now();
    }

    // getters e setters
}