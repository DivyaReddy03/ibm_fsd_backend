import { Injectable } from '@angular/core';
import { Http, Response, Headers, RequestOptions } from '@angular/http';
import { Observable } from 'rxjs';
import 'rxjs/add/operator/map';
import 'rxjs/add/operator/catch';
import { Employee} from './employee';

@Injectable()
export class EmployeeService{
    
    constructor(private _httpService: Http){}

    getAllEmployees(): Observable<Employee[]>{
        return this._httpService.get("http://localhost:8037/spring-mvc-restfull-crud-example/employee")
                .map((response: Response) => response.json())
                .catch(this.handleError);
    }

    getEmployeeById(employeeId: number): Observable<Employee>{
        return this._httpService.get("http://localhost:8037/spring-mvc-restfull-crud-example/employee/"+employeeId)
                .map((response: Response) => response.json())
                .catch(this.handleError);
    }

    addEmployee(employee:Employee){
        let body = JSON.parse(JSON.stringify(employee));
        let headers = new Headers({ 'Content-Type': 'application/json' });
        let options = new RequestOptions({ headers: headers });
        if(employee.id){    
            return this._httpService.put("http://localhost:8037/spring-mvc-restfull-crud-example/employee/"+employee.id, body, options);
        }else{
            return this._httpService.post("http://localhost:8037/spring-mvc-restfull-crud-example/employee", body, options);
        }
    }

    deleteEmployee(employeeId: number){
        return this._httpService.delete("http://localhost:8037/spring-mvc-restfull-crud-example/employee/"+employeeId);
    }

    private handleError(error: Response){
        return Observable.throw(error);
    }
}