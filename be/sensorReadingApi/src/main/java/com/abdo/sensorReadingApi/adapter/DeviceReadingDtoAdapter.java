package com.abdo.sensorReadingApi.adapter;

import com.abdo.sensorReadingApi.dto.DeviceReadingQueryResult;
import com.abdo.sensorReadingApi.dto.response.DeviceReadingDto;

import java.util.List;

public class DeviceReadingDtoAdapter {
    public static List<DeviceReadingDto> fromDeviceReadingQueryResultList(List<DeviceReadingQueryResult> dtoList){
        return dtoList.stream().map(e-> DeviceReadingDto.builder()
                .deviceId(e.getDeviceId())
                .readingVal(e.getReadingValue())
                .readingTime(e.getReadingTime())
                .build()
        ).toList();
    }
}
