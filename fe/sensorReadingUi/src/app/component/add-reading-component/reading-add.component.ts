import {formatDate} from '@angular/common';
import { Component, OnInit } from '@angular/core';
import { DeviceReadingService } from '../../service/deviceReadingService';
import { FormsModule } from '@angular/forms';
import { delay } from 'rxjs';
import { LatestReadingComponent } from '../latest-readings-copmonent/latest-readings.copmonent';

@Component({
  selector: 'reading-add-component',
  standalone: true,
  imports: [FormsModule,LatestReadingComponent],
  templateUrl: './reading-add.component.html',
  styleUrl: './reading-add.component.css'
})
export class ReadingAddComponent{
  inputData: string='';
  reloadLatestData:boolean=false;

  constructor(private deviceReadingService:DeviceReadingService) {}

  async sumbitReading(): Promise<void> {
    this.deviceReadingService.addDeviceReading(
      { 
        readingValue: this.inputData,
        readingTime: formatDate(new Date(),'yyyy-MM-dd HH:mm:ss','en')
      }
      );
      await new Promise(f => setTimeout(f, 1000));
      this.reloadLatestData=!this.reloadLatestData;
  }

}
