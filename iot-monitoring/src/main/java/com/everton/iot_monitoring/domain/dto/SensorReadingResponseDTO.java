package com.everton.iot_monitoring.domain.dto;

import java.time.LocalDateTime;

public class SensorReadingResponseDTO {

    private Long id;
    private Double temperature;
    private Double humidity;
    private String deviceId;
    private LocalDateTime createdAt;

    public SensorReadingResponseDTO(
            Long id,
            Double temperature,
            Double humidity,
            String deviceId,
            LocalDateTime createdAt
    ) {
        this.id = id;
        this.temperature = temperature;
        this.humidity = humidity;
        this.deviceId = deviceId;
        this.createdAt = createdAt;
    }

    public Long getId() { return id; }
    public Double getTemperature() { return temperature; }
    public Double getHumidity() { return humidity; }
    public String getDeviceId() { return deviceId; }
    public LocalDateTime getCreatedAt() { return createdAt; }
}