import { Component, OnInit } from '@angular/core';
import { PokemonService } from '../../services/pokemon.service';
import { PokemonDetail } from '../../models/pokemon.model';
import { ActivatedRoute } from '@angular/router';
import { SpinnerService } from 'src/app/services/spinner.service';

@Component({
  selector: 'app-result',
  templateUrl: './result.component.html',
  styleUrls: ['./result.component.css']
})
export class ResultComponent implements OnInit {

  constructor(private pokemonService: PokemonService,
    private route: ActivatedRoute, private spinnerService: SpinnerService) { }

  pokemonDetail: PokemonDetail[] | any;
  pokemonId: number | undefined;
  alert: any;

  ngOnInit(): void {
    this.alert = false;
    this.route.paramMap.subscribe(params => {
      const id = params.get('id');
      if (id) {
        this.getPokemonDetail(+id);
      }
    }, error => {
      this.alert = true;
    });
  }

  getPokemonDetail(id: number): void {
    this.spinnerService.show();
    this.pokemonService.getPokemonById(id)
      .subscribe((detail: PokemonDetail) => {
        this.pokemonDetail = [detail];
        
        // Acceder a los nombres de las habilidades
        for (const ability of this.pokemonDetail[0].abilities) {
          const abilityName = ability.ability.name;
          console.log(abilityName);
          // Realiza las operaciones que necesites con el nombre de la habilidad
        }
        
        this.spinnerService.hide();
      }, error => {
        this.alert = true;
        this.spinnerService.hide();
      });
  }
  

}
