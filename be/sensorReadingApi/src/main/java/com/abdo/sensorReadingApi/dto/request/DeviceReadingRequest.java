package com.abdo.sensorReadingApi.dto.request;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.Pattern;
import jakarta.validation.constraints.Size;
import lombok.Data;

import java.time.LocalDateTime;

@Data
public class DeviceReadingRequest {
    @Pattern(regexp = "^0[xX][0-9a-fA-F]+$",message = "value must be in hex format starting with 0x")
    @Size(min = 12)
    private String readingValue;
    @JsonFormat(pattern="yyyy-MM-dd HH:mm:ss")
    private LocalDateTime readingTime;

}
