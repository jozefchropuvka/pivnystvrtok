import {Router, Routes} from '@angular/router';

import {ChatComponent} from './chat.component';

import * as service from './socket.service';
//myGlobal

export const chatComponentRoutes: Routes = [
    { path: 'chat', component: ChatComponent }
];
