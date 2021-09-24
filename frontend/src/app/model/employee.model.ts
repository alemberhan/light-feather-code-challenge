export interface IEmployee {
    firstName?: string;
    lastName?: string;
    email?: string;
    phone?: string;
    notifyByEmail?: boolean;
    notifyByPhone?: boolean;
    supervisor?: string;
}
export class Employee implements IEmployee {
    constructor(
        public firstName?: string,
        public lastName?: string,
        public email?: string,
        public phone?: string,
        public notifyByEmail?: boolean,
        public notifyByPhone?: boolean,
        public supervisor?: string
    ) { }
}
