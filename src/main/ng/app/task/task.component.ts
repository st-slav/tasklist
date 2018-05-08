import { Component, OnInit } from '@angular/core';
import { Task } from './task';
import { TaskService } from './task.service';
import { Observable } from 'rxjs/Observable';
import { StatusService } from '../status/status.service';
import { Status } from '../status/status';
import { UserService } from '../user/user.service';
import { User } from '../user/user';

@Component( {
    selector: 'app-task',
    templateUrl: './task.component.html',
    styleUrls: ['./task.component.css']
} )
export class TaskComponent implements OnInit {

    tasks: Array<Task> = new Array<Task>();
    selectedRow: number;
    selectedTask: Task;
    usersMap: Map<number, User> = new Map<number, User>();
    statusesMap: Map<number, Status> = new Map<number, Status>();
    constructor(private taskService: TaskService,
            private userService: UserService,
            private statusService: StatusService) { }

    ngOnInit() {
        console.log("TaskComponent.ngOnInit()");
        this.loadTasks();
        this.loadUsers();
        this.loadStatuses();
    }
    
    private loadTasks() {
        this.taskService.getTasks().subscribe((data: Task[]) =>{
            this.tasks = data;
        });
    }
    
    private loadUsers() {
        this.userService.getUsers().subscribe((data: User[])=>{
            data.forEach(u => this.usersMap.set(u.id, u));
        });
    }
    
    private loadStatuses() {
        this.statusService.getStatuses().subscribe((data: Status[]) => {
            data.forEach(s => this.statusesMap.set(s.id, s));
        });
    }
    
    delTask(task: Task) {
        this.taskService.deleteTask(task.id).subscribe(data => {
            this.loadTasks();
            this.selectedRow = null;
            this.selectedTask = null;
        });
    }
    
    private checkTask(task: Task, i: number) {
        this.selectedRow = i;
        this.selectedTask = task;
    }
}
