package com.jemersoft.pokeapi.model;

import java.util.List;

public class PokemonDetails {

    private String photoUrl;
    private int weight;
    private List<Ability> abilities;
    private List<Types> types;
    private String description;
    private Species species;

    private List<Moves> moves;


    public PokemonDetails() {
        // Constructor sin argumentos
    }

    public PokemonDetails(String photoUrl, List<Types> types, int weight, List<Ability> abilities, String description, Species species, List<Moves> moves) {
        this.photoUrl = photoUrl;
        this.types = types;
        this.weight = weight;
        this.abilities = abilities;
        this.description = description;
        this.species = species;
        this.moves = moves;
    }



    public String getPhotoUrl() {
        return photoUrl;
    }

    public void setPhotoUrl(String photoUrl) {
        this.photoUrl = photoUrl;
    }

    public List<Types> getTypes() {
        return types;
    }

    public void setTypes(List<Types> types) {
        this.types = types;
    }

    public int getWeight() {
        return weight;
    }

    public void setWeight(int weight) {
        this.weight = weight;
    }

    public List<Ability> getAbilities() {
        return abilities;
    }

    public void setAbilities(List<Ability> abilities) {
        this.abilities = abilities;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Species getSpecies() {
        return species;
    }

    public void setSpecies(Species species) {
        this.species = species;
    }

    public List<Moves> getMoves() {
        return moves;
    }

    public void setMoves(List<Moves> moves) {
        this.moves = moves;
    }

}
