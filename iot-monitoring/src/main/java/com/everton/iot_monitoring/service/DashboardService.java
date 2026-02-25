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

        long total = repository.count();
        Double avgTemp = repository.avgTemperature();
        Double minTemp = repository.minTemperature();
        Double maxTemp = repository.maxTemperature();
        Double avgHumidity = repository.avgHumidity();

        return new DashboardSummaryDTO(
                total,
                avgTemp,
                minTemp,
                maxTemp,
                avgHumidity
        );
    }
}