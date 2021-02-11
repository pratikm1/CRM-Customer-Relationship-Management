import { Component, OnInit } from '@angular/core';
import { ActivatedRoute, Router } from '@angular/router';

@Component({
  selector: 'app-customer-home',
  templateUrl: './customer-home.component.html',
  styleUrls: ['./customer-home.component.css']
})
export class CustomerHomeComponent implements OnInit {

  name:any; //for welcome box
  constructor(private router:Router, private activeRoute:ActivatedRoute) { }

  ngOnInit(): void {
    this.name = localStorage.getItem("name");
  }
  logout(){
//  localStorage.removeItem("loggedInUser");
    localStorage.setItem("loggedInUser",null);
    localStorage.removeItem("loggedInUserId");
    localStorage.setItem("customerLoggedInStatus","false");
    this.router.navigate(["/"]).then(()=>{
      window.location.reload();
    })
  }
}
