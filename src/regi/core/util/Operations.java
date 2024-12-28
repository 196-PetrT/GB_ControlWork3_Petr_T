package regi.core.util;

public enum Operations {
    LIST("l"),ADD("a"),DELETE("d"),UPDATE("u"),COMMANDS("c"),LEARN("n");

    private final String operation;

    Operations(String operation) {
        this.operation = operation;
    }
    public String getOperation() {
        return operation;
    }
}
