import { Injectable } from '@angular/core';
import { Headers, Http, RequestOptions, Response } from '@angular/http';

import { Observable } from 'rxjs/Observable';
import { Router } from '@angular/router';
import 'rxjs/add/operator/catch';
import 'rxjs/add/operator/map';

@Injectable()
export class HttpHelper {
  public base = 'http://localhost:8080/svc';
  public loginUrl = this.base + '/login';
  public logoutUrl = this.base + '/logout';
  public psSimpleUrl = this.base + '/pivnyStvrtok/simple';

  constructor(private http: Http, private router: Router) {}

  public getPivnyStvrtokSimple(): Observable<any> {
    return this.http.get(this.psSimpleUrl)
      .map(this.extractData)
      .catch(this.handleError);
  }
  
  public login(event, username, password) {
    const headers = new Headers({ 'Content-Type': 'application/x-www-form-urlencoded'});
    const options = new RequestOptions({ headers: headers });
    const body = `username=${username}&password=${password}`;
    event.preventDefault();
    console.log(body);
    this.http.post(this.loginUrl, body, options)
      .subscribe(
        response => {
          console.log(response);
 //         localStorage.setItem('id_token', response.json().id_token); TODO set JSESSIONID
        this.router.navigate(['main']);
        },
        error => {
          console.log(error.text());
        }
      );
  }
  
  public logout() {
    const headers = new Headers({ 'Content-Type': 'application/x-www-form-urlencoded'});
    const options = new RequestOptions({ headers: headers });
    this.http.post(this.logoutUrl, '', options).subscribe(
      response => {
      this.router.navigate(['']);
      },
      error => {
        console.log(error.text());
      }
    );
  }
  private extractData(res: Response) {
    return res.json() || {};
  }
  private handleError(error: Response | any) {
    let errMsg: string;
    if (error instanceof Response) {
      const body = error.json() || '';
      const err = body.error || JSON.stringify(body);
      errMsg = `${error.status} - ${error.statusText || ''} ${err}`;
    } else {
      errMsg = error.message ? error.message : error.toString();
    }
    console.error(errMsg);
    return Observable.throw(errMsg);
  }
}
