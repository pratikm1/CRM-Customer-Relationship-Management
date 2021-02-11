import { Component, OnInit } from '@angular/core';

@Component({
  selector: 'app-root',
  templateUrl: './app.component.html',
  styleUrls: ['./app.component.css']
})
export class AppComponent implements OnInit{
  title = 'crm-frontend';
  loggedInUser:any;
  loggedInUserId:any;
  
  ngOnInit(){
    this.loggedInUser = localStorage.getItem("loggedInUser");
    this.loggedInUserId=localStorage.getItem('loggedInUserId');
    console.log(this.loggedInUser);
    if(this.loggedInUser="")
    {
      this.loggedInUser = null;
    }
  }
}
