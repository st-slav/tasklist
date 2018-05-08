import { BrowserModule } from '@angular/platform-browser';
import { NgModule } from '@angular/core';
import { HttpClientModule } from '@angular/common/http';
import { Routes, RouterModule } from '@angular/router';
import { FormsModule }   from '@angular/forms';

import { AppComponent } from './app.component';
import { NavbarComponent } from './navbar/navbar.component';
import { FooterComponent } from './footer/footer.component';
import { TaskComponent } from './task/task.component';
import { AddTaskComponent } from './task/add-task/add-task.component';
import { ViewTaskComponent } from './task/view-task/view-task.component';
import { EditTaskComponent } from './task/edit-task/edit-task.component';
import { NotFoundComponent } from './not-found/not-found.component';
import { CardTaskComponent } from './task/card-task/card-task.component';
import { UserService } from './user/user.service';
import { StatusService } from './status/status.service';
import { TaskService } from './task/task.service';

const appRoutes: Routes = [
   {path: '', component: TaskComponent},
   {path: 'add', component: AddTaskComponent},
   {path: 'edit/:id', component: EditTaskComponent},
   {path: 'view/:id', component: ViewTaskComponent},
   {path: '**', component: NotFoundComponent}
];

@NgModule( {
    declarations: [
        AppComponent,
        NavbarComponent,
        FooterComponent,
        TaskComponent,
        AddTaskComponent,
        ViewTaskComponent,
        EditTaskComponent,
        NotFoundComponent,
        CardTaskComponent
    ],
    imports: [
        BrowserModule,
        HttpClientModule,
        RouterModule.forRoot(appRoutes),
        FormsModule
    ],
    providers: [UserService, StatusService, TaskService],
    bootstrap: [AppComponent ]
} )
export class AppModule { }
