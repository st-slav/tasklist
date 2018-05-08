import { User } from '../user/user';
import { Status } from '../status/status';

export class Task {

    constructor( public id: number,
        public name: string,
        public description: string,
        public createdUser: number,
        public assignedUser: number,
        public status: number ) { }
}
