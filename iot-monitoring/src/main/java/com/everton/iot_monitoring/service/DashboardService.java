package com.everton.iot_monitoring.service;

import com.everton.iot_monitoring.domain.dto.DashboardSummaryDTO;
import com.everton.iot_monitoring.repository.SensorReadingRepository;
import org.springframework.stereotype.Service;

@Service
public class DashboardService {

    private final SensorReadingRepository repository;

    public DashboardService(SensorReadingRepository repository) {
        this.repository = repository;
    }

    public DashboardSummaryDTO getSummary() {
        return new DashboardSummaryDTO(
                repository.countAll(),
                repository.avgTemperature(),
                repository.minTemperature(),
                repository.maxTemperature(),
                repository.avgHumidity()
        );
    }
}