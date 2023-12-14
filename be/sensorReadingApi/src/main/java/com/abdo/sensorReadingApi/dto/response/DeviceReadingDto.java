package com.abdo.sensorReadingApi.dto.response;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class DeviceReadingDto {
    private Long deviceId;
    private Long readingVal;
    private LocalDateTime readingTime;

    public DeviceReadingDto(Long deviceId, Long readingVal) {
        this.deviceId = deviceId;
        this.readingVal = readingVal;
    }
}
