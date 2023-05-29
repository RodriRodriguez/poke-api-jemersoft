package com.jemersoft.pokeapi.model;

import java.util.List;

public class Pokemon {
    private String name;
    private String url;

    public Pokemon() {
    }

    public Pokemon(String name, String url, String photoUrl, List<Type> types, int weight, List<Ability> abilities) {
        this.name = name;
        this.url = url;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

}
