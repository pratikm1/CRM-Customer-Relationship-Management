import { BrowserModule } from '@angular/platform-browser';
import { NgModule } from '@angular/core';
import { NgImageSliderModule } from 'ng-image-slider';
import { BrowserAnimationsModule } from '@angular/platform-browser/animations';
import { FormsModule } from '@angular/forms';
import { HttpClientModule } from '@angular/common/http';
import { NgxPaginationModule } from 'ngx-pagination';

import { AppRoutingModule } from './app-routing.module';
import { AppComponent } from './app.component';
import { LoginComponent } from './components/login/login.component';
import { RegisterComponent } from './components/register/register.component';
import { HomeSliderComponent } from './components/home-slider/home-slider.component';
import { NavbarComponent } from './components/navbar/navbar.component';
import { FooterComponent } from './components/footer/footer.component';
import { CustomerHomeComponent } from './components/customer-home/customer-home.component';
import { AdminHomeComponent } from './components/admin-home/admin-home.component';
import { TestRideComponent } from './components/test-ride/test-ride.component';
import { BookVehicleComponent } from './components/book-vehicle/book-vehicle.component';
import { ComplaintComponent } from './components/complaint/complaint.component';
import { AdminVehicleComponent } from './components/admin-vehicle/admin-vehicle.component';
import { AdminAddVehicleComponent } from './components/admin-add-vehicle/admin-add-vehicle.component';
import { AdminOffersComponent } from './components/admin-offers/admin-offers.component';
import { AdminAddNewOfferComponent } from './components/admin-add-new-offer/admin-add-new-offer.component';
import { AdminCustomerListComponent } from './components/admin-customer-list/admin-customer-list.component';
import { AdminAddNewCustomerComponent } from './components/admin-add-new-customer/admin-add-new-customer.component';
import { AdminVehicleUpdateComponent } from './components/admin-vehicle-update/admin-vehicle-update.component';
import { AdminUpdateOfferComponent } from './components/admin-update-offer/admin-update-offer.component';
import { CommonLandingPageComponent } from './common-landing-page/common-landing-page.component';
import { AdminCustomerUpdateComponent } from './components/admin-customer-update/admin-customer-update.component';
import { GetQuotationComponent } from './components/get-quotation/get-quotation.component';
import { PageNotFoundComponent } from './page-not-found/page-not-found.component';





@NgModule({
  declarations: [
    AppComponent,
    LoginComponent,
    RegisterComponent,
    HomeSliderComponent,
    NavbarComponent,
    FooterComponent,
    CustomerHomeComponent,
    AdminHomeComponent,
    TestRideComponent,
    BookVehicleComponent,
    ComplaintComponent,
    AdminVehicleComponent,
    AdminAddVehicleComponent,
    AdminOffersComponent,
    AdminAddNewOfferComponent,
    AdminCustomerListComponent,
    AdminAddNewCustomerComponent,
    AdminVehicleUpdateComponent,
    AdminUpdateOfferComponent,
    CommonLandingPageComponent,
    AdminCustomerUpdateComponent,
    GetQuotationComponent,
    PageNotFoundComponent
  ],
  imports: [
    BrowserModule,
    AppRoutingModule,
    FormsModule,
    BrowserAnimationsModule,
    NgImageSliderModule,
    HttpClientModule,
    NgxPaginationModule
  ],
  providers: [],
  bootstrap: [AppComponent]
})
export class AppModule { }
