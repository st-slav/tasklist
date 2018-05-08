import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { User } from './user';
import { Observable } from 'rxjs/Observable';

@Injectable()
export class UserService {

    
    private users: User[];

    private url: string = '/api/user/';
    constructor(private http: HttpClient) {
        
    }
    
    getUsers() {
        return this.http.get(this.url);
    }
}
