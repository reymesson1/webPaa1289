import { Component, OnInit } from '@angular/core';
import { HttpClient, HttpHeaders } from '@angular/common/http';
import {Router} from '@angular/router';
import {RestapiService} from '../restapi.service';

@Component({
  selector: 'app-login',
  templateUrl: './login.component.html',
  styleUrls: ['./login.component.css']
})
export class LoginComponent implements OnInit {

  constructor(public restapiservice : RestapiService, private router : Router) { }

  ngOnInit(): void {
    if(this.restapiservice.isAuthenticated){
      this.router.navigateByUrl('/home');
    }
  }

  onSubmit(event){
    this.restapiservice.setLogin(event);    
  }

}
