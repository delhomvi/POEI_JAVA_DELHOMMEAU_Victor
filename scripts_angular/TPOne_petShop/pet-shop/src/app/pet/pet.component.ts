import { Component } from '@angular/core';
import { IPet } from './model/pet'

@Component({
  selector: 'app-pet',
  templateUrl: './pet.component.html',
  styleUrls: ['./pet.component.scss']
})
export class PetComponent {
  pets : IPet[] = [];

  constructor(){}

  ngOnInit(): void{
  }

  createPets(): void {
    this.pets=[
      {id:1,name:'Milou',species:'chien',price:500,isAvailable:true},
      {id:2,name:'Garfiel',species:'chat',price:400,isAvailable:true},
      {id:3,name:'Nemo',species:'poisson',price:10,isAvailable:true},
      {id:4,name:'BugsBunny',species:'lapin',price:50,isAvailable:true},
    ]
  }
}
