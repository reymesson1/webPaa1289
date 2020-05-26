import { Component } from '@angular/core';
import {NgbModal, ModalDismissReasons} from '@ng-bootstrap/ng-bootstrap';
import { NgbdModalContent } from './ngbmoda-component';

@Component({
  selector: 'app-root',
  templateUrl: './app.component.html',
  styleUrls: ['./app.component.css']
})
export class AppComponent {
  title = 'webPaa1287';


  constructor(public activeModal: NgbModal) {}

  open(){

    this.activeModal.open(NgbdModalContent);
  }  

}