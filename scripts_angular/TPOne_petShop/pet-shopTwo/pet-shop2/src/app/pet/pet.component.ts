import { Component } from '@angular/core';
import { PetService } from '../pet.service';


@Component({
  selector: 'app-pet',
  templateUrl: './pet.component.html',
  styleUrls: ['./pet.component.scss'],
})
export class PetComponent {
  get isCreatingPet(): boolean {
    return this.petService.isCreatingPet;
  }

  constructor(private petService: PetService) {}
}
