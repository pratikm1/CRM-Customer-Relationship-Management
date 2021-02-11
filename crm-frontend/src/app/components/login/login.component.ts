import { Component, OnInit } from '@angular/core';
import { Router } from '@angular/router';
import { UserService } from 'src/app/services/user.service';

@Component({
  selector: 'app-login',
  templateUrl: './login.component.html',
  styleUrls: ['./login.component.css']
})
export class LoginComponent implements OnInit {

  message:string=null;

  constructor(private service:UserService, private router:Router) { }

  ngOnInit(): void {
  }

  authenticate(UserData){
    console.log(UserData.email);
    console.log(UserData);
    this.service.signIn(UserData).then(Response=>{
      var myObj = Response;
      var role = myObj["role"];
      console.log(role);
      localStorage.setItem("admin-name",myObj["username"]);
      if(role == "CUSTOMER")
      {
        localStorage.setItem('loggedInUserId',myObj["userId"]);
        localStorage.setItem('loggedInUser',UserData.email);
        this.message="Login Succesfull";

// for get quotation file
        localStorage.setItem("email",myObj["email"]);
        localStorage.setItem("name",myObj["username"]);
        localStorage.setItem("address",myObj["address"]);
        localStorage.setItem("city",myObj["city"]);
        localStorage.setItem("state",myObj["state"]);
        localStorage.setItem("phoneNumber",myObj["phoneNumber"]);
        
        localStorage.setItem("customerLoggedInStatus","true");
        this.router.navigate(['/customer-home']);
      }
      else if(role == "ADMIN")
      {

        console.log("IN ADMIN PAGE ADMIN");
        localStorage.setItem('loggedInUser',UserData.email);

      
        //localstorage for admin-guard
        localStorage.setItem('adminLoggedInStatus',"true");
        this.message="Login Succesfull";
        
        
        this.router.navigate(['/admin-home']);
        
      }
      else
      {
        this.message="Invalid Credentials please try again!";
      }

    }).catch(error=>{
      // alert("Invalid Credentials, please re-enter details");
      this.message="Invalid Credentials, please try again!";
      console.log(error);
    })
    
  }

}

