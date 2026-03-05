package com.everton.iot_monitoring.service;

import com.everton.iot_monitoring.domain.dto.DashboardSummaryDTO;
import com.everton.iot_monitoring.repository.SensorReadingRepository;
import com.everton.iot_monitoring.domain.dto.SensorReadingResponseDTO;
import com.everton.iot_monitoring.domain.model.SensorReading;
import org.springframework.stereotype.Service;

import java.util.List;


@Service
public class DashboardService {

    private final SensorReadingRepository repository;

    public DashboardService(SensorReadingRepository repository) {
        this.repository = repository;
    }

    public List<SensorReadingResponseDTO> getLatest30() {

        List<SensorReading> readings =
                repository.findTop30ByOrderByCreatedAtDesc();

        return readings.stream()
                .map(r -> new SensorReadingResponseDTO(
                        r.getId(),
                        r.getTemperature(),
                        r.getHumidity(),
                        r.getDeviceId(),
                        r.getCreatedAt()
                ))
                .toList();
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