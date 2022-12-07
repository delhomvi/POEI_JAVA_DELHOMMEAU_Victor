import { Component, EventEmitter, Input, Output } from "@angular/core";

@Component({
  selector:'app-sport',
  templateUrl: './sport.component.html',
  styleUrls: ['./sport.component.scss']
})
export class SportComponent {
  @Input() sports: string[]=[];
  @Output() selectSport = new EventEmitter<string>()
  onSelectSport(sport: string): void{
    this.selectSport.emit(sport)
  }
}
