package com.abdo.sensorReadingApi.dto.response;

import lombok.Builder;
import lombok.Data;

import java.util.List;

@Data
@Builder
public class DeviceReadingResponse {
    List<DeviceReadingDto> deviceReadingDtoList;
}
