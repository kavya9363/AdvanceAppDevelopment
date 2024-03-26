package com.yoga.yoga.constant;

import java.util.Arrays;
import java.util.List;

public class Api {
    public static final String DEFAULT = "http://localhost:8080";
    public static final String AUTH = "/auth";
    public static final String USER = "/user";
    public static final String COURSES = "/course";
    public static final String ACADEMIES = "/academy";
    // public static final String CATEGORY = "/category";
    // public static final String APPLICATION = "/application";
    // public static final String ORDER = "/order";
    // public static final String PAYMENT = "/payment";
    // public static final String FEEDBACK = "/feedback";
    // public static final String CONTACT = "/contact";
    public static final List<String> HEADERS = Arrays.asList("Authorization", "Content-Type");
    public static final List<String> METHODS = Arrays.asList("GET", "POST", "PUT", "DELETE");
    public static final List<String> ORIGINS = Arrays.asList("http://localhost:3000");
}
