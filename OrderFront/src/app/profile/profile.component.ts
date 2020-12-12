import { Component, OnInit } from '@angular/core';
import {ProfileService} from './profile.service';
import {UserPayload} from '../modules/user-payload';
import {LocalStorageService} from 'ngx-webstorage';
import {RequestPayload} from '../modules/request-payload';
import {Observable} from 'rxjs';

@Component({
  selector: 'app-profile',
  templateUrl: './profile.component.html',
  styleUrls: ['./profile.component.css']
})
export class ProfileComponent implements OnInit {

  user: UserPayload;
  id: string;
  requests: Observable<Array<RequestPayload>>;

  constructor(private profileService: ProfileService, private localStorageService: LocalStorageService) {
    this.user = {
      id: '',
      name: '',
      secondName: '',
      email: '',
      role: '',
    };
    this.requests = null;

    this.id = localStorageService.retrieve('id');
  }

  ngOnInit(): void {

    this.profileService.getOneUser(this.id).subscribe((data: UserPayload) => {
      console.log(data);
      this.user = data;
    }, (err: any) => {
      console.log('Failure response');
    });
    this.requests = this.profileService.getRequests(this.id);
  }

  deleteUser(): void {

  }

  isProcessing(request: RequestPayload): boolean {
    if (request.roomId === null) {
      return true;
    }
  }
}
