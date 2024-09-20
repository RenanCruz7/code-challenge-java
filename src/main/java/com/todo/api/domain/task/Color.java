package com.todo.api.domain.task;

public enum Color {
    A99A7C("#A99A7C"),
    NDD6FF("#9DD6FF"),
    FFA285("#FFA285"),
    FFE8AC("#FFE8AC"),
    N79797("#979797"),
    F99494("#F99494");

    private final String hexCode;

    Color(String hexCode) {
        this.hexCode = hexCode;
    }

    public String getHexCode() {
        return hexCode;
    }
}