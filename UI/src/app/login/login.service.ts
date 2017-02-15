import { Injectable } from '@angular/core';
import { Headers, Http, RequestOptions, Response } from '@angular/http';
import { Observable } from 'rxjs/Observable';
import 'rxjs/add/operator/catch';
import 'rxjs/add/operator/map';

import { LoginForm } from '../login-form';
import { UserCurrent } from '../user-current';

@Injectable()
export class LoginService {

  constructor(private http: Http) { }

  login(loginForm: LoginForm): Observable<UserCurrent> {
    const headers = new Headers({ 'Content-Type': 'application/json' });
    const options = new RequestOptions({ headers: headers });
    return this.http.post('/login', { loginForm }, options)
      .map(this.extractData)
      .catch(this.handleError);
  }

  private handleError(error: any): Promise<any> {
    console.error('An error occurred', error); // for demo purposes only
    return Promise.reject(error.message || error);
  }

  private extractData(res: Response) {
    const body = res.json();
    return body.data || {};
  }
}
