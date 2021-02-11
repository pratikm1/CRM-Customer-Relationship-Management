import { Component, OnInit } from '@angular/core';
import { Router } from '@angular/router';
import { UserService } from 'src/app/services/user.service';

@Component({
  selector: 'app-complaint',
  templateUrl: './complaint.component.html',
  styleUrls: ['./complaint.component.css']
})
export class ComplaintComponent implements OnInit {
  complaintRegistration = false;
  constructor(private service: UserService, private router: Router) { }

  ngOnInit(): void {
  }
  postComplaint(myform) {
 
    var userId = localStorage.getItem("loggedInUserId");
    let temp = {
      "comapliantTitle": myform.comapliantTitle,
      "complaintDesc": myform.complaintDesc,
      "customerComplaint":
      {
        "userId": userId
      }
    }
    this.service.registerComplaint(temp).then(()=>{
      this.complaintRegistration=true;

    });
  }
}
