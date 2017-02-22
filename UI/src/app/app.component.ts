import { Component, OnInit } from '@angular/core';
import { HttpHelper} from './helpers/http-helper';
import { DateFormatter} from './helpers/date-formatter';

@Component({
  selector: 'app-root',
  templateUrl: './app.component.html',
  styleUrls: ['./app.component.css'],
  providers: [ HttpHelper, DateFormatter ]
})
export class AppComponent  implements OnInit {
  title = 'Pivný štvrtok';
  date;
  restaurant;
  state;
  errorMessage;
  
  
  constructor(private http: HttpHelper, private f: DateFormatter) { }

  ngOnInit() {
    this.http.getPivnyStvrtokSimple().subscribe(
      res => { 
        this.date = this.f.dayMonthYearTime(res.date) || {};
        this.restaurant = res.restaurant.name || {};
        this.state = res.state || {};
      }, error => this.errorMessage = error
    );
  }

}

