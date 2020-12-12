import { Injectable } from '@angular/core';
import {Observable} from 'rxjs';
import {HttpClient} from '@angular/common/http';
import {RoomPayload} from '../modules/room-payload';

@Injectable({
  providedIn: 'root'
})
export class RequestService {

  url = 'http://localhost:8081/';

  constructor(private httpClient: HttpClient) {
  }

  getRequest(id: string): Observable<any>{
    return this.httpClient.get( this.url + 'request/' + id);
  }

  getAllRooms(): Observable<Array<RoomPayload>>{
    return this.httpClient.get<Array<RoomPayload>>(this.url + 'room/find-all?pageNo=0&pageSize=10');
  }
}
