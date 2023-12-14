import { Component, NgModule } from '@angular/core';
import { CommonModule } from '@angular/common';
import { RouterOutlet } from '@angular/router';
import { LatestReadingComponent } from './latest-readings-copmonent/latest-readings.copmonent';
import { ReadingAddComponent } from './add-reading-component/reading-add.component';

@Component({
  selector: 'app-root',
  standalone: true,
  imports: [CommonModule, RouterOutlet
    ,ReadingAddComponent
    ],
  templateUrl: './app.component.html',
  styleUrl: './app.component.css'
})
export class AppComponent {
  title = 'sensorReadingUi';
}
