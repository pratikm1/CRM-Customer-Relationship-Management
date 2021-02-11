import { Component, OnInit } from '@angular/core';
import { Router } from '@angular/router';
import { AdminService } from 'src/app/services/admin.service';
import { UserService } from 'src/app/services/user.service';

@Component({
  selector: 'app-admin-add-new-offer',
  templateUrl: './admin-add-new-offer.component.html',
  styleUrls: ['./admin-add-new-offer.component.css']
})
export class AdminAddNewOfferComponent implements OnInit {
  offerAdded:boolean=false;
  message:any;
  selectedFile: any;
  constructor(private service:UserService,private adminService:AdminService,private router: Router) { }

  ngOnInit(): void {
  }

  public onFileChanged(event) {
    console.log(event);
    this.selectedFile = event.target.files[0];
  }
  addNewOffer(myform){
    console.log(myform);
    this.adminService.addOfferWithImage(this.selectedFile,myform).subscribe(data => {
      console.log(data),
        // this.employee = new Employee();
        error => {
          this.message = "Offer already exits! Please recheck the details";
          console.log(error);
        }
    });
    this.router.navigate(['/manage-offer']);
  }
  addNewOffer2(myform){
    console.log(myform);
    this.adminService.addOfferWithImage2(this.selectedFile,myform).then(Response=>{
      console.log(Response);
      // this.router.navigate(['/login']);
      this.router.navigate(['/manage-offer']);
    }).catch(error=>{
      this.message="Offer already exits! Please recheck the details";
      console.log(error);

    });
    
    
    
    
    
    // subscribe(data => {
    //   console.log(data),
    //     // this.employee = new Employee();
    //     error => {
    //       this.message = 
    //       console.log(error);
    //     }
    // });
    
  }

}
