import { Component, OnInit } from '@angular/core';
import {NgbModal, ModalDismissReasons} from '@ng-bootstrap/ng-bootstrap';
import { NgbdModalContent } from '../modal/ngbd-modal-content';
import { NgbdModalContentDetail } from '../modal/ngbd-modal-content-detail';
import { NgbdModalContentEdit } from '../modal/ngbd-modal-content-edit';
import { RestapiService, Master } from '../restapi.service';
import { Observable } from 'rxjs';
import { ActivatedRoute } from '@angular/router';

@Component({
  selector: 'app-dashboard',
  templateUrl: './dashboard.component.html',
  styleUrls: ['./dashboard.component.css']
})
export class DashboardComponent implements OnInit {

  users: Master[] = [];
  id:any;
  data : Master[] = [];

  constructor(private modalService: NgbModal, public restapiservice : RestapiService, public route : ActivatedRoute) { }

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
  openEdit(id:String,detailId) {
    const modalRef = this.modalService.open(NgbdModalContentEdit);
    modalRef.componentInstance.name = id;
    modalRef.componentInstance.detailId = detailId;
  }
  removeDetail(masterId:String, detailId:String){
    
    this.restapiservice.removeDetail(masterId, detailId);
  }

}
