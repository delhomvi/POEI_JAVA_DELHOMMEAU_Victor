import { Component, EventEmitter, Input, Output } from '@angular/core';
import { IPet } from '../model/pet';

@Component({
  selector: 'app-pet-list',
  templateUrl: './pet-list.component.html',
  styleUrls: ['./pet-list.component.scss']
})
export class PetListComponent {
  @Input() petList : IPet[] = [];
  @Output() idSelected = new EventEmitter<number>();

  constructor(){}

  ngOnInit(): void{
  }

  onClickPet(petID : number): void{
    this.idSelected.emit(petID);
  }
}
