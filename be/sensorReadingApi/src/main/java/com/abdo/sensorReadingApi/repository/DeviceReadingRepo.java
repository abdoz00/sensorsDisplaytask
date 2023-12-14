package com.abdo.sensorReadingApi.repository;

import com.abdo.sensorReadingApi.dto.DeviceReadingQueryResult;
import com.abdo.sensorReadingApi.model.DeviceReading;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface DeviceReadingRepo extends JpaRepository<DeviceReading,Long> {
    @Query(value = "SELECT d.device_id as deviceId,d.reading_value as readingValue from ( \n" +
            "(select device_id,max(reading_time) as reading_time from DEVICE_READING group by device_id) as t" +
            " inner join DEVICE_READING as d on d.device_id=t.device_id and d.reading_time=t.reading_time )",nativeQuery = true)
    List<DeviceReadingQueryResult> getLatestReadings();
    @Query(value = "Select reading_value as readingValue,reading_time as readingTime from DEVICE_READING where device_id=:id",nativeQuery = true)
    List<DeviceReadingQueryResult> getDeviceReadings(Long id);
}
