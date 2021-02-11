import { Injectable } from '@angular/core';
import { HttpClient, HttpClientModule, HttpHeaders } from '@angular/common/http';
@Injectable({
  providedIn: 'root'
})
export class AdminService {

  numbers:any=[9284588772];

  // httpOptions={
  //   headers: new HttpHeaders({'Content-type':'application/json'})
  // };

  constructor(private http:HttpClient) { }

  addVehicle(vehicle){
    return this.http.post("http://localhost:8080/vehicles",vehicle).toPromise();
  }

  addOffer(offer){
    return this.http.post("http://localhost:8080/offers",offer).toPromise();
  }

  deleteVehicle(value){
    return this.http.delete("http://localhost:8080/vehicles/delete/"+value);
  }

  listAllOffers(){
    return this.http.get("http://localhost:8080/offers");
  }
  deleteOffer(value){
    return this.http.delete("http://localhost:8080/offers/delete/"+value);
  }
  getCustomerList(){
    return this.http.get("http://localhost:8080/users");
  }
  deleteCustomer(value){
    return this.http.delete("http://localhost:8080/users/delete/"+value);
  }
  updateCustomer(value,userData){
    return this.http.put("http://localhost:8080/users/update/"+value,userData).toPromise();
  }
  editVehicle(id,updatedVehicleObject){
    return this.http.put("http://localhost:8080/vehicles/update/"+id,updatedVehicleObject).toPromise();
  }
  editOffer(id,updatedOfferObject){
    return this.http.put("http://localhost:8080/offers/update/"+id,updatedOfferObject).toPromise();
  }
  //registerWithImage
  
  addVehicleWithImage(selectedFile: File,vehicle){

    const uploadData = new FormData();
    uploadData.append("imageFile", selectedFile);
    console.log(`sending ${vehicle}`);
    uploadData.append("vehicle", JSON.stringify(vehicle));
    return this.http.post("http://localhost:8080/vehicles/registerWithImage",uploadData,{ responseType: 'text' });
  }
  addVehicleWithImage2(selectedFile: File,vehicle){

    const uploadData = new FormData();
    uploadData.append("imageFile", selectedFile);
    console.log(`sending ${vehicle}`);
    uploadData.append("vehicle", JSON.stringify(vehicle));
    return this.http.post("http://localhost:8080/vehicles/registerWithImage",uploadData,{ responseType: 'text' }).toPromise();
  }

  editVehicleWithImage(selectedFile: File,id,updatedVehicleObject){
    const uploadData = new FormData();
    uploadData.append("imageFile", selectedFile);
    console.log(`sending ${updatedVehicleObject}`);
    uploadData.append("vehicle", JSON.stringify(updatedVehicleObject));
    return this.http.put("http://localhost:8080/vehicles/update/"+id,uploadData,{ responseType: 'text' });
  }

  addOfferWithImage(selectedFile: File,offer){

    const uploadData = new FormData();
    uploadData.append("imageFile", selectedFile);
    console.log(`sending ${offer}`);
    uploadData.append("offer", JSON.stringify(offer));
    return this.http.post("http://localhost:8080/offers",uploadData,{ responseType: 'text' });
  }
  addOfferWithImage2(selectedFile: File,offer){

    const uploadData = new FormData();
    uploadData.append("imageFile", selectedFile);
    console.log(`sending ${offer}`);
    uploadData.append("offer", JSON.stringify(offer));
    return this.http.post("http://localhost:8080/offers",uploadData,{ responseType: 'text' }).toPromise();
  }

  editOfferWithImage(selectedFile: File,id,updatedOfferObject){
    const uploadData = new FormData();
    uploadData.append("imageFile", selectedFile);
    console.log(`sending ${updatedOfferObject}`);
    uploadData.append("offer", JSON.stringify(updatedOfferObject));
    return this.http.put("http://localhost:8080/offers/update/"+id,uploadData,{ responseType: 'text' });
  }

  getPhoneNumbers(){
    return this.http.get("http://localhost:8080/users/phonenumbers");
 
  }
  sendBulkMessage(phonenumbers){
    
    return this.http.get("https://www.fast2sms.com/dev/bulkV2?authorization=2evl4XLb0qJ8C9Iu7OHwTWiphFzrKUPDkYtQsSn5oA6gRZxafde72CIoD65dJf8mgzLp3kltvQWAPni4&route=s&sender_id=CHKSMS&message=7&variables_values=Welcome%20to%20the%20CRM-TOOL%7C&flash=0&numbers="+phonenumbers);
   }
 
}
