import {AppComponent} from './app.component';
import {AppRoutingModule} from './app-routing.module';
import {BrowserModule} from '@angular/platform-browser';
import {NgModule} from '@angular/core';
import {Ng2Webstorage} from 'ngx-webstorage';
import {HeaderComponent} from './header/header.component';
import { HomeComponent } from './home/home.component';
import {RouterModule} from '@angular/router';
import {HTTP_INTERCEPTORS, HttpClientModule} from '@angular/common/http';
import { RegisterComponent } from './auth/register/register.component';
import { LoginComponent } from './auth/login/login.component';
import {FormsModule, ReactiveFormsModule} from '@angular/forms';
import { AddRoomComponent } from './add-room/add-room.component';
import {EditorModule} from '@tinymce/tinymce-angular';
import {HttpClientInterceptor} from './http-client-interceptor';
import {AuthGuard} from './auth.guard';
import { AddRequestComponent } from './add-request/add-request.component';
import { RequestListComponent } from './request-list/request-list.component';
import { RoomsListComponent } from './rooms-list/rooms-list.component';
import { ProfileComponent } from './profile/profile.component';
import { RequestComponent } from './request/request.component';

@NgModule({
  declarations: [
    AppComponent,
    HeaderComponent,
    HomeComponent,
    RegisterComponent,
    LoginComponent,
    AddRoomComponent,
    AddRequestComponent,
    RequestListComponent,
    RoomsListComponent,
    ProfileComponent,
    RequestComponent
  ],
  imports: [
    BrowserModule,
    AppRoutingModule,
    FormsModule,
    ReactiveFormsModule,
    Ng2Webstorage.forRoot(),
    RouterModule.forRoot([
      {path: '', component: HomeComponent},
      {path: 'register', component: RegisterComponent},
      {path: 'login', component: LoginComponent},
      {path: 'add-room', component: AddRoomComponent, canActivate: [AuthGuard]},
      {path: 'add-request', component: AddRequestComponent, canActivate: [AuthGuard]},
      {path: 'requests', component: RequestListComponent, canActivate: [AuthGuard]},
      {path: 'profile', component: ProfileComponent, canActivate: [AuthGuard]},
      {path: 'request/:id', component: RequestComponent, canActivate: [AuthGuard]}
    ]),
    HttpClientModule,
    EditorModule,
  ],
   providers: [{provide: HTTP_INTERCEPTORS, useClass: HttpClientInterceptor, multi: true}],
   bootstrap: [AppComponent]
})
export class AppModule { }
