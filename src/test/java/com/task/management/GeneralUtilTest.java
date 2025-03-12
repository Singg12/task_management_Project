package com.task.management;

import org.junit.jupiter.api.Test;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

public class GeneralUtilTest {
    
    @Test
    public void showPassword() {
        BCryptPasswordEncoder passwordEncoder = new BCryptPasswordEncoder();
        String encodedPassword = passwordEncoder.encode("sela123");
        System.out.println("Encoded Password: " + encodedPassword);
    }
}
    