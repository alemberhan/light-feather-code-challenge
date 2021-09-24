import { Injectable } from '@angular/core';
import { HttpClient, HttpResponse } from '@angular/common/http';
import { Observable } from 'rxjs';
import { IEmployee } from './model/employee.model';
@Injectable({ providedIn: 'root' })
export class AppService {
    public resourceUrl = 'http://localhost:8080/api/';

    constructor(private http: HttpClient) { }

    supervisors(): Observable<string[]> {
        return this.http.get<string[]>(this.resourceUrl + 'supervisors');
    }

    create(employee: IEmployee): Observable<IEmployee> {
        return this.http.post<IEmployee>(this.resourceUrl + 'employees', employee);
    }
}
