import { Component, OnInit } from '@angular/core';

import { IPet, Species } from './model/pet';

@Component({
  selector: 'app-pet',
  templateUrl: './pet.component.html',
  styleUrls: ['./pet.component.scss'],
})
export class PetComponent implements OnInit {
  pets: IPet[] = [];
  IDpet: number = 0 ;
  selectedPet: IPet | undefined | null=null;

  ngOnInit(): void {
    this.createPets();
  }

  onChangeSelectedPet(event: number){
    this.IDpet=event;
    this.selectedPet=this.pets.find((pet: IPet) => {return pet.id === event});
    console.log(this.selectedPet);
  }

  private createPets(): void {
    const names: string[] = ['milou', 'garfield', 'nemo', 'bugs bunny','letchi le lapin calin', 'polux','mazoutte'];
    const species: Species[] = ['chien', 'chat', 'poisson', 'lapin','lapin','chien','cochon_d_inde'];
    const prices: number[] = [500, 400, 10, 50, 50,600,30];

    for (let i = 0; i < names.length; i++) {
      const pet: IPet = {
        id: i + 1,
        name: names[i],
        species: species[i],
        price: prices[i],
        isAvailable: i % 2 === 0,
      };

      this.pets.push(pet);
    }
  }
}
