import { Component } from '@angular/core';
import {LoginFormService} from './login-form.service';

@Component({
  selector: 'app-login-form',
  templateUrl: './login-form.component.html',
  styleUrls: ['./login-form.component.css'],
  providers: [LoginFormService],
})
export class LoginFormComponent {

  constructor(private loginFormService: LoginFormService) { }

   login(event, username, password) {
    this.loginFormService.login(event, username, password);
  }
}

