import { Injectable } from '@angular/core';
import {HttpClient} from '@angular/common/http';
import {RoomPayload} from '../modules/room-payload';
import {Observable} from 'rxjs';
import {LocalStorageService} from 'ngx-webstorage';

@Injectable({
  providedIn: 'root'
})
export class AddRoomService {

  constructor(private httpClient: HttpClient) { }

  addRoom(roomPayload: RoomPayload): Observable<any>{
    return this.httpClient.post('http://localhost:8081/room', roomPayload);
  }
}
