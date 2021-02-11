import { Component, OnInit } from '@angular/core';
import { Router } from '@angular/router';
import { AdminService } from 'src/app/services/admin.service';
@Component({
  selector: 'app-admin-add-vehicle',
  templateUrl: './admin-add-vehicle.component.html',
  styleUrls: ['./admin-add-vehicle.component.css']
})
export class AdminAddVehicleComponent implements OnInit {
  colorList: any = ['RED', 'WHITE', 'BLACK', 'PINK', 'GREEN', "BLUE", "PURPLE", "YELLOW"];
  vehicleAdded: Boolean = false;
  message:any;
  selectedFile: any;
  constructor(private service: AdminService, private router: Router) { }

  ngOnInit(): void {
  }

  public onFileChanged(event) {
    console.log(event);
    this.selectedFile = event.target.files[0];
  }

  addNewVehicleWithImage(myform) {
    console.log("price In add new vehicle" + myform.price);

    this.service.addVehicleWithImage(this.selectedFile, myform).subscribe(data => {
      console.log(data),
        // this.employee = new Employee();
        error => {
          console.log(error);
        }
    });

    alert("Registration Successful....");
    this.router.navigate(['/manage-vehicles']);
  }

  addNewVehicleWithImage2(myform) {
    console.log("price In add new vehicle" + myform.price);

    this.service.addVehicleWithImage2(this.selectedFile, myform).then(Response => {
      console.log(Response);
      this.router.navigate(['/manage-vehicles']);
    }).catch(error => {
      this.message = "Vehicle already exists!, Please try again!";
      console.log(error);

    });
    
    
    
    
    // subscribe(data => {
    //   console.log(data),
    //     // this.employee = new Employee();
    //     error => {
    //       console.log(error);
    //     }
    // });

    // alert("Registration Successful....");
    
  }
  //  else {
  // alert("Some fields are empty or wrong inputs provided");




addNewVehicle(myform){
  console.log("price In add new vehicle" + myform.price);

  this.service.addVehicle(myform).then(() => {
    this.vehicleAdded = true;
    this.router.navigate(["/manage-vehicles"]).then(() => {
    })

  });
}

 
}
