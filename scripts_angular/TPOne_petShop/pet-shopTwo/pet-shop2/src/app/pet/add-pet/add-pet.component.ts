import { Component, OnInit } from '@angular/core';
import { FormBuilder, FormGroup, Validators } from '@angular/forms';
import { Species } from '../model/pet';

@Component({
  selector: 'app-add-pet',
  templateUrl: './add-pet.component.html',
  styleUrls: ['./add-pet.component.scss'],
})
export class AddPetComponent {
  species: Species[] = ['chien', 'chat', 'poisson', 'lapin'];

  petForm: FormGroup = this.fb.group({
    name: ['', [Validators.required, Validators.minLength(3)]],
    species: ['chien', Validators.required],
    price: [null, [Validators.required, Validators.min(0)]],
    isAvailable: [true, Validators.required],
    imageUrl: '',
  });

  constructor(private fb: FormBuilder) {}

  onSubmit() {
    console.log(this.petForm.value);
    console.log(this.petForm.valid);
  }
}
