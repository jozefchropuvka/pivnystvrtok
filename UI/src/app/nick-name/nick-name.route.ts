import {Router, Routes} from '@angular/router';

import {NickNameComponent} from './nick-name.component';

import * as myGlobal from '../socket.service';

export const nickNameRoutes: Routes = [
    { path: '', component: NickNameComponent }
];