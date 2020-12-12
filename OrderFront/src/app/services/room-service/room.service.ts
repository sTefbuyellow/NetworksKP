import { Injectable } from '@angular/core';
import {HttpClient} from '@angular/common/http';
import {RoomPayload} from '../../modules/room-payload';
import {Observable} from 'rxjs';

@Injectable({
  providedIn: 'root'
})
export class RoomService {

  constructor(private httpClient: HttpClient) {}

  addRoom(roomPayload: RoomPayload): Observable<any>{
    return this.httpClient.post('http://localhost:8081/room', roomPayload);
  }

  getAllPages(): Observable<Array<RoomPayload>> {
    return this.httpClient.get<Array<RoomPayload>>('http://localhost:8081/room/find-all');
  }
}
