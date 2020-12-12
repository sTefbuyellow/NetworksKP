import { Injectable } from '@angular/core';
import {HttpClient} from '@angular/common/http';
import {RequestPayload} from '../modules/request-payload';
import {Observable} from 'rxjs';

@Injectable({
  providedIn: 'root'
})
export class AddRequestService {

  constructor(private httpClient: HttpClient) { }

  addRequest(requestPayload: RequestPayload): Observable<any>{
    return this.httpClient.post('http://localhost:8081/request', requestPayload);
  }
}
