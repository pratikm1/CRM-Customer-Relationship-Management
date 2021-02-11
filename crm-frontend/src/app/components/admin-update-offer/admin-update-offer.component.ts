import { Component, OnInit } from '@angular/core';
import { ActivatedRoute, Router } from '@angular/router';
import { AdminService } from 'src/app/services/admin.service';

@Component({
  selector: 'app-admin-update-offer',
  templateUrl: './admin-update-offer.component.html',
  styleUrls: ['./admin-update-offer.component.css']
})
export class AdminUpdateOfferComponent implements OnInit {
  offerId:any;
  offerName:any;
  offerDesc:any;
  offerDiscountPercentage:any;
  startDate:any;
  endDate:any;
  offerImage:any;

  selectedFile: any;
  constructor(private adminService: AdminService, private router: Router, private activatedRoute:ActivatedRoute) { }


  // {       
  //     "offerName": "t2",
  //     "offerDesc": "t2",
  //     "offerDiscountPercentage": 10.0,
  //     "startDate": "2010-01-01",
  //     "endDate": "2012-12-12",
  //     "offerImage": ""
  // }
  ngOnInit(): void {
    this.activatedRoute.paramMap.subscribe(parameterMap => {
      this.offerName =parameterMap.get('offerName');
      this.offerId=+parameterMap.get('offerId');
      this.offerDesc=parameterMap.get('offerDesc');
      this.offerDiscountPercentage=+parameterMap.get('offerDiscountPercentage');
      this.startDate=parameterMap.get('startDate');
      this.endDate=parameterMap.get('endDate');
      this.offerImage=parameterMap.get('offerImage');
    })

  }
  public onFileChanged(event) {
    console.log(event);
    this.selectedFile = event.target.files[0];
  }

  updateOffer(myform){
    console.log(myform);
    this.adminService.editOfferWithImage(this.selectedFile,this.offerId,myform).subscribe(data => {
      console.log(data),
        // this.employee = new Employee();
        error => {
          console.log(error);
        }
    });

    alert("Registration Successful....");
    this.router.navigate(['/manage-offer']);
  }
}
