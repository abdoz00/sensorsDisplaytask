package com.abdo.sensorReadingApi.dto.response;

import lombok.Builder;
import lombok.Data;

import java.time.LocalDateTime;

@Data
@Builder
public class DeviceDetailsResponse {
    String tempVal;
    LocalDateTime readingTime;
}
