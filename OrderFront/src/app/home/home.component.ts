import { Component, OnInit } from '@angular/core';
import { RoomPayload} from '../modules/room-payloud';
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
    this.roomPayload = {
      id: '1',
      description: 'bla',
      area: '69',
      statusId: '1'
    };
    this.roomService.addRoom(this.roomPayload).subscribe(data => {
      this.router.navigateByUrl('/');
    }, error => {
      console.log(this.roomPayload);
    });

  //  this.rooms = this.roomService.getAllPages();
  }


}
