import { Component, OnInit } from '@angular/core';
import { Router } from '@angular/router';
import { UserService } from 'src/app/services/user.service';

@Component({
  selector: 'app-book-vehicle',
  templateUrl: './book-vehicle.component.html',
  styleUrls: ['./book-vehicle.component.css']
})
export class BookVehicleComponent implements OnInit {
  vehicleList: any;
  offersList:any;
  vehicleBooked:Boolean=false;
  constructor(private service:UserService, private router:Router) { }

  ngOnInit(): void {
    this.service.getVehicleList().subscribe(data => {
      this.vehicleList = data;
      console.log("vehicleList" + this.vehicleList);
    });

    this.service.getOffersList().subscribe(data => {
      this.offersList = data;
      console.log("offersList" + this.offersList);
    });
  }


  bookVehicle(NewBooking){
   
    var x = localStorage.getItem("loggedInUserId");
    let temp =   {
      "bookedVehicleDetails": {
          "vehicleId": NewBooking.vehicleId
      },
      "availableOffers":{
          "offerId":NewBooking.offerId
      },
      "customerNewBooking":{
          "userId":x
      },
      "bookingDate": NewBooking.bookingDate
  }
  console.log(temp);
  this.service.newBooking(temp).then(()=>{
    this.vehicleBooked=true;
  });
  }
  
}
