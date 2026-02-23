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
    private String deviceId;

    @Enumerated(EnumType.STRING)
    private DataSource dataSource;

    private LocalDateTime createdAt;

    // 🔹 JPA exige construtor vazio
    protected SensorReading() {}

    public SensorReading(
            Double temperature,
            Double humidity,
            String deviceId,
            DataSource dataSource
    ) {
        this.temperature = temperature;
        this.humidity = humidity;
        this.deviceId = deviceId;
        this.dataSource = dataSource;
        this.createdAt = LocalDateTime.now();
    }

    // 🔹 GETTERS (ESSENCIAL)
    public Long getId() { return id; }
    public Double getTemperature() { return temperature; }
    public Double getHumidity() { return humidity; }
    public String getDeviceId() { return deviceId; }
    public DataSource getDataSource() { return dataSource; }
    public LocalDateTime getCreatedAt() { return createdAt; }
}