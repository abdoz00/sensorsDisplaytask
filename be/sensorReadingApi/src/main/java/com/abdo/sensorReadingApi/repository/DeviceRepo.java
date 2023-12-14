package com.abdo.sensorReadingApi.repository;

import com.abdo.sensorReadingApi.model.Device;
import org.springframework.data.jpa.repository.JpaRepository;

public interface DeviceRepo extends JpaRepository<Device,Long> {
}
