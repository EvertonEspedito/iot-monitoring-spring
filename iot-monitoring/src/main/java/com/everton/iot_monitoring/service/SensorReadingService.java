package com.everton.iot_monitoring.service;

import com.everton.iot_monitoring.domain.dto.SensorReadingRequestDTO;
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
    public SensorReading create(SensorReadingRequestDTO dto) {

        SensorReading reading = new SensorReading(
                dto.getTemperature(),
                dto.getHumidity(),
                dto.getDeviceId(),
                DataSource.DEVICE
        );

        return repository.save(reading);
    }

    // LIST
    public List<SensorReading> list() {
        return repository.findAll();
    }


}