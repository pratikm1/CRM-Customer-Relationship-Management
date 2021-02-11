import { Component, OnInit } from '@angular/core';
import { ActivatedRoute, Router } from '@angular/router';
import { AdminService } from '../services/admin.service';
import { UserService } from '../services/user.service';

@Component({
  selector: 'app-common-landing-page',
  templateUrl: './common-landing-page.component.html',
  styleUrls: ['./common-landing-page.component.css']
})
export class CommonLandingPageComponent implements OnInit {

  vehicleList:any;
  offersList: any;
  constructor(private service:UserService,private adminService:AdminService, private router:Router,private activatedRoute:ActivatedRoute) { }

  ngOnInit(): void {
    this.service.getVehicleList().subscribe(data=>{
      this.vehicleList= data;
    });

    this.adminService.listAllOffers().subscribe(data => {
      this.offersList = data;
    });
  }
 
}
