import { Component } from '@angular/core';
import { HttpHelper } from '../helpers/http-helper';

@Component({
  selector: 'app-login-form',
  templateUrl: './login-form.component.html',
  styleUrls: ['./login-form.component.css'],
  providers: [HttpHelper]
})
export class LoginFormComponent {

  constructor(private http: HttpHelper) { }
   login(event, username, password) {
    this.http.login(event, username, password);
  }
}

