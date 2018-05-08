import { Component, Input, OnInit } from '@angular/core';
import { Task } from '../task';
import { TaskService } from '../task.service';
import { Status } from '../../status/status';
import { StatusService } from '../../status/status.service';
import { User } from '../../user/user';
import { UserService } from '../../user/user.service';
import { ActivatedRoute } from '@angular/router';
import { Subscription } from 'rxjs/Subscription';
import { Observable } from 'rxjs/Observable';
import { Router } from '@angular/router';

@Component( {
    selector: 'app-card-task',
    templateUrl: './card-task.component.html',
    styleUrls: ['./card-task.component.css'],
    providers: [TaskService]
} )
export class CardTaskComponent implements OnInit {

    @Input() addFormFlag: boolean = false;
    @Input() viewFormFlag: boolean = false;
    @Input() updateFormFlag: boolean = false;

    private id: number;
    private routeSubscription: Subscription;
    task: Task = new Task(null, "", "", null, null, null);
    users: Array<User>;
    statuses: Array<Status>;

    constructor( private taskService: TaskService,
        private userService: UserService,
        private statusService: StatusService,
        private route: ActivatedRoute,
        private router: Router) {
    }

    ngOnInit() {
        this.userService.getUsers().subscribe((d: User[]) => {
            this.users = d;
        });
        this.statusService.getStatuses().subscribe((s: Status[]) => {
            this.statuses = s;
        });
        this.statusService.getStatuses();
        if(!this.addFormFlag) {
            this.routeSubscription = this.route.params.subscribe( params => {
                if(params['id'] != null) {
                    this.id = params['id'];
                }
            } );
            this.taskService.getTask(this.id).subscribe((data: Task) => {
                this.task = data;
            });
        }
    }
    
    saveTask(task: Task) {
        if(this.addFormFlag) {
            this.taskService.createTask(task).subscribe(data => this.goHome());
        } else {
            this.taskService.updateTask(task).subscribe(data => this.goHome());
        }
    }
    
    delTask(task: Task) {
        this.taskService.deleteTask(task.id).subscribe(data => this.goHome());
    }
    
    goHome(){
        this.router.navigate(['']);
    }
}
