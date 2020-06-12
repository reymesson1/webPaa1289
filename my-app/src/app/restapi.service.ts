import { Injectable } from '@angular/core';
import { HttpClient, HttpHeaders } from '@angular/common/http';
import { Observable, of } from 'rxjs';
import 'rxjs/Rx';
import {Router} from '@angular/router';
import { DatePipe } from '@angular/common';
import { create } from 'domain';
import { Subject } from 'rxjs';

@Injectable({
  providedIn: 'root'
})

export class RestapiService {

  ingredientsChanged = new Subject<Master[]>();
  data : String = "";
  TOKEN_KEY = 'token';
  masters: Master[] = [
    new Master("1","Cocina Basica",true, "2012-06-12"),
    new Master("2","Cocina Basica 2",true, "2012-06-12")
  ];
  users: Master[] = [];
  details: Detail[] = [];
  tasks: Task[] = [];
  qualifications: Qualification[] = [];

  constructor(private http:HttpClient,private router : Router) {}

  get token(){
    return localStorage.getItem(this.TOKEN_KEY);
  }

  get isAuthenticated(){
    return !!localStorage.getItem(this.TOKEN_KEY)
  }

  logout(){
    localStorage.removeItem(this.TOKEN_KEY);
  }

  setLogin(event){ 

    this.http.post("http://localhost:8080/loading/",
    {
      "username": event.value.username,
      "password": event.value.password
    })
    .subscribe(
        (val) => {
          
            localStorage.setItem(this.TOKEN_KEY, val[0].token);
            
            if(this.isAuthenticated){

              this.router.navigateByUrl('/miscursos');    
            }
            console.log("POST call successful value returned in body",val);
          
        },
        response => {
          this.data=response;
          console.log("POST call in error", response);
        },
        () => {
          console.log("The POST observable is now completed.");
    });

    return of(this.data);

  }

  getMaster(){

    return this.masters.slice();
  }

  addDetail(event,id){

  }

  addMaster(event){ 

    console.log(event.value);

    var newItem : Master =  new Master("1","Cocina Basica 3",true, "2012-06-12");

    // this.masters.push(  newItem  );
    this.masters.push(  newItem  );
    

    this.ingredientsChanged.next(this.masters.slice());  

  }

  removeDetail(masterId, detailId){

  
  }
  editDetail(event,masterId, detailId){

  
  }
  addTask(event,id,idUrl){


  }
  editTask(event,idUrl, idModulo, idTask){

  }
  removeTask(idUrl, idModulo, idTask){

  }

  uploadFile(event){

    const formData: FormData = new FormData();
    formData.append('file', event, event.name);

    this.http.post("http://localhost:8080/uploadtask/",
    formData)
    .subscribe(
          (val) => {
              console.log("POST call successful value returned in body",val);
          },
          response => {
            this.data=response;
            console.log("POST call in error", response);
          },
          () => {
            console.log("The POST observable is now completed.");
    });


  }
  uploadFileExcel(event){

    const formData: FormData = new FormData();
    formData.append('file', event, event.name);

    this.http.post("http://localhost:8080/uploadexcel/",
    formData)
    .subscribe(
          (val) => {
              console.log("POST call successful value returned in body",val);
          },
          response => {
            this.data=response;
            console.log("POST call in error", response);
          },
          () => {
            console.log("The POST observable is now completed.");
    });


  }
  uploadFileExcelExams(event){

    const formData: FormData = new FormData();
    formData.append('file', event, event.name);

    this.http.post("http://localhost:8080/uploadexcelexams/",
    formData)
    .subscribe(
          (val) => {
              console.log("POST call successful value returned in body",val);
          },
          response => {
            this.data=response;
            console.log("POST call in error", response);
          },
          () => {
            console.log("The POST observable is now completed.");
    });


  }

  getQualification(){

  }

  

}

export class Master {
  id: string;
  name: string;
  active: boolean;
  creator: string;

  constructor(id:string, name:string, active:boolean,creator:string){
    
    this.id = id;
    this.name = name;
    this.active = active;
    this.creator = creator;
  }

}
export interface Detail {
  id: string;
  name: string;
  creator: string;
}
export interface Task {
  id: string;
  name: string;
  creator: string;
}
export interface Qualification {
   id : String;
   fecha : String;
   actividad : String;
   calificacion : String;
   student : String;
   created : String;
   creator : String;
}