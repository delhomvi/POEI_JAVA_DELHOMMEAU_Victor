import { NgModule } from '@angular/core';
import { RouterModule, Routes } from '@angular/router';

import { HomeComponent } from './home/home.component';
import { AddPetComponent } from './pet/add-pet/add-pet.component';
import { PetIndexComponent } from './pet/pet-index/pet-index.component';
import { PetComponent } from './pet/pet.component';

const routes: Routes = [
  { path: 'home', component: HomeComponent },
  {
    path: 'pet',
    component: PetComponent,
    children: [
      { path: 'index', component: PetIndexComponent },
      { path: 'add', component: AddPetComponent },
      { path: '', pathMatch: 'full', redirectTo: 'index' },
      { path: '**', redirectTo: 'index' },
    ],
  },
  { path: '', pathMatch: 'full', redirectTo: 'home' },
  { path: '**', redirectTo: 'home' },
];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule],
})
export class AppRoutingModule {}
