import { Component } from '@angular/core';
import { IMovie } from './movie';
import { MovieService } from './movie.service';

@Component({
  selector: 'app-root',
  templateUrl: './app.component.html',
  styleUrls: ['./app.component.scss']
})
export class AppComponent {
  get movies(): IMovie[]{
    return this.movieService.movies
  }
  constructor(private movieService: MovieService){}
  onAddMovie(title: string){this.movieService.addMovie(title)}
}
