import { NgModule } from '@angular/core';
import { BrowserModule } from '@angular/platform-browser';

import { AppComponent } from './app.component';
import { SportComponent } from './sport/sport.component';
import { UserComponent } from './user/user.component';

@NgModule({
  declarations: [AppComponent,SportComponent, UserComponent],
  imports: [BrowserModule],
  providers: [],
  bootstrap: [AppComponent]
})
export class AppModule{}


