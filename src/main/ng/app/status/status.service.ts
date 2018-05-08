import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { Status } from './status';
import { Observable } from 'rxjs/Observable';

@Injectable()
export class StatusService {
    
    private url: string = "/api/status/";
    constructor(private http: HttpClient) {
    }
    
    getStatuses() {
        return this.http.get(this.url);
    }
}
