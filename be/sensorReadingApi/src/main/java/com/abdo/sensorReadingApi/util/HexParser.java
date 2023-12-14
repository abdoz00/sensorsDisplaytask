package com.abdo.sensorReadingApi.util;

import com.abdo.sensorReadingApi.dto.response.DeviceReadingDto;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Function;

public class HexParser {
    public static  <T> List<T> parseHexReadingToDtoWithDecimalValues(String hexVal,int divider,Function<String,T> parserFunction){
        List<T> deviceReadingDtoList=new ArrayList<>();
        for (int i = 2; i < hexVal.length(); i+=divider) {
            T deviceReadingDto= parserFunction.apply(hexVal.substring(i,i+divider));
            deviceReadingDtoList.add(deviceReadingDto);
        }
        return deviceReadingDtoList;
    }

    public static Function<String,DeviceReadingDto> parseHexLast2CharsAsValueAndTheRestAsId(){
        return hexVal -> {
            Long id = Long.parseLong(hexVal.substring(0,hexVal.length()-2),16);
            Long value = Long.parseLong(hexVal.substring(hexVal.length() - 2),16);
            return DeviceReadingDto.builder()
                    .deviceId(id)
                    .readingVal(value)
                    .build();
        };
    }

}
