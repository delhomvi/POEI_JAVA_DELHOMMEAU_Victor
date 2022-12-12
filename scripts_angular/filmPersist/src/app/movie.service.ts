import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { IMovie } from './movie';

@Injectable({
  providedIn: 'root'
})
export class MovieService {
  private movieUrl: string = ''
  movies: IMovie[] = [];
  constructor(private http: HttpClient) {
  }

  postMovie(movieTitle:string){
    this.http.post(this.movieUrl , {title : movieTitle})
    .subscribe((res) =>{console.log(res)})
    ;
  }

  addMovie(title:string){
    const movie: IMovie={id:'toto',title:title};
    this.movies.push(movie);
  }
}
