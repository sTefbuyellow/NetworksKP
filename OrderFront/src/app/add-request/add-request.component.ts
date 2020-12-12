import { Component, OnInit } from '@angular/core';
import {RequestPayload} from '../modules/request-payload';
import {FormControl, FormGroup} from '@angular/forms';
import {AddRoomService} from '../add-room/add-room.service';
import {Router} from '@angular/router';
import {AddRequestService} from './add-request.service';
import {LocalStorageService} from 'ngx-webstorage';

@Component({
  selector: 'app-add-request',
  templateUrl: './add-request.component.html',
  styleUrls: ['./add-request.component.css']
})
export class AddRequestComponent implements OnInit {

  requestPayload: RequestPayload;
  addRequestForm: FormGroup;
  describing = new FormControl('');

  constructor(private addRequestService: AddRequestService, private localStorageService: LocalStorageService, private router: Router) {
    this.addRequestForm = new FormGroup({
      describing: this.describing
    });
    this.requestPayload = {
      id: '',
      roomId: '',
      userId: '',
      describing: ''
    };
  }

  ngOnInit(): void {
  }

  addRequest(): void {
    this.requestPayload.describing = this.addRequestForm.get('describing').value;
    this.requestPayload.userId = this.localStorageService.retrieve('username');
    this.addRequestService.addRequest(this.requestPayload).subscribe(data => {
      this.router.navigateByUrl('/').then(r => {console.log('added'); });
    }, error => {
      console.log('Failure response');
    });
  }
}
