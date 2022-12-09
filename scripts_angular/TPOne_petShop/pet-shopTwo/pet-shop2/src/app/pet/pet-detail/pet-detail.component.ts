import { Component, Input } from '@angular/core';
import { PetService } from 'src/app/pet.service';
import { IPet } from '../model/pet';

@Component({
  selector: 'app-pet-detail',
  templateUrl: './pet-detail.component.html',
  styleUrls: ['./pet-detail.component.scss']
})
export class PetDetailComponent {

  constructor(private petService: PetService){}

  ngOnInit(): void{}

  get pet(){return this.petService.selectedPet}

}
