import { Component, OnInit } from '@angular/core';
import { Router } from '@angular/router';
import { AdminService } from 'src/app/services/admin.service';
import { UserService } from 'src/app/services/user.service';
import { RegisterComponent } from '../register/register.component';

@Component({
  selector: 'app-admin-add-new-customer',
  templateUrl: './admin-add-new-customer.component.html',
  styleUrls: ['./admin-add-new-customer.component.css']
})
export class AdminAddNewCustomerComponent implements OnInit {
  private registerUser: RegisterComponent;
  updatecustcomponent: Boolean = false;
  message:any;
  constructor(private service: AdminService, private userService: UserService, private router: Router) { }

  ngOnInit(): void {
  }
  addNewCustomer(UserData) {
    console.log("In add cust" + UserData.toString());
    var x = UserData;
    let temp2 = [];
    let temp = {
      "username": UserData.username,
      "email": UserData.email,
      "password": UserData.password,
      
        "address": UserData.address,
        "city": UserData.city,
        "state": UserData.state,
        "pincode": UserData.pincode,
        "phoneNumber": UserData.phoneNumber,
        "dob": UserData.dob,
        "role": UserData.role
    }
    console.log(temp);
    // x["role"] = "CUSTOMER";
    this.userService.signUp(temp).then(Response => {
      console.log(Response);
      this.router.navigate(['/customers']);
    }).catch(error => {
      this.message = "User already exists!, Please try again!";
      console.log(error);

    });
  }
  updateCustomer(value) {
    this.updatecustcomponent = true;
  }
}
