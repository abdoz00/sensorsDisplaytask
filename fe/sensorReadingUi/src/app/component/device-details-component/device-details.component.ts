import { NgFor } from '@angular/common';
import { Component, EventEmitter, Input, Output } from '@angular/core';

@Component({
  selector: 'app-device-details',
  standalone: true,
  imports: [NgFor],
  templateUrl: './device-details.component.html',
  styleUrl: './device-details.component.css'
})
export class DeviceDetailsComponent {
  @Input() data: any;
  @Input() showDeviceDetails: boolean=false;
  @Output() ngModelChange = new EventEmitter<boolean>();
  
}
