import { Injectable } from '@angular/core';
import { HttpClient, HttpParams } from '@angular/common/http';
import { Task } from './task';
import { Observable } from 'rxjs/Observable';

@Injectable()
export class TaskService {

    private url: string = "/api/task/";
    constructor( private http: HttpClient ) { }

    getTask(id: number) {
        return this.http.get(this.url + id.toString());
    }
    
    getTasks() {
        return this.http.get(this.url);
    }
    
    updateTask(task: Task) {
        return this.http.post(this.url, task);
    }
    
    deleteTask(id: number) {
        const urlParams = new HttpParams().set("id", id.toString());
        return this.http.delete(this.url, { params: urlParams });
    }
    
    createTask(task: Task) {
        return this.http.put(this.url, task);
    }
}
