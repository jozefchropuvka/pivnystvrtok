import { Component, OnInit } from '@angular/core';
import { HttpHelper } from '../helpers/http-helper';
import { DateFormatter} from '../helpers/date-formatter';
import { Vote } from './vote';

@Component({
  selector: 'app-vote',
  moduleId: module.id,
  templateUrl: './vote.component.html',
  styleUrls: ['./vote.component.css'],
  providers: [ HttpHelper, DateFormatter ]
})
export class VoteComponent implements OnInit {
  voted;
  date;
  dateVoted;
  restaurant;
  restaurants;
  submitted = false;
  model = new Vote("","");
  
  constructor(private http: HttpHelper, private f: DateFormatter) { }

  ngOnInit() {
     this.http.getRestaurants().subscribe(res => {
      this.restaurants = res._embedded.restaurants;
    });
    this.http.getVote().subscribe(
      res => { 
        this.voted = true;
        this.date = this.f.dayMonthYear(res.date);
        this.dateVoted = this.f.dayMonthYearTime(res.date);
        this.restaurant = res.restaurant.name;
        this.model = new Vote(this.date, this.restaurants);     
      }
    );
  }
   
  onSubmit() { this.submitted = true; }


  // TODO: Remove this when we're done
  get diagnostic() { return JSON.stringify(this.model); }
}
