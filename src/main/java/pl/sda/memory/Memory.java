package pl.sda.memory;

import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public abstract class Memory {
    private Map<String, String> memory;

    public Memory() {
        this.memory = new HashMap<>();
    }


    public String put(String key, String value) {
        if (this.memory.containsKey(key)) {
            return this.memory.replace(key, value);
        } else {
            return this.memory.put(key, value);
        }
    }

    public String get(String key) {
        return this.memory.get(key);
    }

    public List<String> addresses() {
        return this.memory.keySet().stream()
                .sorted((String::compareTo))
                .collect(Collectors.toList());
    }


}
