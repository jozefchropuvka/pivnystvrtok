import { NgModule } from '@angular/core';
import { RouterModule, Routes } from '@angular/router';

import { LoginFormComponent } from './login/login-form.component';
import { LoginButtonComponent } from './login/login-button.component';
import { UserComponent } from './user/user.component';
import { MainComponent } from './main/main.component';
import { nickNameRoutes } from './nick-name/index';
import { chatComponentRoutes } from './chat/index';

const routes: Routes = [
  {
    path: 'login',
    component: LoginFormComponent
  },
  {
    path: '',
    component: LoginButtonComponent
  },
  {
    path: 'user',
    component: UserComponent
  },
  {
    path: 'main',
    component: MainComponent
  },
  ...nickNameRoutes,
  ...chatComponentRoutes
];
@NgModule({

  imports: [
    RouterModule.forRoot(routes)
  ],
  exports: [RouterModule]
})
export class AppRoutingModule { }
