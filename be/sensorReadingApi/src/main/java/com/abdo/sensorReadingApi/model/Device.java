package com.abdo.sensorReadingApi.model;

import jakarta.persistence.*;
import lombok.Data;

import java.util.List;

@Entity
@Data
public class Device {
    @Id
    private Long id;
    private String description;
    @OneToMany(mappedBy = "device",cascade = CascadeType.ALL)
    private List<DeviceReading> deviceReadingList;
}
