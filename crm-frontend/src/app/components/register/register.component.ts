import { Component, OnInit } from '@angular/core';
import { Router } from '@angular/router';
import { UserService } from 'src/app/services/user.service';

@Component({
  selector: 'app-register',
  templateUrl: './register.component.html',
  styleUrls: ['./register.component.css']
})
export class RegisterComponent implements OnInit {

  regMsg:string=null;
  constructor(private service:UserService, private router:Router) { }

  ngOnInit(): void {
  }

  register(UserData){
    console.log(UserData);
    var x = UserData;
let temp2=[];
    let temp= {
      "username": UserData.username,
      "email": UserData.email,
      "password": UserData.password,
      "conDet": {
          "address": UserData.address,
          "city": UserData.city,
          "state": UserData.state,
          "pincode": UserData.pincode,
          "phoneNumber": UserData.phoneNumber,
          "dob": UserData.dob
      }
      , "role": UserData.role
}
console.log(temp);
x["role"]="CUSTOMER";
    // console.log("X: "+x);
    this.service.signUp(x).then(Response=>{
      console.log(Response);
      this.router.navigate(['/login']);
    }).catch(error=>{
      this.regMsg="User already exists!, Please try again!";
      console.log(error);

    });
  }

}
