package com.jemersoft.pokeapi.model;

import java.util.List;

public class VersionGroupDetail {
    private int levelLearnedAt;
    private MoveLearnMethod move_learn_method;
    private VersionGroup version_group;

    public VersionGroupDetail() {
        // Constructor sin argumentos
    }

    public int getLevelLearnedAt() {
        return levelLearnedAt;
    }

    public void setLevelLearnedAt(int levelLearnedAt) {
        this.levelLearnedAt = levelLearnedAt;
    }

    public MoveLearnMethod getMove_learn_method() {
        return move_learn_method;
    }

    public MoveLearnMethod setMove_learn_method(MoveLearnMethod move_learn_method) {
        this.move_learn_method = move_learn_method;
        return move_learn_method;
    }

    public VersionGroup getVersion_group() {
        return version_group;
    }

    public void setVersion_group(VersionGroup version_group) {
        this.version_group = version_group;
    }
}

