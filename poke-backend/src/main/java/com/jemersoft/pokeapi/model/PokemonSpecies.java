package com.jemersoft.pokeapi.model;

import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.List;

public class PokemonSpecies {
    private List<FlavorTextEntry> flavorTextEntries;

    public List<FlavorTextEntry> getFlavorTextEntries() {
        return flavorTextEntries;
    }

    public void setFlavorTextEntries(List<FlavorTextEntry> flavorTextEntries) {
        this.flavorTextEntries = flavorTextEntries;
    }

    public static class FlavorTextEntry {
        private String flavorText;
        private Language language;

        @JsonProperty("flavor_text")
        public String getFlavorText() {
            return flavorText;
        }

        public void setFlavorText(String flavorText) {
            this.flavorText = flavorText;
        }

        public Language getLanguage() {
            return language;
        }

        public void setLanguage(Language language) {
            this.language = language;
        }
    }

    public static class Language {
        private String name;

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }
    }
}

