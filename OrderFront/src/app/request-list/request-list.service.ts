import { Injectable } from '@angular/core';
import {HttpClient} from '@angular/common/http';
import {RoomPayload} from '../modules/room-payload';
import {Observable} from 'rxjs';
import {RequestPayload} from '../modules/request-payload';

@Injectable({
  providedIn: 'root'
})
export class RequestListService {

  constructor(private httpClient: HttpClient) { }


  getAllRequests(): Observable<Array<RequestPayload>> {
    return this.httpClient.get<Array<RequestPayload>>('http://localhost:8081/request/find-all?pageNo=0&pageSize=10');
  }
}
