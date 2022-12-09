import { Injectable } from '@angular/core';
import { IPet, Species } from './pet/model/pet';

@Injectable({
  providedIn: 'root'
})
export class PetService {
  pets: IPet[] = [];
  IDpet: number = 0 ;
  selectedPet: IPet | undefined | null=null;
  isSelected: boolean = false;
  isCreatingPet: boolean=false;


  constructor() { this.createPets(); }
  togglePetCreation(): void {
    this.isCreatingPet = !this.isCreatingPet;
  }

  onChangeSelectedPet(event: number){
    this.IDpet=event;
    this.selectedPet=this.pets.find((pet: IPet) => {return pet.id === event});
    this.isSelected=!this.isSelected;
    console.log(this.selectedPet);
  }

  private createPets(): void {
    const names: string[] = ['milou', 'garfield', 'nemo', 'bugs bunny','letchi le lapin calin', 'polux','mazoutte'];
    const species: Species[] = ['chien', 'chat', 'poisson', 'lapin','lapin','chien','cochon_d_inde'];
    const prices: number[] = [500, 400, 10, 50, 50,600,30];
    const imageUrls: string[] = ['https://cdn001.tintin.com/public/tintin/img/static/milou/milou_v3.png',
    'https://upload.wikimedia.org/wikipedia/en/thumb/b/bc/Garfield_the_Cat.svg/1200px-Garfield_the_Cat.svg.png',
    'https://easydrawingguides.com/wp-content/uploads/2017/05/How-to-Draw-Nemo-20.png',
    'https://img.src.ca/2015/07/27/1250x703/150727_co2q2_aetd_bugs-bunny_sn1250.jpg','https://www.lapins.info/wp-content/uploads/2018/12/Lionhead-Rabbit-Orange.jpg','','']

    for (let i = 0; i < names.length; i++) {
      const pet: IPet = {
        id: i + 1,
        name: names[i],
        species: species[i],
        price: prices[i],
        isAvailable: i % 2 === 0,
        imageUrl: imageUrls[i],
      };

      this.pets.push(pet);
    }
  }
}
