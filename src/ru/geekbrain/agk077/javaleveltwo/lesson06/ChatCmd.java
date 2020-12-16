package ru.geekbrain.agk077.javaleveltwo.lesson06;

public enum ChatCmd {
    END {
        @Override
        public String toString() {
            return "/close";
        }
    },

    CLEAR {
        @Override
        public String toString() {
            return "/clear";
        }
    }
}
