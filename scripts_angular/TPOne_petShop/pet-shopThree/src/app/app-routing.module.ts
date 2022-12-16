import { NgModule } from '@angular/core';
import { RouterModule, Routes } from '@angular/router';
import { AuthGuard } from './auth/auth.guard';
import { ConfirmBeforeLeavingGuard } from './confirm-before-leaving.guard';

import { HomeComponent } from './home/home.component';
import { AddPetComponent } from './pet/add-pet/add-pet.component';
import { PetDetailComponent } from './pet/pet-index/pet-detail/pet-detail.component';
import { PetIndexComponent } from './pet/pet-index/pet-index.component';
import { PetComponent } from './pet/pet.component';

const routes: Routes = [
  { path: 'home', component: HomeComponent },
  {
    path: 'pet',
    component: PetComponent,
    canActivate: [AuthGuard],
    children: [
      {
        path: 'index',
        component: PetIndexComponent,
        children: [{ path: ':id', component: PetDetailComponent }],
      },
      {
        path: 'add',
        component: AddPetComponent,
        canDeactivate: [ConfirmBeforeLeavingGuard],
      },
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
