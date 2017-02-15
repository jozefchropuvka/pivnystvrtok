import { Component } from '@angular/core';
import {LoginService} from './login.service';

@Component({
  selector: 'app-login',
  templateUrl: './login.component.html',
  styleUrls: ['./login.component.css'],
  providers: [LoginService],
})
export class LoginComponent {

  constructor(private loginService: LoginService) { }

   login(event, username, password) {
    this.loginService.login(event, username, password);
  }
}

