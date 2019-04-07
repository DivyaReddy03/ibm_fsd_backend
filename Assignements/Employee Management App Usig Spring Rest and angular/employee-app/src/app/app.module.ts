import { BrowserModule } from '@angular/platform-browser';
import { NgModule } from '@angular/core';
import { HttpModule } from '@angular/http';
import { FormsModule } from '@angular/forms';
import { RouterModule, Routes } from '@angular/router';
 
 
import { AppComponent } from './app.component';
import { EmployeeService } from './book/book.service';
import {EmployeeComponent } from './book/book.component';
import { AppChildComponent } from './appchild.component';
import {EmployeListComponent } from './book/bookList.component';
import { PageNotFoundComponent } from './others/pageNotFound.component';
import { HomeComponent } from './book/home.component';
 
 
const appRoutes: Routes = [
  { path: 'home', component: HomeComponent },
  { path: 'books', component:EmployeeListComponent },
  { path: 'addBook', component: EmployeeComponent },
  { path: '', redirectTo: '/home', pathMatch: 'full' },
  { path: '**', component: PageNotFoundComponent }
];
 
@NgModule({
  declarations: [
    AppComponent, EmployeeComponent, AppChildComponent, EmployeeListComponent, HomeComponent, PageNotFoundComponent
  ],
  imports: [
    BrowserModule, HttpModule, FormsModule,  RouterModule.forRoot(appRoutes)
  ],
  providers: [EmployeeService],
  bootstrap: [AppComponent]
})
export class AppModule { }