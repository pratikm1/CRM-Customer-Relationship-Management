import { NgModule } from '@angular/core';
import { Routes, RouterModule } from '@angular/router';
import { AppComponent } from './app.component';
import { CommonLandingPageComponent } from './common-landing-page/common-landing-page.component';
import { AdminAddNewCustomerComponent } from './components/admin-add-new-customer/admin-add-new-customer.component';
import { AdminAddNewOfferComponent } from './components/admin-add-new-offer/admin-add-new-offer.component';
import { AdminAddVehicleComponent } from './components/admin-add-vehicle/admin-add-vehicle.component';
import { AdminCustomerListComponent } from './components/admin-customer-list/admin-customer-list.component';
import { AdminCustomerUpdateComponent } from './components/admin-customer-update/admin-customer-update.component';
import { AdminHomeComponent } from './components/admin-home/admin-home.component';
import { AdminOffersComponent } from './components/admin-offers/admin-offers.component';
import { AdminUpdateOfferComponent } from './components/admin-update-offer/admin-update-offer.component';
import { AdminVehicleUpdateComponent } from './components/admin-vehicle-update/admin-vehicle-update.component';
import { AdminVehicleComponent } from './components/admin-vehicle/admin-vehicle.component';
import { BookVehicleComponent } from './components/book-vehicle/book-vehicle.component';
import { ComplaintComponent } from './components/complaint/complaint.component';
import { CustomerHomeComponent } from './components/customer-home/customer-home.component';
import { GetQuotationComponent } from './components/get-quotation/get-quotation.component';
import { LoginComponent } from './components/login/login.component';
import { NavbarComponent } from './components/navbar/navbar.component';
import { RegisterComponent } from './components/register/register.component';
import { TestRideComponent } from './components/test-ride/test-ride.component';
import { AdminGuardGuard } from './guards/admin-guard.guard';
import { CustomerGuardGuard } from './guards/customer-guard.guard';
import { PageNotFoundComponent } from './page-not-found/page-not-found.component';

const routes: Routes = [

  {path:"",component:CommonLandingPageComponent},
  {path:"login",component:LoginComponent},

//Customer Paths

  {path:"register",component:RegisterComponent},
  {path:"customer-home",component:CustomerHomeComponent,canActivate:[CustomerGuardGuard]},
  {path:"test-ride",component:TestRideComponent,canActivate:[CustomerGuardGuard]},
  {path:"book-vehicle",component:BookVehicleComponent,canActivate:[CustomerGuardGuard]},
  {path:"register-complaint",component:ComplaintComponent,canActivate:[CustomerGuardGuard]},
  {path:"get-quote",component:GetQuotationComponent},
  {path:"nav-bar",component:NavbarComponent},
  // {path:"**",component:PageNotFoundComponent},


//Admin Paths

  {path:'admin-home',component:AdminHomeComponent,canActivate:[AdminGuardGuard]},
    // children :[
    //   {path:'manage-vehicles',component:AdminVehicleComponent,pathMatch:'full'}
    // ]},
  {path:"manage-vehicles",component:AdminVehicleComponent,canActivate:[AdminGuardGuard]},
  {path:"admin-add-new-vehicle",component:AdminAddVehicleComponent,canActivate:[AdminGuardGuard]},
  {path:"manage-offer",component:AdminOffersComponent,canActivate:[AdminGuardGuard]},
  {path:"admin-add-new-offer",component:AdminAddNewOfferComponent,canActivate:[AdminGuardGuard]},
  {path:"admin-add-new-customer",component:AdminAddNewCustomerComponent,canActivate:[AdminGuardGuard]},
  {path:"customers",component:AdminCustomerListComponent,canActivate:[AdminGuardGuard]},
  {path:"admin-update-vehicle",component:AdminVehicleUpdateComponent,canActivate:[AdminGuardGuard]},
  {path:"admin-update-offer",component:AdminUpdateOfferComponent,canActivate:[AdminGuardGuard]},
  {path:"update-customer",component:AdminCustomerUpdateComponent,canActivate:[AdminGuardGuard]}
];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }
