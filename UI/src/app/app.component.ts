import { Component } from '@angular/core';

@Component({
  selector: 'app-root',
  templateUrl: './app.component.html',
  styleUrls: ['./app.component.css']
})
export class AppComponent {
  title = 'Pivný štvrtok';
  date = new Date(); //TODO service for current pivny stvrtok
  restaurant = 'Zámocký pivovar';
}

