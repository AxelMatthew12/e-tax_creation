package Esamsat;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.Base64;

public class User {
    private String id;
    private String hashedPassword;

    public User(String id, String password) {
        this.id = id;
        this.hashedPassword = hashPassword(password);
    }

    public String getId() {
        return id;
    }

    public boolean checkPassword(String password) {
        return hashedPassword.equals(hashPassword(password));
    }

    private String hashPassword(String password) {
        try {
            MessageDigest md = MessageDigest.getInstance("SHA-256");
            byte[] hast = md.digest(password.getBytes());
            return Base64.getEncoder().encodeToString(hast);
        } catch (NoSuchAlgorithmException e) {
            throw new RuntimeException(e);
        }
    }
}
