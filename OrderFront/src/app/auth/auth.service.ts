import { Injectable } from '@angular/core';
import {HttpClient} from '@angular/common/http';
import {RegisterPayload} from '../modules/register-payload';
import {Observable} from 'rxjs';
import {LoginPayload} from '../modules/login-payload';
import {JwtAuthResponse} from '../modules/jwt-auth-response';
import {LocalStorageService} from 'ngx-webstorage';
import {map} from 'rxjs/operators';
import {Router} from '@angular/router';

@Injectable({
  providedIn: 'root'
})
export class AuthService {

  private url = 'http://localhost:8081/auth/';

  constructor(private httpClient: HttpClient, private localStorageService: LocalStorageService, private router: Router) { }

  register(registerPayload: RegisterPayload): Observable<any> {
    return this.httpClient.post(this.url + 'signup', registerPayload);
  }

  login(loginPayload: LoginPayload): Observable<boolean> {
    return this.httpClient.post<JwtAuthResponse>(this.url + 'login', loginPayload).pipe(map (data => {
      this.localStorageService.store('authenticationToken', data.authenticationToken);
      this.localStorageService.store('username', data.username);
      this.localStorageService.store('role', data.role);
      this.localStorageService.store('id', data.id);
      return true;
    }));
  }

  isAuthenticated(): boolean{
    return this.localStorageService.retrieve('username') != null;
  }

  isAdmin(): boolean{
    if (this.localStorageService.retrieve('role') === '[ROLE_ADMIN]') {
      return true;
    }
    return false;
  }

  isUser(): boolean{
    if (this.localStorageService.retrieve('role') === '[ROLE_USER]') {
      return true;
    }
    return false;
  }

  logout(): void {
    this.localStorageService.clear('authenticationToken');
    this.localStorageService.clear('username');
    this.localStorageService.clear('role');
    this.router.navigateByUrl('/login');
  }

}
