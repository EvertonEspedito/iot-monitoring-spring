package com.everton.iot_monitoring.domain.dto;

public class DashboardSummaryDTO {

    private long totalReadings;
    private Double avgTemperature;
    private Double minTemperature;
    private Double maxTemperature;
    private Double avgHumidity;

    public DashboardSummaryDTO(
            long totalReadings,
            Double avgTemperature,
            Double minTemperature,
            Double maxTemperature,
            Double avgHumidity
    ) {
        this.totalReadings = totalReadings;
        this.avgTemperature = avgTemperature;
        this.minTemperature = minTemperature;
        this.maxTemperature = maxTemperature;
        this.avgHumidity = avgHumidity;
    }

    public long getTotalReadings() {
        return totalReadings;
    }

    public Double getAvgTemperature() {
        return avgTemperature;
    }

    public Double getMinTemperature() {
        return minTemperature;
    }

    public Double getMaxTemperature() {
        return maxTemperature;
    }

    public Double getAvgHumidity() {
        return avgHumidity;
    }
}