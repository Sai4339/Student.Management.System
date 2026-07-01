package com.sms.util;

public class InputValidator {
    public static boolean isValidId(int id){
        return id>0;
    }
    public static boolean isValidName(String name) {
        return name != null && !name.trim().isEmpty();
    }

    public static boolean isValidAge(int age) {
        return age >= 16 && age <= 100;
    }

    public static boolean isValidCourse(String course) {
        return course != null && !course.trim().isEmpty();
    }
}
