import { Component } from '@angular/core';
import {LoginService} from './login.service';
import {LoginForm} from '../login-form';

@Component({
  selector: 'app-login',
  templateUrl: './login.component.html',
  styleUrls: ['./login.component.css'],
  providers: [LoginService],
})
export class LoginComponent {

   public loginForm = new LoginForm('', '');
   public errorMsg = '';

  constructor(private loginService: LoginService) { }

  login() {
        if (!this.loginService.login(this.loginForm)) {
            this.errorMsg = 'Failed to login';
        }
    }
}
