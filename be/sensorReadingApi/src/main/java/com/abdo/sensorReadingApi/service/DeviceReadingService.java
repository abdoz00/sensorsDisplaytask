package com.abdo.sensorReadingApi.service;

import com.abdo.sensorReadingApi.dto.request.DeviceReadingRequest;
import com.abdo.sensorReadingApi.dto.response.DeviceReadingResponse;

public interface DeviceReadingService {
    Boolean addDeviceReading(DeviceReadingRequest deviceReadingRequest);
    DeviceReadingResponse getLatestReadingList();

    DeviceReadingResponse getDeviceReadingList(Long id);
}
