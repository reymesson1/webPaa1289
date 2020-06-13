import { Injectable } from '@angular/core';
import { HttpClient, HttpHeaders } from '@angular/common/http';
import { Observable, of } from 'rxjs';
import {Router} from '@angular/router';
import { DatePipe } from '@angular/common';

@Injectable({
  providedIn: 'root'
})

export class RestapiService {

  data : String = "";
  TOKEN_KEY = 'token';
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

    this.http.get('http://localhost:8080/masters')
    .subscribe(
      (val) => {
          console.log("POST call successful value returned in body",val);

          val.map(res=>{
            this.users.push(res);
          })
                    
      },
      response => {
        this.data=response;
        console.log("POST call in error", response);
      },
      () => {
        console.log("The POST observable is now completed.");
  });

  }

  addDetail(event,id){

    this.http.post("http://localhost:8080/adddetail/",
    {
      "id": id,
      "name": event.value.modulo, 
      "active": true,
      "created" : "",
      "creator": localStorage.token
    })
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

  addMaster(event){ 


  }

  removeDetail(masterId, detailId){


  }
  editDetail(event,masterId, detailId){


  }
  addTask(event,id,idUrl){


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

    this.http.post("http://localhost:8080/qualification/",
    {
      "id": "1",
      "created" : "",
      "creator": localStorage.token
    })
    .subscribe(
        (val) => {
            console.log("POST call successful value returned in body",val);
            // this.qualifications = val;
                val.map(res=>{
                    this.qualifications.push(res);
                })

        },
        response => {
          this.data=response;
          console.log("POST call in error", response);
        },
        () => {
          console.log("The POST observable is now completed.");
    });

  }

  

}

export interface Master {
  id: string;
  name: string;
  active: boolean;
  creator: string;
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