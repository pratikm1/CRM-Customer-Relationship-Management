import { isNull, NULL_EXPR } from '@angular/compiler/src/output/output_ast';
import { Component, OnInit } from '@angular/core';
import { ActivatedRoute, Router } from '@angular/router';

@Component({
  selector: 'app-admin-home',
  templateUrl: './admin-home.component.html',
  styleUrls: ['./admin-home.component.css']
})
export class AdminHomeComponent implements OnInit {

  name:any;
  constructor(private router:Router, private activeRoute:ActivatedRoute) { }

  ngOnInit(): void {
    this.name = localStorage.getItem("admin-name");
  }
  logout(){
       localStorage.removeItem("loggedInUser");
        // localStorage.setItem("loggedInUser",null);
        localStorage.setItem("adminLoggedInStatus","false");
        this.router.navigate(["/"]).then(()=>{
          window.location.reload();
        })
      }

      // x:boolean=false;
      // tap(){
      //   this.x=true;
      // }
}
