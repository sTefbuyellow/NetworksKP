import { Component, OnInit } from '@angular/core';
import {RoomPayload} from '../modules/room-payload';
import {Observable} from 'rxjs';
import {RoomsService} from './rooms.service';

@Component({
  selector: 'app-rooms-list',
  templateUrl: './rooms-list.component.html',
  styleUrls: ['./rooms-list.component.css']
})
export class RoomsListComponent implements OnInit {
  rooms: Observable<Array<RoomPayload>>;
  isThereRooms = true;

  constructor(private roomsService: RoomsService) {
  }

  ngOnInit(): void {
    this.rooms = this.roomsService.getAllRequests();
    if (this.rooms === null){
      this.isThereRooms = false;
    }
  }

  isFree(room: RoomPayload): boolean{
    return room.statusId === 'Processing';
  }
}
