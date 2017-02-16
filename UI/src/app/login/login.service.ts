import { Injectable } from '@angular/core';
import { Headers, Http, RequestOptions, Response } from '@angular/http';
import { Observable } from 'rxjs/Observable';
import 'rxjs/add/operator/catch';
import 'rxjs/add/operator/map';

import { UserCurrent } from '../user-current';

@Injectable()
export class LoginService {

  constructor(private http: Http) { }

  login(event, username, password) {
    const headers = new Headers({ 'Content-Type': 'application/x-www-form-urlencoded'});
    const options = new RequestOptions({ headers: headers });
    const body = `username=${username}&password=${password}`;
    event.preventDefault();
    console.log(body);
    this.http.post('http://localhost:8080/svc/login', body, options)
      .subscribe(
        response => {
          console.log(response);
 //         localStorage.setItem('id_token', response.json().id_token); TODO set JSESSIONID
         /** this.router.navigate(['home']);*/
        },
        error => {
          console.log(error.text());
        }
      );
  }

  private handleError(error: any): Promise<any> {
    console.error('An error occurred', error);
    return Promise.reject(error.message || error);
  }

  private extractData(res: Response) {
    const body = res.json();
    return body.data || {};
  }
}
