import { BrowserModule } from '@angular/platform-browser';
import { NgModule } from '@angular/core';
import { FormsModule } from '@angular/forms';
import { HttpModule } from '@angular/http';
import { AlertModule } from 'ng2-bootstrap';
import { RouterModule } from '@angular/router';
import { FlexLayoutModule } from '@angular/flex-layout';

import { AppComponent } from './app.component';
import { LoginFormComponent } from './login/login-form.component';
import { LoginFormService } from './login/login-form.service';

import { AppRoutingModule } from './app-routing.module';
import { UserComponent } from './user/user.component';
import { LoginButtonComponent } from './login/login-button.component';
import { MainComponent } from './main/main.component';

@NgModule({
  declarations: [
    AppComponent,
    LoginFormComponent,
    UserComponent,
    LoginButtonComponent,
    MainComponent
  ],
  imports: [
    BrowserModule,
    FormsModule,
    HttpModule,
    AlertModule.forRoot(),
    AppRoutingModule,
    FlexLayoutModule
  ],
  providers: [],
  bootstrap: [AppComponent]
})
export class AppModule { }
