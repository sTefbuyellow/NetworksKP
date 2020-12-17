import { Component, OnInit } from '@angular/core';
import {RequestListService} from './request-list.service';
import {Observable} from 'rxjs';
import {RequestPayload} from '../modules/request-payload';

@Component({
  selector: 'app-request-list',
  templateUrl: './request-list.component.html',
  styleUrls: ['./request-list.component.css']
})
export class RequestListComponent implements OnInit {

  isThereElements = false;

  constructor(requestList: RequestListService, private requestsListService: RequestListService) {
    this.isThereElements = false;
  }

  requests: Observable<Array<RequestPayload>>;

  ngOnInit(): void {
    this.requests = this.requestsListService.getAllRequests();
    this.isThereElements = false;
  }

  isProcessing(request: RequestPayload): boolean {
    if (request.roomId === null) {
      this.isThereElements = true;
      return true;
    }
  }
}
