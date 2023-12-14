package com.abdo.sensorReadingApi.service.impl;

import com.abdo.sensorReadingApi.dto.DeviceReadingQueryResult;
import com.abdo.sensorReadingApi.dto.response.DeviceReadingDto;
import com.abdo.sensorReadingApi.dto.request.DeviceReadingRequest;
import com.abdo.sensorReadingApi.dto.response.DeviceReadingResponse;
import com.abdo.sensorReadingApi.model.Device;
import com.abdo.sensorReadingApi.model.DeviceReading;
import com.abdo.sensorReadingApi.repository.DeviceReadingRepo;
import com.abdo.sensorReadingApi.service.DeviceReadingService;
import com.abdo.sensorReadingApi.service.DeviceService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;

import static com.abdo.sensorReadingApi.adapter.DeviceReadingDtoAdapter.fromDeviceReadingQueryResultList;
import static com.abdo.sensorReadingApi.util.HexParser.parseHexLast2CharsAsValueAndTheRestAsId;
import static com.abdo.sensorReadingApi.util.HexParser.parseHexReadingToDtoWithDecimalValues;

@Service
public class TempDeviceReadingService implements DeviceReadingService {

    public static final int TEMP_DEVICE_DIVIDER =10;
    @Autowired
    DeviceReadingRepo deviceReadingRepo;
    @Autowired
    DeviceService deviceService;
    @Override
    public Boolean addDeviceReading(DeviceReadingRequest deviceReadingRequest) {
        List<DeviceReadingDto> deviceReadingDtoList = parseHexReadingToDtoWithDecimalValues(deviceReadingRequest.getReadingValue(), TEMP_DEVICE_DIVIDER,
                parseHexLast2CharsAsValueAndTheRestAsId());
        for (DeviceReadingDto dto :
                deviceReadingDtoList) {
            Device deviceRef;
            boolean isDeviceFound = deviceService.isDeviceExisted(dto.getDeviceId());
            if (!isDeviceFound){
                deviceRef= deviceService.addDeviceEntity(dto);
            }
            else deviceRef=deviceService.getDeviceReference(dto.getDeviceId());
            addDeviceReadingEntity(dto,deviceReadingRequest.getReadingTime(),deviceRef);
        }
        return true;
    }
    @Override
    public DeviceReadingResponse getLatestReadingList(){
        List<DeviceReadingDto> latestReadings = fromDeviceReadingQueryResultList(deviceReadingRepo.getLatestReadings());
        return DeviceReadingResponse.builder()
                .deviceReadingDtoList(latestReadings)
                .build();
    }

    @Override
    public DeviceReadingResponse getDeviceReadingList(Long id){
        List<DeviceReadingDto> latestReadings = fromDeviceReadingQueryResultList(deviceReadingRepo.getDeviceReadings(id));
        return DeviceReadingResponse.builder()
                .deviceReadingDtoList(latestReadings)
                .build();
    }

    private void addDeviceReadingEntity(DeviceReadingDto dto, LocalDateTime readingTime, Device deviceRef) {
        DeviceReading deviceReadingEntity = new DeviceReading();
        deviceReadingEntity.setDevice(deviceRef);
        deviceReadingEntity.setReadingValue(dto.getReadingVal());
        deviceReadingEntity.setReadingTime(readingTime);
        deviceReadingRepo.save(deviceReadingEntity);
    }

}
