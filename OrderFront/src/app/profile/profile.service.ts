import {Injectable} from '@angular/core';
import {Observable} from 'rxjs';
import {HttpClient} from '@angular/common/http';
import {RequestPayload} from '../modules/request-payload';

@Injectable({
  providedIn: 'root'
})
export class ProfileService {

  url = 'http://localhost:8081/';

  constructor(private httpClient: HttpClient) {
  }

  getOneUser(id: string): Observable<any> {
    return this.httpClient.get(this.url + 'user/' + id);
  }

  getRequests(id: string): Observable<Array<RequestPayload>> {
    return this.httpClient.get<Array<RequestPayload>>(this.url + 'request/find-all/' + id);
  }
}
