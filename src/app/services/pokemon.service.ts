import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Observable, take } from 'rxjs';
import { map } from 'rxjs/operators';
import { environment } from "../../environments/environment";
import * as url from "url";
import { Pokemon, PokemonDetail } from '../models/pokemon.model';


@Injectable({
    providedIn: 'root'
})
export class PokemonService {
    constructor(private http: HttpClient) { }

    getPokemons(): Observable<Pokemon[]> {
        return this.http.get<Pokemon[]>(environment.url + '/pokemon');
    }

    getPokemonById(id: number): Observable<PokemonDetail> {
        const url = `${environment.url}/pokemon/${id}`;
        return this.http.get<PokemonDetail>(url);
      }
      

}