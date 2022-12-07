import { Component } from '@angular/core';

@Component({
  selector: 'app-root',
  templateUrl: './app.component.html',
  styleUrls: ['./app.component.scss']
})
export class AppComponent {
  favoritePet: String = 'Dogs';
  onChange(): void { this.favoritePet = 'cats';}

}
