import { Component, OnInit } from '@angular/core';
import { Router } from '@angular/router';
import { UserService } from 'src/app/services/user.service';

@Component({
  selector: 'app-get-quotation',
  templateUrl: './get-quotation.component.html',
  styleUrls: ['./get-quotation.component.css']
})
export class GetQuotationComponent implements OnInit {
  vehicleList: any;
  requestedVehicle: any;
  getQuote: Boolean = false;

  loggedInUserEmail:any;
  loggedInUserName:any;
  loggedInUseraddress:any;
  loggedInUsercity:any;
  loggedInUserstate:any;
  loggedInUserphoneNumber:any;
  constructor(private service: UserService, private router: Router) { }

  ngOnInit(): void {
    this.service.getVehicleList().subscribe(data => {
      this.vehicleList = data;
      console.log("vehicleList" + this.vehicleList);
    });

    this.loggedInUserEmail = localStorage.getItem("email");
    this.loggedInUserName = localStorage.getItem("name");
    this.loggedInUseraddress = localStorage.getItem("address");
    this.loggedInUsercity = localStorage.getItem("city");
    this.loggedInUserstate = localStorage.getItem("state");
    this.loggedInUserphoneNumber = localStorage.getItem("phoneNumber");
  }
  getQuotation(myform) {
    this.service.getVehicleById(myform.vehicleId).subscribe(data => {
      this.requestedVehicle = data;
      this.getQuote=true;
      console.log("Request quote for : " + this.requestedVehicle);
    });
  }
  printDiv(divName) {
    var printContents = document.getElementById(divName).innerHTML;
    var originalContents = document.body.innerHTML;

    document.body.innerHTML = printContents;

    window.print();

    document.body.innerHTML = originalContents;
}
}
