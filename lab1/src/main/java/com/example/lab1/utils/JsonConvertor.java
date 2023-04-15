package com.example.lab1.utils;

import java.io.IOException;
import java.io.InputStream;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;

public class JsonConvertor {
    public static <T> T deserialize(InputStream inputStream) throws IOException {
        ObjectMapper objectMapper = new ObjectMapper();
        TypeReference<T> typeReference = new TypeReference<T>() {};
        return objectMapper.readValue(inputStream, typeReference);
    }
}
