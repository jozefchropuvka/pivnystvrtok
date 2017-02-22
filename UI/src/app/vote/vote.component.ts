import { Component, OnInit } from '@angular/core';
import { HttpHelper } from '../helpers/http-helper';
import { DateFormatter} from '../helpers/date-formatter';

@Component({
  selector: 'app-vote',
  templateUrl: './vote.component.html',
  styleUrls: ['./vote.component.css'],
  providers: [ HttpHelper, DateFormatter ]
})
export class VoteComponent implements OnInit {
  voted;
  date;
  dateVoted;
  restaurant;
  constructor(private http: HttpHelper, private f: DateFormatter) { }

  ngOnInit() {
    this.http.getVote().subscribe(
      res => { 
        this.voted = true;
        this.date = this.f.dayMonthYear(res.date);
        this.dateVoted = this.f.dayMonthYearTime(res.date);
        this.restaurant = res.restaurant.name;     
      }
    );
  }

}
