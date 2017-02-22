import { Component, OnInit } from '@angular/core';
import { Router } from '@angular/router';
import { Location } from '@angular/common';
import { LocalStorageService } from 'angular-2-local-storage';

@Component({
  selector: 'app-main',
  templateUrl: './main.component.html',
  styleUrls: ['./main.component.css']
})
export class MainComponent implements OnInit {
  authenticated = false;
  constructor(private router: Router, private location: Location, private storage: LocalStorageService) { }

  ngOnInit() {
    if (this.storage.get('authenticated') !== 'OK') {
      this.location.replaceState('/');
      this.router.navigate(['login']);
    } else {
      this.authenticated = true;
    }
  }

}
