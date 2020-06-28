import { Component, Input } from '@angular/core';
import { NgbActiveModal, NgbModal } from '@ng-bootstrap/ng-bootstrap';
import {NgForm} from '@angular/forms';
import { HttpClient, HttpHeaders } from '@angular/common/http';
import {Router} from '@angular/router';
import {RestapiService} from '../restapi.service';

@Component({
  selector: 'ngbd-modal-content-bulkupload-exams',
  templateUrl: './ngbd-modal-content-bulkupload-exams.html'
})
export class NgbdModalContentBulkUploadExams {
  @Input() name;
  fileToUpload: File = null;

  constructor(public restapiservice : RestapiService, private router : Router, public activeModal: NgbActiveModal) { }

  handleFileInput(files: FileList) {
    this.fileToUpload = files.item(0);
    this.restapiservice.uploadFileExcelExams(this.fileToUpload);
    console.log(this.fileToUpload);
    this.activeModal.close();

  }


}