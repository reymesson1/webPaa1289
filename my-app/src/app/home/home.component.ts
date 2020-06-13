import { Component, OnInit } from '@angular/core';
import {NgForm} from '@angular/forms';
import { HttpClient, HttpHeaders } from '@angular/common/http';
import {Router} from '@angular/router';
import {RestapiService, Master} from '../restapi.service';
import { Observable } from 'rxjs/Observable';
import 'rxjs/Rx';

@Component({
  selector: 'app-home',
  templateUrl: './home.component.html',
  styleUrls: ['./home.component.css']
})
export class HomeComponent implements OnInit {

  constructor(public restapiservice : RestapiService, private router : Router) { }

  ngOnInit(){

    this.restapiservice.getMaster().subscribe(

      (items : Master[]) =>{
         console.log(items);
      }
    )

    // const myNumbers = Observable.interval(1000);
  
    // myNumbers.subscribe(
    
    //   (number: number)=>{
      
    //     console.log(number);
    //   }
    
    // )
  }
}
