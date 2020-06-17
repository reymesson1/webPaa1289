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

  exams: Exam[] = [

  ];
  exams2: Exam[] = [

    new Exam("1","Exam 1","Juan Perez")
  ];

  tasks: Task[] = [

    new Task("1","Tarea 1",this.exams,"Juan Perez"),
    new Task("2","Tarea 2",this.exams2,"Juan Perez"),
    new Task("3","Tarea 3",this.exams2,"Juan Perez"),
    new Task("4","Tarea 4",this.exams2,"Juan Perez"),
    new Task("5","Tarea 5",this.exams2,"Juan Perez")
  ];

  details: Detail [] = [

    new Detail("1","Modulo 1",this.tasks,"Juan Perez")
  ];

  masters: any[] = [];

  qualifications: any[] = [];

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

  getAPI(url:string){

    const headerDict = {
      'Content-Type': 'application/json',
      'Authorization': 'Bearer eyJhbGciOiJIUzI1NiJ9.eyJzdWIiOiJmb28iLCJleHAiOjE1OTIzMzQ5NDYsImlhdCI6MTU5MjI5ODk0Nn0.zPfwdR3G1w7ZK9sAXkQYn_quu9vFBh2H5dIirYqLAHg'
      // 'Accept': 'application/json',
      // 'Access-Control-Allow-Headers': 'Content-Type',
    }
    
    const requestOptions = {                                                                                                                                                                                 
      headers: new Headers(headerDict), 
    };

    let customHeaders = new Headers({ Authorization: "Bearer " + localStorage.getItem("token")});
const requestOptions: RequestOptionsArgs = { headers: customHeaders };
return this.http.get("/api/orders", requestOptions);

    this.http.get(url, requestOptions)
    // this.http.get('http://localhost:8080/masters')
      .subscribe(
        (val) => {
            console.log("POST call successful value returned in body",val);

            this.masters = val;
            // val.map(res=>{
            //   this.users.push(res);
            // })
                      
        },
        response => {
          this.data=response;
          console.log("POST call in error", response);
        },
        () => {
          console.log("The POST observable is now completed.");
    });

  }

  postAPI(){


  }

  getMaster(){

    return this.masters;
  }

  addDetail(event,id){

    var newDetail = new Detail("1","Modulo 2",this.tasks,"Juan Perez");

    this.masters[id-1].details.push(newDetail);

  }

  addMaster(event){

    var newMaster = new Master("4","Cocina Basica 4",true, this.details, "admin");

    this.masters.push(newMaster);

    this.http.post("http://localhost:8080/addmaster/",
    {
      "name": event.value.modulo,
      "active": true,
      "creator": localStorage.token
    
    })
    .subscribe(
        (val) => {
            console.log("POST call successful value returned in body",val);
        },
        response => {
          // this.data=response;
          console.log("POST call in error", response);
        },
        () => {
          console.log("The POST observable is now completed.");
    });

    
  }

  removeDetail(masterId, detailId){


  }
  editDetail(event,masterId, detailId){


  }
  addTask(event,id,idUrl){

    var newTask = new Task("1","Task 1",this.exams,"Juan Perez");

    this.masters[id-1].details[idUrl-1].tasks.push(newTask);

  }
  editTask(event, nameurl, modulo, nametask){

    this.masters[nameurl-1].details[modulo-1].tasks[nametask-1].name = event.value.modulo;
  }
  removeTask(idUrl, idModulo, idTask){

    this.masters[idUrl-1].details[idModulo-1].tasks.splice(idTask-1,1);
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

    return this.qualifications;
  }

  getAPIQualification(){

    this.http.post("http://localhost:8080/qualification/",
    {
      "id": "1",
      "created" : "",
      "creator": localStorage.token
    })
    .subscribe(
        (val) => {
                console.log("POST call successful value returned in body",val);
                this.qualifications = val
        },
        response => {
          this.data=response;
          console.log("POST call in error", response);
        },
        () => {
          console.log("The POST observable is now completed.");
    });

  }

  getProfile(){

    return true;
  }

  

}

export class Master {
  id: string;
  name: string;
  active: boolean;
  details: Detail[];
  creator: string;

  constructor(id:string, name:string,active:boolean, details: Detail[], creator:string){

    this.id = id;
    this.name = name;
    this.active = active;
    this.details = details;
    this.creator = creator;
  }

}
export class Detail {
  id: string;
  name: string;
  tasks: Task[];
  creator: string;

  constructor(id:string, name:string, tasks:Task[], creator:string){

    this.id = id;
    this.name = name;
    this.tasks = tasks;
    this.creator = creator;
  }

}
export class Task {
  id: string;
  name: string;
  exams: Exam[];
  creator: string;

  constructor(id:string, name:string, exams:Exam[], creator:string){

    this.id = id;
    this.name = name;
    this.exams=exams;
    this.creator = creator;
  }


}
export class Exam {
  id: string;
  name: string;
  creator: string;

  constructor(id:string, name:string, creator:string){

    this.id = id;
    this.name = name;
    this.creator = creator;
  }
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