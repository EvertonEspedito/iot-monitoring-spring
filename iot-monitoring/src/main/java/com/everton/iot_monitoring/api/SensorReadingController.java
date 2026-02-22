package com.everton.iot_monitoring.api;

import com.everton.iot_monitoring.domain.dto.SensorReadingRequestDTO;
import com.everton.iot_monitoring.domain.model.SensorReading;
import com.everton.iot_monitoring.service.SensorReadingService;
import jakarta.validation.Valid;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/readings")
public class SensorReadingController {

    private final SensorReadingService service;

    public SensorReadingController(SensorReadingService service) {
        this.service = service;
    }

    @PostMapping
    public SensorReading create(@RequestBody @Valid SensorReadingRequestDTO dto) {
        return service.create(dto);
    }

    @GetMapping
    public List<SensorReading> list() {
        return service.list();
    }
}