package com.everton.iot_monitoring.api;

import com.everton.iot_monitoring.domain.dto.SensorReadingRequestDTO;
import com.everton.iot_monitoring.domain.dto.SensorReadingResponseDTO;
import com.everton.iot_monitoring.domain.model.SensorReading;
import com.everton.iot_monitoring.repository.SensorReadingRepository;
import com.everton.iot_monitoring.service.SensorReadingService;
import jakarta.validation.Valid;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/readings")
public class SensorReadingController {

    private final SensorReadingService service;
    private final SensorReadingRepository repository;

    public SensorReadingController(
            SensorReadingService service,
            SensorReadingRepository repository
    ) {
        this.service = service;
        this.repository = repository;
    }

    @PostMapping
    public SensorReadingResponseDTO create(
            @RequestBody SensorReadingRequestDTO dto
    ) {
        return service.create(dto);
    }

    @GetMapping
    public List<SensorReadingResponseDTO> list() {
        return service.list();
    }

    @GetMapping("/device/{deviceId}")
    public List<SensorReadingResponseDTO> findByDevice(
            @PathVariable String deviceId
    ) {
        return service.findByDevice(deviceId);
    }
    @GetMapping("/latest")
    public List<SensorReadingResponseDTO> latest() {
        return service.getLatest30();
    }
}