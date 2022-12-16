import { Injectable } from '@angular/core';
import { Router } from '@angular/router';

@Injectable({
  providedIn: 'root',
})
export class AuthService {
  isAuth: boolean = false;

  constructor(private router: Router) {}

  toggleAuth() {
    this.isAuth = !this.isAuth;
    if (!this.isAuth) {
      this.router.navigate(['home']);
    }
  }
}
