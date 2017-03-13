import { Component, OnInit } from '@angular/core';
import { HttpHelper } from '../helpers/http-helper';

@Component({
  selector: 'app-user',
  templateUrl: './user.component.html',
  styleUrls: ['./user.component.css'],
  providers: [ HttpHelper ]
})
export class UserComponent implements OnInit {
  username;
  
  
  constructor(private http: HttpHelper) { }
  ngOnInit() {
    this.http.getCurrentUsername().subscribe(
      res => { 
        this.username = res.username;     
      }
    );
  }
  
  logout() {
    this.http.logout();
  }
}
