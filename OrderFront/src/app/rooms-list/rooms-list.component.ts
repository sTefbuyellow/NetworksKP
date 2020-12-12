import { Component, OnInit } from '@angular/core';
import {RoomPayload} from '../modules/room-payload';
import {Observable} from 'rxjs';

@Component({
  selector: 'app-rooms-list',
  templateUrl: './rooms-list.component.html',
  styleUrls: ['./rooms-list.component.css']
})
export class RoomsListComponent implements OnInit {
  rooms: Observable<Array<RoomPayload>>;

  constructor() { }

  ngOnInit(): void {
  }

  isFree(room: RoomPayload): boolean{
    return room.statusId === 'Processing';
  }
}
