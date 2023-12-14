import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';

@Injectable({providedIn: 'root'})
export class DeviceReadingService {
  private getLatestReadingsUrl = 'http://localhost:8080/deviceReading/list';
  private addDeviceReadingUrl='http://localhost:8080/deviceReading/add';
  private getDeviceReadingListUrl='http://localhost:8080/deviceReading/details/'
  

  constructor(private http: HttpClient) {}

  getLatestReadingList() {
    return this.http.get(this.getLatestReadingsUrl);
  }

  addDeviceReading(data:any) {
    this.http.post(this.addDeviceReadingUrl, data).subscribe(response => {
    })  ;
  }

  getDeviceReadingList(deviceId:string) {
    return this.http.get(this.getDeviceReadingListUrl+deviceId);
  }
}