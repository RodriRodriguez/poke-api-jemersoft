package com.jemersoft.pokeapi.model;


public class FlavorTextEntries {
    private String flavor_text;
    private Language language;
    private VersionGroupAbility version_group;

    public String getFlavor_text() {
        return flavor_text;
    }

    public void setFlavor_text(String flavor_text) {
        this.flavor_text = flavor_text;
    }

    public Language getLanguage() {
        return language;
    }

    public void setLanguage(Language language) {
        this.language = language;
    }

    public VersionGroupAbility getVersion_group() {
        return version_group;
    }

    public void setVersion_group(VersionGroupAbility version_group) {
        this.version_group = version_group;
    }
}
