import { BrowserModule } from '@angular/platform-browser';
import { NgModule } from '@angular/core';
import { FormsModule } from '@angular/forms';
import { HttpModule } from '@angular/http';
import { AlertModule } from 'ng2-bootstrap';
import { RouterModule } from '@angular/router';
import { FlexLayoutModule } from '@angular/flex-layout';
import { LocalStorageModule } from 'angular-2-local-storage';


import { AppComponent } from './app.component';
import { LoginFormComponent } from './login/login-form.component';

import { AppRoutingModule } from './app-routing.module';
import { UserComponent } from './user/user.component';
import { LoginButtonComponent } from './login/login-button.component';
import { MainComponent } from './main/main.component';
import { VoteComponent } from './vote/vote.component';

@NgModule({
  declarations: [
    AppComponent,
    LoginFormComponent,
    UserComponent,
    LoginButtonComponent,
    MainComponent,
    VoteComponent
  ],
  imports: [
    BrowserModule,
    FormsModule,
    HttpModule,
    AlertModule.forRoot(),
    AppRoutingModule,
    FlexLayoutModule,
    LocalStorageModule.withConfig({
            prefix: 'app-ps',
            storageType: 'localStorage'
        })
  ],
  providers: [],
  bootstrap: [AppComponent]
})
export class AppModule { }
