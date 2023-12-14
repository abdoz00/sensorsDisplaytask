package com.abdo.sensorReadingApi.model;

import jakarta.persistence.*;
import lombok.Builder;
import lombok.Data;

import java.time.LocalDateTime;

@Entity
@Table(name = "device_reading")
@Data
public class DeviceReading {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @ManyToOne
    @JoinColumn(name = "device_id")
    private Device device;
    private Long readingValue;
    private LocalDateTime readingTime;

}
