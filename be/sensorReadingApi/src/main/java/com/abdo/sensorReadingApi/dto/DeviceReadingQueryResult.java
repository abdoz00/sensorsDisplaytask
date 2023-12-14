package com.abdo.sensorReadingApi.dto;

import java.time.LocalDateTime;

public interface DeviceReadingQueryResult {
    Long getDeviceId();
    Long getReadingValue();
    LocalDateTime getReadingTime();
}
