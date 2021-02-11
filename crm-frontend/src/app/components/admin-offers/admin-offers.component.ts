import { Component, OnInit } from '@angular/core';
import { ActivatedRoute, Router } from '@angular/router';
import { AdminService } from 'src/app/services/admin.service';
import { UserService } from 'src/app/services/user.service';

@Component({
  selector: 'app-admin-offers',
  templateUrl: './admin-offers.component.html',
  styleUrls: ['./admin-offers.component.css']
})
export class AdminOffersComponent implements OnInit {

  offersList: any;
  offersListKeys: any;

  totalRecords: Number;
  page: Number = 1;
  itemsPerPage: 10
  constructor(private service: UserService, private adminService: AdminService, private router: Router, private activatedRoute: ActivatedRoute) { }

  ngOnInit(): void {
    this.adminService.listAllOffers().subscribe(data => {
      this.offersList = data;
    });

    for (let key in this.offersList) {
      this.offersListKeys = key;
    }
  }


  removeOffer(value) {
    if (confirm("Press OK to confirm delete")) {
      console.log("In remove offer: " + value);
      this.adminService.deleteOffer(value).toPromise().then(() => {
        window.location.reload();
      })
    }
  }

  updateOfferDetails(offer) {

    console.log("In update offer: " + offer);
    this.router.navigate(['/admin-update-offer', offer]);
  }



}
