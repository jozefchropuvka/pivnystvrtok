import { Component, Inject } from '@angular/core';
import { Router } from '@angular/router';
import * as service from '../socket.service';

/// <reference path="../../typings/globals/jquery/index.d.ts/>


import '/socket.io/socket.io.js';


@Component({
  selector: 'app-nick-name',
  moduleId: module.id,
  templateUrl: './nick-name.component.html',
  styleUrls: ['./nick-name.component.css']
})
export class NickNameComponent {
    nickname: string = null;
    protected router;

    constructor( @Inject(Router) router: Router) {
        this.router = router;
    }

    submit(data) {
      this.nickname = data.value;
      if (this.nickname) {
        service.socket = io({ query: 'userName=' + this.nickname });
        this.router.navigate(['chat']);
      }
    }

    addNickname($event, nickname) {
      if ($event.which === 13) { // ENTER_KEY
        this.submit(nickname);
      }
    }
}