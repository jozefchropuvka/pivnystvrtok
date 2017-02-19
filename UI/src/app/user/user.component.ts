import { Component, OnInit } from '@angular/core';
import { HttpHelper } from '../helpers/http-helper';

@Component({
  selector: 'app-user',
  templateUrl: './user.component.html',
  styleUrls: ['./user.component.css'],
  providers: [ HttpHelper ]
})
export class UserComponent implements OnInit {
  
  constructor(private http: HttpHelper) { }
  username;
  
  
  
  ngOnInit() {
    
  }
  
  logout() {
  
  }
}
