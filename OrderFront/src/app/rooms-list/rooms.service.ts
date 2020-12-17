import { Injectable } from '@angular/core';
import {Observable} from 'rxjs';
import {RequestPayload} from '../modules/request-payload';
import {HttpClient} from '@angular/common/http';
import {RoomPayload} from '../modules/room-payload';

@Injectable({
  providedIn: 'root'
})
export class RoomsService {

  constructor(private httpClient: HttpClient) { }

  getAllRequests(): Observable<Array<RoomPayload>> {
    return this.httpClient.get<Array<RoomPayload>>('http://localhost:8081/room/find-all?pageNo=0&pageSize=10');
  }
}
