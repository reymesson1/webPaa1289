import { Component, Input } from '@angular/core';
import { NgbActiveModal, NgbModal } from '@ng-bootstrap/ng-bootstrap';
import {NgForm} from '@angular/forms';
import { HttpClient, HttpHeaders } from '@angular/common/http';
import {Router} from '@angular/router';
import {RestapiService} from '../restapi.service';

@Component({
  selector: 'ngbd-modal-content-task',
  templateUrl: './ngbd-modal-content-task.html'
})

export class NgbdModalContentTask {
  @Input() name;
  @Input() nameurl;
  fileToUpload: File = null;
  profile : boolean;

  constructor(public restapiservice : RestapiService, private router : Router, public activeModal: NgbActiveModal) { }

  ngOnInit(){

    this.profile = this.restapiservice.getProfile();
  }  

  onSubmit(event){
    console.log(this.name);
    // this.restapiservice.addDetail(event, this.name);    
    this.restapiservice.addTask(event, this.name, this.nameurl);  
  
  }

  handleFileInput(files: FileList) {
    this.fileToUpload = files.item(0);
    this.restapiservice.uploadFileExcelExams(this.fileToUpload);
    console.log(this.fileToUpload);
  }


  // handleFileInput(files: FileList) {
  //   this.fileToUpload = files.item(0);
  //   this.restapiservice.uploadFile(this.fileToUpload);
  //   console.log(this.fileToUpload);
  // }

}