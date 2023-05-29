package com.jemersoft.pokeapi.model;

import java.util.List;

public class Moves {

    private Move move;

    private List<VersionGroupDetail> version_group_details;


    public Move getMove() {
        return move;
    }

    public void setMove(Move move) {
        this.move = move;
    }

    public List<VersionGroupDetail> getVersion_group_details() {
        return version_group_details;
    }

    public void setVersionGroupDetails(List<VersionGroupDetail> version_group_details) {
        this.version_group_details = version_group_details;
    }
}

