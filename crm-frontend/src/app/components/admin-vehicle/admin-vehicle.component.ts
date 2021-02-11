import { Component, OnInit } from '@angular/core';
import { ActivatedRoute, Router } from '@angular/router';
import { AdminService } from 'src/app/services/admin.service';
import { UserService } from 'src/app/services/user.service';

@Component({
  selector: 'app-admin-vehicle',
  templateUrl: './admin-vehicle.component.html',
  styleUrls: ['./admin-vehicle.component.css']
})
export class AdminVehicleComponent implements OnInit {

vehicleList:any;
totalRecords: Number;
page: Number = 1;
itemsPerPage: 10;
  constructor(private service:UserService,private adminService:AdminService, private router:Router,private activatedRoute:ActivatedRoute) { }

  ngOnInit(): void {
  
  this.service.getVehicleList().subscribe(data=>{
    this.vehicleList= data;
  });  
  }

  removeVehicle(value){
    
    if(confirm("Press OK to confirm delete")){
      console.log("In remove Vehicle function: "+value);
      this.adminService.deleteVehicle(value).toPromise().then(()=>{
      window.location.reload();
    })
  }
  }
  updateVehicleDetails(vehicle){
    console.log("Vehicle Id: "+vehicle.vehicleId);
    this.router.navigate(['/admin-update-vehicle',vehicle]);

    }

   
}
