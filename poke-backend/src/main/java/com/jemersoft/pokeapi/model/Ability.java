package com.jemersoft.pokeapi.model;

public class Ability {
    private AbilityDetail ability;

    public Ability() {
    }

    public Ability(AbilityDetail ability) {
        this.ability = ability;
    }

    public AbilityDetail getAbility() {
        return ability;
    }

    public void setAbility(AbilityDetail ability) {
        this.ability = ability;
    }
}
