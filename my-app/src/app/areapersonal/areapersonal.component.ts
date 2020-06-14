import { Component, OnInit } from '@angular/core';
import {Router} from '@angular/router';
import {NgbModal, ModalDismissReasons} from '@ng-bootstrap/ng-bootstrap';
import { NgbdModalContent } from '../modal/ngbd-modal-content';
import { NgbdModalContentDetail } from '../modal/ngbd-modal-content-detail';
import { NgbdModalContentEdit } from '../modal/ngbd-modal-content-edit';
import { RestapiService, Qualification } from '../restapi.service';


@Component({
  selector: 'app-areapersonal',
  templateUrl: './areapersonal.component.html',
  styleUrls: ['./areapersonal.component.css']
})
export class AreapersonalComponent implements OnInit {

  qualifications: Qualification[] = [];

  constructor(private router : Router,private modalService: NgbModal, public restapiservice : RestapiService) { }

  ngOnInit(): void {

    this.restapiservice.getAPIQualification();
    
    setTimeout(() => {  
      
      this.qualifications = this.restapiservice.getQualification();

    }, 3000);

  }

}
