package com.example.wordscramble;

import java.util.HashMap;
import java.util.Map;

public enum Difficulties {
    EASY(1),
    MEDIUM(2),
    HARD(3);

    private final int value;
    private static final Map<Integer, Difficulties> map = new HashMap<>();

    private Difficulties(int value) { this.value = value; }

    static {
        for (Difficulties diff : Difficulties.values())
            map.put(diff.value, diff);
    }

    public static Difficulties valueOf(int pageType) {
        return (Difficulties) map.get(pageType);
    }

    public int getValue() {
        return value;
    }

    @Override
    public String toString() {
        StringBuilder builder = new StringBuilder();
        builder.append("\t- Type ").append(value).append(" for : ").append(super.toString());

        return builder.toString();
    }
}
