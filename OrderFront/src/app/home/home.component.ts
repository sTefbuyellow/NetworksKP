import {Component, OnInit } from '@angular/core';
import {RoomPayload} from '../modules/room-payload';
import {Router} from '@angular/router';
import {RoomService} from '../services/room-service/room.service';
import {Observable} from 'rxjs';

@Component({
  selector: 'app-home',
  templateUrl: './home.component.html',
  styleUrls: ['./home.component.css']
})
export class HomeComponent implements OnInit {

  roomPayload: RoomPayload;
  constructor(private roomService: RoomService, private router: Router) { }

  rooms: Observable<Array<RoomPayload>>;
  ngOnInit(): void {
  }


}
