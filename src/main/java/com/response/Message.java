package com.response;

import com.fasterxml.jackson.annotation.JsonAutoDetect;
import lombok.Data;
import lombok.extern.slf4j.Slf4j;
import org.json.JSONException;

import java.util.HashMap;
import java.util.Map;
import java.util.Set;

@Data
@JsonAutoDetect(fieldVisibility = JsonAutoDetect.Visibility.ANY)
@Slf4j
public class Message {
    private Map<String, Object> map;

    public Message() {
        this.map = new HashMap<>();
    }

    public <T> Message put(String key, T object) {
        map.put(key, object);
        return this;
    }

    public <T> boolean pop(String key) {
        Set<String> set = map.keySet();
        for (Object o : set) {
            boolean check = o.equals(key);
            if (check) {
                map.remove(key);
                return true;
            }
        }
        return false;
    }

    public Map<String, Object> getHashMap(boolean isLog) throws JSONException {
        if (isLog) {
            for (String key : map.keySet()) {
                String value = map.get(key) != null ? map.get(key).toString() : null;
                log.info("Message Map Value -> {},{}", key, value);
            }
        }
        return map;
    }

    public Map<String, Object> getHashMap() throws JSONException {
        return map;
    }
}