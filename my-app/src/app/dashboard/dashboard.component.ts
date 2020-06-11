import { Component, OnInit } from '@angular/core';
import {NgbModal, ModalDismissReasons} from '@ng-bootstrap/ng-bootstrap';
import { NgbdModalContent } from '../modal/ngbd-modal-content';
import { NgbdModalContentDetail } from '../modal/ngbd-modal-content-detail';
import { NgbdModalContentEdit } from '../modal/ngbd-modal-content-edit';
import { NgbdModalContentTask } from '../modal/ngbd-modal-content-task';
import { NgbdModalContentEditTask } from '../modal/ngbd-modal-content-edit-task';
import { RestapiService, Master } from '../restapi.service';
import { Observable } from 'rxjs';
import { Router, ActivatedRoute } from '@angular/router';

@Component({
  selector: 'app-dashboard',
  templateUrl: './dashboard.component.html',
  styleUrls: ['./dashboard.component.css']
})
export class DashboardComponent implements OnInit {

  users: Master[] = [];
  id:any;
  data : Master[] = [];

  constructor(private router : Router,private modalService: NgbModal, public restapiservice : RestapiService, public route : ActivatedRoute) { }

  ngOnInit() {
    this.users = this.restapiservice.users;
    this.restapiservice.getMaster();

    this.route.params.subscribe(params => {
     this.id = params['id'];
    });
     console.log(this.id);
    //  debugger;
     this.users = this.restapiservice.users.filter(data=>
       data.id==this.id
     )[0]

   }

   ngAfterViewInit(){

    console.log(this.users);
   }
   
  open() {
    const modalRef = this.modalService.open(NgbdModalContent);
    modalRef.componentInstance.name = 'World';
  }
  openDetail(id:String) {
    const modalRef = this.modalService.open(NgbdModalContentDetail);
    modalRef.componentInstance.name = id;
  }
  openTask(idModulo:String) {
    const modalRef = this.modalService.open(NgbdModalContentTask);
    modalRef.componentInstance.name = idModulo;
    modalRef.componentInstance.nameurl = this.id;
  }
  openTaskEdit(idModulo:String,idTask:String) {
    const modalRef = this.modalService.open(NgbdModalContentEditTask);
    modalRef.componentInstance.name = idModulo;
    modalRef.componentInstance.nameTask = idTask;
    modalRef.componentInstance.nameurl = this.id;
  }
  removeTask(idModulo:String,idTask:String) {

    this.restapiservice.removeTask(this.id, idModulo, idTask);
  }
  openEdit(id:String,detailId) {
    const modalRef = this.modalService.open(NgbdModalContentEdit);
    modalRef.componentInstance.name = id;
    modalRef.componentInstance.detailId = detailId;
  }
  removeDetail(masterId:String, detailId:String){
    
    this.restapiservice.removeDetail(masterId, detailId);
  }
  viewDetail(idModulo:String,idCurso:String,idTask:String){

    console.log(idModulo + " " + idCurso + " " + idTask);
    this.router.navigateByUrl('/task/'+idModulo+'/'+idCurso+'/'+idTask);    
  }

}