import { Component, OnInit } from '@angular/core';
import { Router, ActivatedRoute } from '@angular/router';
import { RestapiService, Task } from '../restapi.service';

@Component({
  selector: 'app-task',
  templateUrl: './task.component.html',
  styleUrls: ['./task.component.css']
})
export class TaskComponent implements OnInit {

  idCurso:any;
  idModulo:any;
  idTask:any;
  data: Task[] = [];
  exam: any[] = [];
  current: any = 0;
  next: any = 1;

  constructor(private router : Router, public restapiservice : RestapiService, public route : ActivatedRoute) { }

  ngOnInit(): void {
    this.route.params.subscribe(params => {
      this.idCurso = params['idcurso'];
      this.idModulo = params['idmodulo'];
      this.idTask = params['idtask'];
     });

    this.data = this.restapiservice.getMaster().filter(res=>
    // this.data = this.restapiservice.users.filter(res=>

      res.id==this.idCurso
    )[0].details.filter(res2=>
      
      res2.id==this.idModulo
    )[0].tasks.filter(res3=>
      
      res3.id==this.idTask
    )[0]

    // this.exam = this.data.exams[0];
    this.exam = null;
 
    console.log(this.data);
  }

  currentFunc(){
  
    this.current--;    
    this.next--;    
  }
  nextFunc(){
  
    this.current++;    
    this.next++;    
  }

}
