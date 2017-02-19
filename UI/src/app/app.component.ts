import { Component, OnInit } from '@angular/core';
import { HttpHelper} from './helpers/http-helper';

@Component({
  selector: 'app-root',
  templateUrl: './app.component.html',
  styleUrls: ['./app.component.css'],
  providers: [ HttpHelper ]
})
export class AppComponent  implements OnInit {
  title = 'Pivný štvrtok';
  date;
  restaurant;
  state;
  errorMessage;
  
  
  constructor(private http: HttpHelper) { }

  ngOnInit() {
    this.http.getPivnyStvrtokSimple().subscribe(
      res => { 
        this.date = new Date(res.date.millis)  || {};
        this.restaurant = res.restaurant.name || {};
        this.state = res.state || {};
      }, error => this.errorMessage = error
    );
  }

}

