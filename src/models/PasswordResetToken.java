package models;

public class PasswordResetToken {
    private String User, Token, Email;

    public PasswordResetToken(String user, String token, String email) {
        User = user;
        Token = token;
        Email = email;
    }

    public String getUser() {
        return User;
    }

    public void setUser(String user) {
        User = user;
    }

    public String getToken() {
        return Token;
    }

    public void setToken(String token) {
        Token = token;
    }

    public String getEmail() {
        return Email;
    }

    public void setEmail(String email) {
        Email = email;
    }
}
