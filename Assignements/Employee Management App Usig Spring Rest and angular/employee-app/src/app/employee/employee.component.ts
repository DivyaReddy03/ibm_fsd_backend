import {Component, OnInit} from '@angular/core';
import {Router} from '@angular/router';
import {EmployeeService} from './employee.service';
import {Employee} from './employee';

@Component({
    selector: 'app-employee',
    templateUrl: './employee.component.html',
    styleUrls: ['./employee.component.css']
})
export class EmployeeComponent implements OnInit{

    employees: Employee[];
    statusMessage: string;
    employee = new Employee();
    
    constructor(private _employeeService: EmployeeService,
                private _router: Router){}

    ngOnInit(): void {
        this.getEmployees();
    }

    getEmployees(): void{
        this._employeeService.getAllEmployees()
            .subscribe((bookData) => this.employees = employeeData,
            (error) =>{
                console.log(error);
                this.statusMessage = "Problem with service. Please try again later!";
            }
        );
        
    }

    addEmployee(): void{
        this._employeeService.addBook(this.employee)
            .subscribe((response) => {console.log(response); this.getEmployees();this.reset();},
            (error) =>{
                console.log(error);
                this.statusMessage = "Problem with service. Please try again later!";
            }
        );   
    }

    private reset(){
        this.employee.id = null;
        this.employee.name = null;
        this.employee.age = null;
        this.employee.designation=null;
        this.employee.department=null;
        this.employee.salary=null;
    }

    deleteBook(employeeId: number){
        console.log("Inside the deleteBook()::::Book id::::"+employeeId);
        this._employeeService.deleteEmployee(employeeId)
            .subscribe((response) => {console.log(response); this.getEmployees();},
            (error) =>{
                console.log(error);
                this.statusMessage = "Problem with service. Please try again later!";
            });
            this.reset();
            console.log("end of deleteEmployee():::::::");
    }

    getBook(employeeId: number){
        this._employeeService.getEmployeeById(employeeId)
            .subscribe((bookData) => {this.employee = employeeData; this.getEmployees(); }),
            (error) => {
                console.log(error);
                this.statusMessage = "Problem with service. Please try again later!";
            }
        this.reset();    
    }
}