import { Component, OnInit } from '@angular/core';
import { Router } from '@angular/router';
import { delay } from 'rxjs';
import { Pokemon } from 'src/app/models/pokemon.model';
import { PokemonService } from 'src/app/services/pokemon.service';
import { SpinnerService } from 'src/app/services/spinner.service';


@Component({
  selector: 'app-start',
  templateUrl: './start.component.html',
  styleUrls: ['./start.component.css']
})
export class StartComponent implements OnInit {

  constructor(private pokeApiService: PokemonService,
    private router: Router, private spinnerService: SpinnerService) { }

  pokemons: Pokemon[] | undefined;
  searchText: any;
  pokemonId: number | undefined;
  alert: any;

  ngOnInit(): void {
    this.getPokemons();
    this.alert = false;
  }

  buscarPokemon(): void {
    if (!this.pokemonId) {
      return;
    }
    const id = this.pokemonId;
    this.router.navigate(['/result', this.pokemonId]);
  }

  redirectToResult(item: Pokemon): void {
    // Extraer el ID del Pokémon de la URL
    const parts = item.url.split('/');
    const pokemonId = parts[parts.length - 2];

    // Redirigir a la ruta result con el ID del Pokémon como parámetro
    this.router.navigate(['/result', pokemonId]);
  }


  getPokemons(): void {
    this.spinnerService.show();
  
    this.pokeApiService.getPokemons().pipe(
      delay(3000)
    ).subscribe(pokemons => {
      this.pokemons = pokemons.map(pokemon => {
        const pokemonId = this.extractPokemonId(pokemon.url);
        const photoUrl = `https://raw.githubusercontent.com/PokeAPI/sprites/master/sprites/pokemon/other/official-artwork/${pokemonId}.png`;
        return { ...pokemon, photoUrl };
      });
      console.log(this.pokemons);
  
      this.spinnerService.hide(); 
    }, error => {
      this.alert = true;
      this.spinnerService.hide(); 
    });
  }

  private extractPokemonId(url: string): string {
    const parts = url.split('/');
    return parts[parts.length - 2];
  }
}
