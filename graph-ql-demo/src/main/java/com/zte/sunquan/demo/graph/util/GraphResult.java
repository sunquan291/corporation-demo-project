package com.zte.sunquan.demo.graph.util;

import java.util.Map;

import lombok.extern.slf4j.Slf4j;

import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.google.common.base.Preconditions;

/**
 * GraphResult class
 *
 * @author 10184538
 * @date 2019/6/25
 */
@Slf4j
public class GraphResult {

    private static final String ERRORS = "errors";
    private static final String DATA = "data";

    public static String resolve(Map<String, Object> result) {
        Preconditions.checkNotNull(result, "Result can not be null.");
        String data = null;
        try {
            if (result.containsKey(ERRORS)) {
                return JacksonJsonConverter.getInstance().serialize(result.get(ERRORS));
            } else {
                data = JacksonJsonConverter.getInstance().serialize(result.get(DATA));
            }
        } catch (JsonProcessingException e) {
            log.error("error", e);
        }
        return data;
    }


}

class JacksonJsonConverter {
    private static final JacksonJsonConverter instance = new JacksonJsonConverter();
    private ObjectMapper mapper = null;

    public static JacksonJsonConverter getInstance() {
        return instance;
    }

    private JacksonJsonConverter() {
        this.mapper = new ObjectMapper();
        this.mapper.configure(JsonGenerator.Feature.QUOTE_FIELD_NAMES, true);
        this.mapper.configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES, false);
    }

    public ObjectMapper getMapper() {
        return this.mapper;
    }

    public <T> String serialize(T object) throws JsonProcessingException {
        return this.mapper.writeValueAsString(object);

    }

}