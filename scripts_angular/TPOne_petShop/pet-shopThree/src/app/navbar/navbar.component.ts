import { Component } from '@angular/core';

import { AuthService } from '../auth/auth.service';

@Component({
  selector: 'app-navbar',
  templateUrl: './navbar.component.html',
  styleUrls: ['./navbar.component.scss'],
})
export class NavbarComponent {
  get isAuth(): boolean {
    return this.authService.isAuth;
  }

  constructor(private authService: AuthService) {}

  onToggleAuth() {
    this.authService.toggleAuth();
  }
}
