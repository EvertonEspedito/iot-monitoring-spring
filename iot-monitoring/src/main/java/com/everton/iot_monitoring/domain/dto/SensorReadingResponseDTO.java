package com.everton.iot_monitoring.domain.dto;

import java.time.LocalDateTime;

public class SensorReadingResponseDTO {

    private Long id;
    private Double temperature;
    private Double humidity;
    private String deviceId;
    private LocalDateTime createdAt;

    // getters e setters
}