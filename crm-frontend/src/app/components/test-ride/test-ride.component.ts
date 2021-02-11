import { Component, OnInit } from '@angular/core';
import { Router } from '@angular/router';
import { UserService } from 'src/app/services/user.service';

@Component({
  selector: 'app-test-ride',
  templateUrl: './test-ride.component.html',
  styleUrls: ['./test-ride.component.css']
})
export class TestRideComponent implements OnInit {
  x: any;
  rideBooked:Boolean=false;
  modelname:string=null;
  testRideDate:string=null;
  constructor(private service: UserService, private router: Router) { }
  //public var list;
  // arr : Array<{vehicle_id: number, 
  //   cc: number,colour:string,
  //   ex_show_room_price:number,
  //   fuelcap:number,image:any,
  //   mileage:number,
  //   model_name:string,
  //   price:number,
  //   qty:number,
  //   reg_price:number,
  //   torque:number,
  //   vehicle_number:number}>=[];

  // vehicle_id, int, NO, PRI, , auto_increment
  // cc, double, YES, , , 
  // colour, varchar(20), YES, , , 
  // ex_show_room_price, double, NO, , , 
  // fuelcap, double, YES, , , 
  // image, longblob, YES, , , 
  // mileage, double, YES, , , 
  // model_name, varchar(320), NO, UNI, , 
  // price, double, YES, , , 
  // qty, int, YES, , , 
  // reg_price, double, YES, , , 
  // torque, double, YES, , , 
  // vehicle_number, varchar(20), YES, , , 



  ngOnInit(): void {
    // this.arr = this.service.getVehicleList();
    this.service.getVehicleList().subscribe(data => {
      this.x = data;
      console.log("x" + this.x);
    });

  }

  bookTestRide(myform) {
    var x = localStorage.getItem("loggedInUserId");
    let temp = {
      "testRideDate": myform.testRideDate,
      "testRideUser": {
        "userId": x
      },
      "testRideVehicle": {
        "vehicleId": myform.vehicleId
      }
    }
    this.service.bookTestRide(temp).then(()=>{
      this.rideBooked=true;

    });
    
  }



}
