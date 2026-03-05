package com.everton.iot_monitoring.api;

import com.everton.iot_monitoring.domain.dto.DashboardSummaryDTO;
import com.everton.iot_monitoring.domain.dto.SensorReadingResponseDTO;
import com.everton.iot_monitoring.service.DashboardService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api/dashboard")
public class DashboardController {

    private final DashboardService service;

    public DashboardController(DashboardService service) {
        this.service = service;
    }

    @GetMapping("/summary")
    public DashboardSummaryDTO summary() {
        return service.getSummary();
    }

    @GetMapping("/latest")
    public List<SensorReadingResponseDTO> latest() {
        return service.getLatest30();
    }
}