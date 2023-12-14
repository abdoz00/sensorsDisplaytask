import { Component, Input, OnChanges, OnInit } from '@angular/core';
import { NgFor, NgIf } from '@angular/common';
import { DeviceReadingService } from '../../service/deviceReadingService';
import { DeviceDetailsComponent } from '../device-details-component/device-details.component';

@Component({
  selector: 'reading-list-component',
  templateUrl: './latest-readings.copmonent.html',
  styleUrls: ['./latest-readings.copmonent.css'],
  standalone: true,
  imports: [NgFor,NgIf,DeviceDetailsComponent]
})
export class LatestReadingComponent implements OnChanges  {
  @Input() reloadComponent: boolean=false;
  latestReadings:any[]=[];
  deviceDetails: any;
  showDeviceDetailsTable = false;


  constructor(private deviceReadingService:DeviceReadingService) { }

  ngOnChanges() {
    this.deviceReadingService.getLatestReadingList()
    .subscribe((response: any) => {
      this.latestReadings = response.deviceReadingDtoList;
    });
     console.log(this.reloadComponent);
  }   

  openDeviceReadingList(deviceId: string) {
    this.deviceReadingService.getDeviceReadingList(deviceId)
    .subscribe((response: any) => {
      this.deviceDetails = response.deviceReadingDtoList;
      this.showDeviceDetailsTable=true;
    });
    
  }

  closeDeviceDetails(){
    this.showDeviceDetailsTable = false;
  }
}
