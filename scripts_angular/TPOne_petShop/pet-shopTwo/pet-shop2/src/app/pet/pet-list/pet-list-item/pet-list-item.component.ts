import { Component, Input } from '@angular/core';
import { IPet } from '../../model/pet';

@Component({
  selector: 'app-pet-list-item',
  templateUrl: './pet-list-item.component.html',
  styleUrls: ['./pet-list-item.component.scss']
})
export class PetListItemComponent {
  @Input() pett!: IPet;

  constructor(){}

  ngOnInit(): void {}
}
