import { Component, Input } from '@angular/core';
import { IPet } from '../model/pet';

@Component({
  selector: 'app-pet-detail',
  templateUrl: './pet-detail.component.html',
  styleUrls: ['./pet-detail.component.scss']
})
export class PetDetailComponent {
  @Input() selectedPet : IPet | undefined | null;
}
