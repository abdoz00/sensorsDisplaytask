package com.abdo.sensorReadingApi.service.impl;

import com.abdo.sensorReadingApi.dto.response.DeviceReadingDto;
import com.abdo.sensorReadingApi.model.Device;
import com.abdo.sensorReadingApi.repository.DeviceRepo;
import com.abdo.sensorReadingApi.service.DeviceService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class DeviceServiceImpl implements DeviceService {
    @Autowired
    DeviceRepo deviceRepo;
    @Override
    public Device addDeviceEntity(DeviceReadingDto dto) {
        Device deviceEntity=new Device();
        deviceEntity.setId(dto.getDeviceId());
        deviceEntity.setDescription("");
        return deviceRepo.save(deviceEntity);
    }
    @Override
    public Boolean isDeviceExisted(Long id){
        return deviceRepo.existsById(id);
    }
    @Override
    public Device getDeviceReference(Long deviceId) {
        return deviceRepo.getReferenceById(deviceId);
    }
}
