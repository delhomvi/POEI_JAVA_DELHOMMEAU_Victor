import { Component, Input } from '@angular/core';
import { PetService } from 'src/app/pet.service';

import { IPet } from '../../model/pet';

@Component({
  selector: 'app-pet-list-item',
  templateUrl: './pet-list-item.component.html',
  styleUrls: ['./pet-list-item.component.scss'],
})
export class PetListItemComponent {
  @Input() pet!: IPet;

  get selectedPetId(): number {
    if (!this.petService.selectedPet) {
      return 0;
    }
    return this.petService.selectedPet.id;
  }

  constructor(private petService: PetService) {}
}
