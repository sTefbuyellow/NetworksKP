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

  constructor(requestList: RequestListService, private requestsListService: RequestListService) { }

  requests: Observable<Array<RequestPayload>>;

  ngOnInit(): void {
    this.requests = this.requestsListService.getAllRequests();
  }

  isProcessing(request: RequestPayload): boolean {
    if (request.roomId === null) {
      return true;
    }
  }
}
