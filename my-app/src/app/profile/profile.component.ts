import { Component, OnInit } from '@angular/core';
import { NgbActiveModal, NgbModal } from '@ng-bootstrap/ng-bootstrap';
import {NgForm} from '@angular/forms';
import { HttpClient, HttpHeaders } from '@angular/common/http';
import {Router} from '@angular/router';
import {RestapiService} from '../restapi.service';
import { ActivatedRoute } from '@angular/router';
import { NgbdModalContentBulkUpload } from '../modal/ngbd-modal-content-bulkupload';


@Component({
  selector: 'app-profile',
  templateUrl: './profile.component.html',
  styleUrls: ['./profile.component.css']
})
export class ProfileComponent implements OnInit {

  fileToUpload: File = null;

  constructor(private modalService: NgbModal, public restapiservice : RestapiService, public route : ActivatedRoute) { }

  ngOnInit(): void {
  }

  open() {
    const modalRef = this.modalService.open(NgbdModalContentBulkUpload);
    modalRef.componentInstance.name = "Bulkupload";
    modalRef.componentInstance.detailId = "";
  }

  handleFileInput(files: FileList) {
    this.fileToUpload = files.item(0);
    this.restapiservice.uploadFileExcel(this.fileToUpload);
    console.log(this.fileToUpload);
  }


}
