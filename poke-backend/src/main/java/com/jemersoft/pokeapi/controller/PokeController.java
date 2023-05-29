package com.jemersoft.pokeapi.controller;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.jemersoft.pokeapi.model.*;
import com.jemersoft.pokeapi.response.PokemonApiResponse;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.HttpMethod;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import java.util.ArrayList;
import java.util.List;

@CrossOrigin
@RestController
public class PokeController {

    @Value("${pokemon.url}")
    private String pokemonUrl;

    @Value("${pokemon.details.url}")
    private String pokemonDetailsUrl;

    @Value("${pokemon.ability.url}")
    private String pokemonAbilityUrl;

    @GetMapping("/pokemon")
    public ResponseEntity<List<Pokemon>> getPokemons() {
        RestTemplate restTemplate = new RestTemplate();
        String apiUrl = "https://pokeapi.co/api/v2/pokemon";

        ResponseEntity<String> response = restTemplate.getForEntity(apiUrl, String.class);

        ObjectMapper objectMapper = new ObjectMapper();
        List<Pokemon> pokemons = null;

        try {
            PokemonApiResponse pokemonApiResponse = objectMapper.readValue(response.getBody(), PokemonApiResponse.class);
            pokemons = pokemonApiResponse.getResults();
        } catch (Exception e) {
            e.printStackTrace();
        }

        if (pokemons != null) {
            return ResponseEntity.ok(pokemons);
        } else {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
        }
    }

    @GetMapping("pokemon/{id}")
    public ResponseEntity<PokemonDetails> getPorId(@PathVariable("id") int id) {
        RestTemplate restTemplate = new RestTemplate();
        String apiUrl = "https://pokeapi.co/api/v2/pokemon/" + id;

        ResponseEntity<PokemonDetails> response = restTemplate.getForEntity(apiUrl, PokemonDetails.class);
        PokemonDetails pokemonDetails = response.getBody();

        if (pokemonDetails != null) {
            String imageUrl = "https://raw.githubusercontent.com/PokeAPI/sprites/master/sprites/pokemon/other/official-artwork/" + id + ".png";
            pokemonDetails.setPhotoUrl(imageUrl);

            // Obtener descripción en español
            String speciesUrl = "https://pokeapi.co/api/v2/pokemon-species/" + id;
            ResponseEntity<PokemonSpecies> speciesResponse = restTemplate.getForEntity(speciesUrl, PokemonSpecies.class);
            PokemonSpecies pokemonSpecies = speciesResponse.getBody();

            //if (pokemonSpecies != null) {
            // Obtener el nombre de la especie
            //String speciesName = pokemonSpecies.getName();
            // Crear un objeto Species con el nombre de la especie y la URL de la especie
            //Species species = new Species(speciesName, speciesUrl);
            // Establecer la especie en el objeto PokemonDetails
            //pokemonDetails.setSpecies(species);
            //}

            // Obtener lista de movimientos
            String movesUrl = "https://pokeapi.co/api/v2/pokemon/" + id;
            ResponseEntity<PokemonMoves> movesResponse = restTemplate.getForEntity(movesUrl, PokemonMoves.class);
            PokemonMoves pokemonMoves = movesResponse.getBody();

            if (pokemonMoves != null) {
                List<PokemonMoves.Move> moves = pokemonMoves.getMoves();
                List<String> moveNames = new ArrayList<>();
                for (PokemonMoves.Move move : moves) {
                    moveNames.add(move.getMove().getName());
                }
                //pokemonDetails.setMoves(moveNames);
            }

            return ResponseEntity.ok(pokemonDetails);
        } else {
            return ResponseEntity.notFound().build();
        }
    }


    @GetMapping("/ability/{id}")
    public FlavorTextEntriesGroup getPokemonAbility(@PathVariable("id") int id) {
        RestTemplate restTemplate = new RestTemplate();
        String url = pokemonAbilityUrl.replace("{id}", String.valueOf(id));
        FlavorTextEntriesGroup entriesGroup = restTemplate.getForObject(url, FlavorTextEntriesGroup.class);

        if (entriesGroup != null) {
            List<FlavorTextEntries> entries = entriesGroup.getFlavor_text_entries();
            entries.removeIf(entry -> !entry.getLanguage().getName().equals("es"));
        }

        return entriesGroup;
    }

    @GetMapping("/pokemon-species/{id}")
    public SpecieFlavorTextGroup getPokemonSpecies(@PathVariable("id") int id) {
        RestTemplate restTemplate = new RestTemplate();
        String url = pokemonAbilityUrl.replace("{id}", String.valueOf(id));
        SpecieFlavorTextGroup specieFlavorTextGroup = restTemplate.getForObject(url, SpecieFlavorTextGroup.class);

        if (specieFlavorTextGroup != null) {
            List<SpeciesFlavorText> entries = specieFlavorTextGroup.getFlavor_text_entries();
            entries.removeIf(entry -> !entry.getLanguage().getName().equals("es"));
        }

        return specieFlavorTextGroup;
    }

}


