import { Component, Input } from '@angular/core';
import { NgbActiveModal, NgbModal } from '@ng-bootstrap/ng-bootstrap';
import {NgForm} from '@angular/forms';
import { HttpClient, HttpHeaders } from '@angular/common/http';
import {Router} from '@angular/router';
import {RestapiService} from '../restapi.service';

@Component({
  selector: 'ngbd-modal-content-edit-task',
  templateUrl: './ngbd-modal-content-edit-task.html'
})

export class NgbdModalContentEditTask {
  @Input() name;//master
  @Input() nameurl;//detail
  @Input() nameTask;//task
  fileToUpload: File = null;
  profile : boolean;


  constructor(public restapiservice : RestapiService, private router : Router, public activeModal: NgbActiveModal) { }

  onSubmit(event){
    this.restapiservice.editTask(event, this.nameurl, this.name , this.nameTask);    
  }

  handleFileInput(files: FileList) {
    this.fileToUpload = files.item(0);
    this.restapiservice.uploadFileExcelExams(this.fileToUpload, this.nameurl, this.name , this.nameTask);

    setTimeout(() => {
      
      this.activeModal.close();

    }, 2000);

    console.log(this.fileToUpload);
  }


}