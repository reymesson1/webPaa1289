import { Component, OnInit } from '@angular/core';
import {Router} from '@angular/router';

@Component({
  selector: 'app-navbar-bottom',
  templateUrl: './navbar-bottom.component.html',
  styleUrls: ['./navbar-bottom.component.css']
})
export class NavbarBottomComponent implements OnInit {

  constructor(private router : Router) { }

  ngOnInit(): void {
  }

  gotoHome(){
    
    this.router.navigateByUrl('/home');    
  }

  goTo(){
    
    this.router.navigateByUrl('/areapersonal');    
  }



}
