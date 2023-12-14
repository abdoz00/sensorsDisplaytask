package com.abdo.sensorReadingApi.controller;

import com.abdo.sensorReadingApi.dto.response.DeviceDetailsResponse;
import com.abdo.sensorReadingApi.dto.request.DeviceReadingRequest;
import com.abdo.sensorReadingApi.dto.response.DeviceReadingResponse;
import com.abdo.sensorReadingApi.service.DeviceReadingService;
import jakarta.validation.Valid;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDateTime;
import java.util.List;

@RestController
@RequestMapping("deviceReading/")
@Slf4j
@CrossOrigin
public class DeviceReadingController {

    private final DeviceReadingService deviceReadingService;
    @Autowired
    public DeviceReadingController(DeviceReadingService deviceReadingService) {
        this.deviceReadingService = deviceReadingService;
    }

    @GetMapping(value = "list")
    public ResponseEntity<DeviceReadingResponse> getLatestDeviceReadings(){
        DeviceReadingResponse res = deviceReadingService.getLatestReadingList();
        return new ResponseEntity<>(res,HttpStatus.OK);
    }
    @GetMapping(value = "/details/{id}")
    public ResponseEntity<DeviceReadingResponse> getAllReadingsForDevice(@PathVariable Long id){
        DeviceReadingResponse res = deviceReadingService.getDeviceReadingList(id);
        return new ResponseEntity<>(res,HttpStatus.OK);
    }

    @PostMapping(value = "add")
    public ResponseEntity<?> addDeviceReading(@RequestBody @Valid DeviceReadingRequest deviceReadingRequest){
        deviceReadingService.addDeviceReading(deviceReadingRequest);
        return new ResponseEntity<>(HttpStatus.OK);
    }
}
