
import { NgModule } from '@angular/core';
import { BrowserModule } from '@angular/platform-browser';

import { AppComponent } from './app.component';
import { PetComponent } from './pet/pet.component';
import { PetListComponent } from './pet/pet-list/pet-list.component';
import { PetDetailComponent } from './pet/pet-detail/pet-detail.component';
import { PetListItemComponent } from './pet/pet-list/pet-list-item/pet-list-item.component';
import { NavbarComponent } from './navbar/navbar.component';
import { AddPetComponent } from './pet/add-pet/add-pet.component';
import { ReactiveFormsModule } from '@angular/forms';

@NgModule({
  declarations: [AppComponent, PetComponent, PetListComponent, PetDetailComponent, PetListItemComponent, NavbarComponent, AddPetComponent],
  imports: [BrowserModule,ReactiveFormsModule],
  providers: [],
  bootstrap: [AppComponent],
})
export class AppModule {}
