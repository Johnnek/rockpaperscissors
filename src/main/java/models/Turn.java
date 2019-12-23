package models;

import org.codehaus.jackson.annotate.JsonValue;

import java.util.HashMap;
import java.util.Map;

public enum Turn {
    ROCK, PAPER, SCISSOR;

    private static Map<String, Turn> turnMap = new HashMap<String, Turn>();

    static {
        turnMap.put("Rock", ROCK);
        turnMap.put("Paper", PAPER);
        turnMap.put("Scissor", SCISSOR);
    }

    @JsonValue
    public String toValue() {
        for (Map.Entry<String, Turn> entry : turnMap.entrySet()) {
            if (entry.getValue() == this) {
                return entry.getKey();
            }
        }
        return null;
    }
}
