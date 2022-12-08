import { NgModule } from '@angular/core';
import { BrowserModule } from '@angular/platform-browser';

import { AppRoutingModule } from './app-routing.module';
import { AppComponent } from './app.component';
import { NavbarComponent } from './navbar/navbar.component';
import { PetComponent } from './pet/pet.component';
import { PetListComponent } from './pet/pet-list/pet-list.component';
import { PetDetailComponent } from './pet/pet-detail/pet-detail.component';

@NgModule({
  declarations: [
    AppComponent,
    PetComponent,
    NavbarComponent,
    PetListComponent,
    PetDetailComponent
  ],
  imports: [
    BrowserModule,
    AppRoutingModule
  ],
  providers: [],
  bootstrap: [AppComponent]
})
export class AppModule { }
