import { Component, OnInit } from '@angular/core';
import { HttpHelper } from '../helpers/http-helper';

@Component({
  selector: 'app-vote',
  templateUrl: './vote.component.html',
  styleUrls: ['./vote.component.css'],
  providers: [ HttpHelper ]
})
export class VoteComponent implements OnInit {
  voted;
  date;
  dateVoted;
  restaurant;
  constructor(private http: HttpHelper) { }

  ngOnInit() {
    this.http.getVote().subscribe(
      res => { 
        this.voted = true;
        this.date = res.date;
        this.dateVoted = res.dateVoted;
        this.restaurant = res.restaurant.name;     
      }
    );
  }

}
