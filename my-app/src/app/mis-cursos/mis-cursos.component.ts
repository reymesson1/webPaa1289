import { Component, OnInit } from '@angular/core';
import {Router} from '@angular/router';
import {NgbModal, ModalDismissReasons} from '@ng-bootstrap/ng-bootstrap';
import { NgbdModalContent } from '../modal/ngbd-modal-content';
import { NgbdModalContentDetail } from '../modal/ngbd-modal-content-detail';
import { NgbdModalContentEdit } from '../modal/ngbd-modal-content-edit';
import { RestapiService, Master } from '../restapi.service';
import { Observable } from 'rxjs';

@Component({
  selector: 'app-mis-cursos',
  templateUrl: './mis-cursos.component.html',
  styleUrls: ['./mis-cursos.component.css']
})
export class MisCursosComponent implements OnInit {

  users: Master[] = [];
  profile : boolean;

  constructor(private router : Router,private modalService: NgbModal, public restapiservice : RestapiService) { }

  ngOnInit(): void {

    this.restapiservice.getAPI("http://localhost:8080/masters");
    
    setTimeout(() => {
      
      this.users = this.restapiservice.getMaster();            
      this.profile = this.restapiservice.getProfile();

    }, 5000);
  }

  open() {
    const modalRef = this.modalService.open(NgbdModalContent);
    modalRef.componentInstance.name = 'World';
  }


  goTo(){

    this.router.navigateByUrl('/dashboard');    
  }

}
