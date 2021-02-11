import { Injectable } from '@angular/core';
import { CanActivate, ActivatedRouteSnapshot, RouterStateSnapshot, UrlTree, Router } from '@angular/router';
import { Observable } from 'rxjs';

@Injectable({
  providedIn: 'root'
})
export class CustomerGuardGuard implements CanActivate {

  status: any;
  constructor(private router: Router) { }
  canActivate(
    route: ActivatedRouteSnapshot,
    state: RouterStateSnapshot): boolean {

    this.status = localStorage.getItem('customerLoggedInStatus');

    if (this.status == "true") {
      return true;
    } else {
      this.router.navigate(['login']);
    }
  }

}
