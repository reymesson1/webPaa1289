import { Component, OnInit, Input } from '@angular/core';
import {Router} from '@angular/router';
import {RestapiService} from '../restapi.service';


@Component({
  selector: 'app-breadcrumb',
  templateUrl: './breadcrumb.component.html',
  styleUrls: ['./breadcrumb.component.css']
})
export class BreadcrumbComponent implements OnInit {

  constructor(public restapiservice : RestapiService, private router : Router) { }

  @Input() name;


  ngOnInit(): void {

    console.log("hello from dashboard "+name);
 
  }

  goToHome(){

    this.router.navigateByUrl('/');
  }
  gotoCursos(){

    this.router.navigateByUrl('/miscursos');
  }

}
