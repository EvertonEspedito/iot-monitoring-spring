package com.everton.iot_monitoring.service;

import com.everton.iot_monitoring.domain.dto.SensorReadingRequestDTO;
import com.everton.iot_monitoring.domain.dto.SensorReadingResponseDTO;
import com.everton.iot_monitoring.domain.enums.DataSource;
import com.everton.iot_monitoring.domain.model.SensorReading;
import com.everton.iot_monitoring.repository.SensorReadingRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class SensorReadingService {

    private final SensorReadingRepository repository;

    public SensorReadingService(SensorReadingRepository repository) {
        this.repository = repository;
    }

    // CREATE
    public SensorReadingResponseDTO create(SensorReadingRequestDTO dto) {

        SensorReading reading = new SensorReading(
                dto.getTemperature(),
                dto.getHumidity(),
                dto.getDeviceId(),
                DataSource.DEVICE
        );

        SensorReading saved = repository.save(reading);

        return new SensorReadingResponseDTO(
                saved.getId(),
                saved.getTemperature(),
                saved.getHumidity(),
                saved.getDeviceId(),
                saved.getCreatedAt()
        );
    }

    // LIST
    public List<SensorReadingResponseDTO> list() {
        return repository.findAll()
                .stream()
                .map(this::toDTO)
                .toList();
    }

    private SensorReadingResponseDTO toDTO(SensorReading reading) {
        return new SensorReadingResponseDTO(
                reading.getId(),
                reading.getTemperature(),
                reading.getHumidity(),
                reading.getDeviceId(),
                reading.getCreatedAt()
        );
    }

    public List<SensorReadingResponseDTO> findByDevice(String deviceId) {
        return repository.findByDeviceId(deviceId)
                .stream()
                .map(this::toDTO)
                .toList();
    }

    public List<SensorReadingResponseDTO> getLatest30() {
        return repository
                .findTop30ByOrderByCreatedAtDesc()
                .stream()
                .map(this::toDTO)
                .toList();
    }
}