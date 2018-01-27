package com.example.demo.common;

import org.springframework.security.crypto.bcrypt.BCrypt;

public class PasswordEncoder {

    public static boolean checkPassword(String dtoPass, String userPass){

        return BCrypt.checkpw(dtoPass, userPass);
    }

    public static String generatePassword(String password){

        return BCrypt.hashpw(password, BCrypt.gensalt());
    }
}
