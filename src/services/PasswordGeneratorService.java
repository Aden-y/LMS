package services;

import java.util.Random;

public class PasswordGeneratorService {
    public static String generate(int length) {
        String password = "";
        char[] alphabet = "abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ1234567890".toCharArray();
        int min = 0, max = alphabet.length-1;
        Random random = new Random();
        for (int i=0; i<length; i++) {
            password+=alphabet[random.nextInt(max - min + 1) + min];
        }
        return password;
    }
}
