import { Component, OnInit } from '@angular/core';
import { ActivatedRoute, Router } from '@angular/router';

@Component({
  selector: 'app-navbar',
  templateUrl: './navbar.component.html',
  styleUrls: ['./navbar.component.css']
})
export class NavbarComponent implements OnInit {
  callLoginComponent:boolean=false;
  callRegisterComponent:boolean=false;
  constructor(private router:Router,private activeRoute:ActivatedRoute) { }

  ngOnInit(): void {

  }
  login(){
    this.callLoginComponent=true;
    this.callRegisterComponent=false;
  }
  register(){
    this.callRegisterComponent=true;
    this.callLoginComponent=false;
  }
}
