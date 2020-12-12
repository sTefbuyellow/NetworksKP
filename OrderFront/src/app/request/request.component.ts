import { Component, OnInit } from '@angular/core';
import {RequestService} from './request.service';
import {ActivatedRoute} from '@angular/router';
import {UserPayload} from '../modules/user-payload';
import {RequestPayload} from '../modules/request-payload';
import {RoomPayload} from '../modules/room-payload';
import {Observable} from 'rxjs';

@Component({
  selector: 'app-request',
  templateUrl: './request.component.html',
  styleUrls: ['./request.component.css']
})
export class RequestComponent implements OnInit {

  roomsBool = false;
  id: string;
  request: RequestPayload;
  rooms: Observable<Array<RoomPayload>>;

  constructor(private requestService: RequestService, private activatedRoute: ActivatedRoute) {
    this.request = {
      id: '',
      describing: '',
      roomId: '',
      userId: '',
    };
  }

  ngOnInit(): void {
    this.activatedRoute.params.subscribe(params => {
      this.id = params.id;
    });
    this.requestService.getRequest(this.id).subscribe((data: RequestPayload) => {
      console.log(data);
      this.request = data;
    }, (err: any) => {
      console.log('Failure response');
    });
    this.rooms = this.requestService.getAllRooms();
  }

  onClick(): boolean{
    console.log(this.roomsBool);
    this.roomsBool = !this.roomsBool;
    return this.roomsBool;
  }

  isFree(room: RoomPayload): boolean {
    return room.statusId === 'Processing';
  }
}
