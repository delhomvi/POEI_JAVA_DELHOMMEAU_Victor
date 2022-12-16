import { Component, OnDestroy, OnInit } from '@angular/core';
import { ActivatedRoute } from '@angular/router';
import { Subscription } from 'rxjs';

import { IPet } from '../../model/pet';
import { PetService } from '../../pet.service';

@Component({
  selector: 'app-pet-detail',
  templateUrl: './pet-detail.component.html',
  styleUrls: ['./pet-detail.component.scss'],
})
export class PetDetailComponent implements OnInit, OnDestroy {
  private subs: Subscription[] = [];
  pet: IPet | null = null;

  constructor(private petService: PetService, private route: ActivatedRoute) {}

  ngOnInit(): void {
    this.subs.push(
      this.petService.petsReady$.subscribe(() => {
        this.pet = this.petService.petWithId(this.route.snapshot.params['id']);
      }),
      this.route.params.subscribe((p: any) => {
        this.pet = this.petService.petWithId(p.id);
      })
    );
  }

  ngOnDestroy(): void {
    for (const sub of this.subs) {
      sub.unsubscribe();
    }
  }
}
