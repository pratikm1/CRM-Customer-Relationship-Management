import { Component, OnInit } from '@angular/core';
import { Router } from '@angular/router';
import { AdminService } from 'src/app/services/admin.service';
import { UserService } from 'src/app/services/user.service';

@Component({
  selector: 'app-admin-customer-list',
  templateUrl: './admin-customer-list.component.html',
  styleUrls: ['./admin-customer-list.component.css']
})
export class AdminCustomerListComponent implements OnInit {
  customerList: any;
  totalRecords: Number;
  page: Number = 1;
  itemsPerPage: 10;
  phoneNos:any;
  constructor(private service: UserService, private adminService: AdminService, private router: Router) { }

  ngOnInit(): void {
    this.adminService.getCustomerList().subscribe(data => {
      this.customerList = data;
      console.log("Phone numbers"+JSON.stringify(this.customerList).valueOf["phoneNumber"]);
    });

    this.adminService.getPhoneNumbers().subscribe(data => {
      this.phoneNos = data;
    })
}
  removeCustomer(value) {
    if (confirm("Press OK to confirm delete")) {
      console.log("In remove Customer function: " + value);
      this.adminService.deleteCustomer(value).toPromise().then(() => {
        window.location.reload();
      })
    }
  }

  updateCustomerDetails(customer) {
    console.log("Customer Id: " + customer.userId);
    this.router.navigate(['/update-customer', customer]);

  }

  messageToALl() {
    console.log("NOS: " + this.phoneNos);
    this.adminService.sendBulkMessage(this.phoneNos).subscribe(data => {
      console.log(data);
    })
  }

}
