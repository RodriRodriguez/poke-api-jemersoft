package com.jemersoft.pokeapi.model;

import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.List;

public class PokemonMoves {
    private List<Move> moves;

    public List<Move> getMoves() {
        return moves;
    }

    public void setMoves(List<Move> moves) {
        this.moves = moves;
    }

    public static class Move {
        private MoveInfo move;

        public MoveInfo getMove() {
            return move;
        }

        public void setMove(MoveInfo move) {
            this.move = move;
        }
    }

    public static class MoveInfo {
        private String name;

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }
    }
}
