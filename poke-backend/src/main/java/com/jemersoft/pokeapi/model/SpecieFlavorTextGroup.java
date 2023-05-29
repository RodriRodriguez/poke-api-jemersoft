package com.jemersoft.pokeapi.model;

import java.util.List;

public class SpecieFlavorTextGroup {

    private List<SpeciesFlavorText> flavor_text_entries;

    public List<SpeciesFlavorText> getFlavor_text_entries() {
        return flavor_text_entries;
    }

    public void setFlavor_text_entries(List<SpeciesFlavorText> flavor_text_entries) {
        this.flavor_text_entries = flavor_text_entries;
    }
}
