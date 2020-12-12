import {Component, OnInit} from '@angular/core';
import {FormControl, FormControlName, FormGroup} from '@angular/forms';
import {RoomPayload} from '../modules/room-payload';
import {AddRoomService} from './add-room.service';
import {Observable} from 'rxjs';
import {Router} from '@angular/router';

@Component({
  selector: 'app-add-room',
  templateUrl: './add-room.component.html',
  styleUrls: ['./add-room.component.css']
})
export class AddRoomComponent implements OnInit {

  roomPayload: RoomPayload;
  addRoomForm: FormGroup;
  area = new FormControl('');
  description = new FormControl('');

  constructor(private addRoomService: AddRoomService, private router: Router) {
    this.addRoomForm = new FormGroup({
      area: this.area,
      description: this.description
    });
    this.roomPayload = {
      id: '',
      area: '',
      description: '',
      statusId: ''
    };
  }

  ngOnInit(): void {
  }

  addRoom(): void {
    this.roomPayload.area = this.addRoomForm.get('area').value;
    this.roomPayload.description = this.addRoomForm.get('description').value;
    this.addRoomService.addRoom(this.roomPayload).subscribe(data => {
      this.router.navigateByUrl('/').then(r => {console.log('added'); });
    }, error => {
      console.log('Failure response');
    });
  }
}
