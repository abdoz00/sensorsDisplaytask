package com.abdo.sensorReadingApi.service;

import com.abdo.sensorReadingApi.dto.response.DeviceReadingDto;
import com.abdo.sensorReadingApi.model.Device;

public interface DeviceService {

    Device addDeviceEntity(DeviceReadingDto dto);

    Boolean isDeviceExisted(Long deviceId);

    Device getDeviceReference(Long deviceId);
}
