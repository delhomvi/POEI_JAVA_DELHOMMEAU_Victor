import { Component,OnInit} from '@angular/core';
import { PetService } from 'src/app/pet.service';

@Component({
  selector: 'app-pet-list',
  templateUrl: './pet-list.component.html',
  styleUrls: ['./pet-list.component.scss']
})
export class PetListComponent implements OnInit{


  get petList(){return this.petService.pets}

  constructor(private petService: PetService){}

  ngOnInit(): void{}

  onClickPet(petID : number): void{
    this.petService.onChangeSelectedPet(petID);

  }
}
