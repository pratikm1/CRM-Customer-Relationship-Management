import { Component, OnInit } from '@angular/core';
import { ActivatedRoute, Router } from '@angular/router';
import { AdminService } from 'src/app/services/admin.service';

@Component({
  selector: 'app-admin-vehicle-update',
  templateUrl: './admin-vehicle-update.component.html',
  styleUrls: ['./admin-vehicle-update.component.css']
})
export class AdminVehicleUpdateComponent implements OnInit {
  colorList:any=['RED', 'WHITE', 'BLACK', 'PINK', 'GREEN', "BLUE", "PURPLE", "YELLOW"];
vehicleTemp:any;
vehicleId:any;
modelName:any;
vehicleNumber:any;
qty:any;
regPrice:any;
exShowRoomPrice:any;
price:any;
colour:any;
mileage:any;
cc:any;
fuelcap:any;
torque:any;
image:any;

selectedFile: any;
  constructor(private adminService: AdminService, private router: Router, private activatedRoute:ActivatedRoute) { }

  // {
  //   "vehicleId": 1,
  //   "modelName": "TVS JUPITER",
  //   "vehicleNumber": null,
  //   "qty": 10,
  //   "regPrice": 25000.0,
  //   "exShowRoomPrice": 50000.0,
  //   "price": 50000.0,
  //   "colour": "WHITE",
  //   "mileage": 25.0,
  //   "cc": 100.0,
  //   "fuelcap": 5.5,
  //   "torque": 100.0,
  //   "image": null

  ngOnInit(): void {
    this.activatedRoute.paramMap.subscribe(parameterMap => {
      this.modelName =parameterMap.get('modelName');
      this.vehicleId=parameterMap.get('vehicleId');
      this.vehicleNumber=parameterMap.get('vehicleNumber');
      this.qty=+parameterMap.get('qty');
      this.regPrice=+parameterMap.get('regPrice');
      this.exShowRoomPrice=+parameterMap.get('exShowRoomPrice');
      this.price=+parameterMap.get('price');
      this.colour=parameterMap.get('colour');
      this.mileage=parameterMap.get('mileage');
      this.cc=+parameterMap.get('cc');
      this.fuelcap=+parameterMap.get('fuelcap');
      this.torque=+parameterMap.get('torque');
      // this.image= parameterMap.get('image');
      console.log("Vehicle Temp: "+this.vehicleTemp);
    })
  }

  public onFileChanged(event) {
    console.log(event);
    this.selectedFile = event.target.files[0];
  }

  updateVehicle(myform){
    // console.log("selected file"+this.selectedFile);
    this.adminService.editVehicleWithImage(this.selectedFile,this.vehicleId,myform).subscribe(data => {
      console.log(data),
        error => {
          console.log(error);
        }
    });

    alert("Registration Successful....");
    this.router.navigate(['/manage-vehicles']);
    
  }
}
