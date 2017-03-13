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
  allowedDates;
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
    this.http.getAllowedDates().subscribe(res => {
      this.allowedDates = res;  
    });
    this.http.getVote().subscribe(
      res => { 
        this.voted = res.date;
        this.date = this.f.dayMonthYear(res.date);
        this.dateVoted = this.f.dayMonthYearHourMinutes(res.dateVoted);
        this.restaurant = res.restaurant;
        this.model = new Vote(this.date, this.restaurant);     
      }
    );
  }
   
  onSubmit() {
    this.http.submitVote(JSON.stringify(this.model)).subscribe(
      res => {
        this.voted = res.date;
        this.date = this.f.dayMonthYear(res.date);
        this.dateVoted = this.f.dayMonthYearHourMinutes(res.dateVoted);
        this.restaurant = res.restaurant;
        this.model = new Vote(this.date, this.restaurant);
        this.submitted = true;
      });
  }


  // TODO: Remove this when we're done
  get diagnostic() { return JSON.stringify(this.model); }
}
