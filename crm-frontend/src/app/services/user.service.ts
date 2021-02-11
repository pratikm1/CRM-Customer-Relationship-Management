import { HttpClient, HttpClientModule } from '@angular/common/http';
import { Injectable } from '@angular/core';

@Injectable({
  providedIn: 'root'
})
export class UserService {

  constructor(private http:HttpClient) { }

  getAllUsers(){
    
  }

  signIn(UserData){
    console.log("UserData in signIn: "+UserData);
    return this.http.post("http://localhost:8080/users/log",UserData).toPromise();
  }
  // signIn(em:String,password:String){
  //   console.log("UserData in signIn: "+email+" "+password);
  //   return this.http.get("http://localhost:8080/users/login",{email: em ,password:password}).toPromise();
  // }

  signUp(UserData){
    console.log("UserData from Register service: "+UserData);
    return this.http.post("http://localhost:8080/users",UserData).toPromise();
  }

  getVehicleList(){
    return this.http.get("http://localhost:8080/vehicles");
  }

  bookTestRide(testRide){
    return this.http.post("http://localhost:8080/testride",testRide).toPromise();
  }

  getOffersList(){
    return this.http.get("http://localhost:8080/offers");
  }
  newBooking(newBookingData){
    return this.http.post("http://localhost:8080/newbooking",newBookingData).toPromise();
  }
  //http://localhost:8080/newbooking/id

  getBookingById(newBooking){
    return this.http.post("http://localhost:8080/newbooking/id",newBooking);
  }

  registerComplaint(complaint){
    return this.http.post("http://localhost:8080/complaints",complaint).toPromise();
  }
  getVehicleById(id){
    return this.http.get("http://localhost:8080/vehicles/"+id);
  }
}
