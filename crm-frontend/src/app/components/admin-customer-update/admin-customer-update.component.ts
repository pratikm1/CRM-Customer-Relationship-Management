import { Component, OnInit } from '@angular/core';
import { ActivatedRoute, Router } from '@angular/router';
import { AdminService } from 'src/app/services/admin.service';

@Component({
  selector: 'app-admin-customer-update',
  templateUrl: './admin-customer-update.component.html',
  styleUrls: ['./admin-customer-update.component.css']
})
export class AdminCustomerUpdateComponent implements OnInit {
  userId: Number;
  username: any;
  email: any;
  password: any;
  address: any;
  city: any;
  state: any;
  pincode: Number;
  phoneNumber: Number;
  dob: any;
  role: any;
  constructor(private adminService: AdminService, private router: Router, private activatedRoute: ActivatedRoute) { }

  ngOnInit(): void {
    this.activatedRoute.paramMap.subscribe(parameterMap => {
      this.username = parameterMap.get('username');
      this.email = parameterMap.get('email');
      this.password = parameterMap.get('password');
      this.address = parameterMap.get('address');
      this.city = parameterMap.get('city');
      this.dob =parameterMap.get('dob');
      this.phoneNumber = +parameterMap.get('phoneNumber');
      this.pincode = +parameterMap.get('pincode');
      this.state = parameterMap.get('state');
      this.role = parameterMap.get('role');
      this.userId=+parameterMap.get('userId');
    })
  }
  updateCustomer(myform) {
    console.log("Updated customer :" + myform);
    this.adminService.updateCustomer(this.userId, myform).then(() => {
      this.router.navigate(['/customers'])
    })

  }
}
