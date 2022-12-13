import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Router } from '@angular/router';
import { map } from 'rxjs';

import { IPet } from './model/pet';

@Injectable({
  providedIn: 'root',
})
export class PetService {
  private petsUrl =
    'https://formation-6e588-default-rtdb.europe-west1.firebasedatabase.app/pets.json';
  pets: IPet[] = [];
  selectedPet: IPet | undefined | null = null;

  constructor(private http: HttpClient, private router: Router) {
    this.getPets();
  }

  selectPet(petId: string): void {
    if (this.selectedPet?.id === petId) {
      this.selectedPet = null;
    } else {
      this.selectedPet = this.pets.find((pet) => pet.id === petId);
    }
  }

  createPet(petToCreate: any): void {
    this.http.post(this.petsUrl, petToCreate).subscribe(() => {
      this.getPets();
      this.router.navigate(['pet', 'index']);
    });
  }

  getPets(): void {
    this.http
      .get(this.petsUrl)
      .pipe(
        map((res: any) => {
          const pets: IPet[] = [];

          for (const key in res) {
            const pet: IPet = {
              id: key,
              // ...res[key],
              name: res[key].name,
              isAvailable: res[key].isAvailable,
              imageUrl: res[key].imageUrl,
              price: res[key].price,
              species: res[key].species,
            };
            pets.push(pet);
          }

          return pets;
        })
      )
      .subscribe((res: IPet[]) => {
        this.pets = res;
      });
  }
}
