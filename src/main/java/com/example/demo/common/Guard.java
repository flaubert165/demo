package com.example.demo.common;

public class Guard {

    public static void forNullOrEmpty(String value, String errorMessage) throws Exception {

        if (value == null || value.isEmpty())
            throw new Exception(errorMessage);
    }
}
