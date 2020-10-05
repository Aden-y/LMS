package dao;

import data.DatabaseAccess;
import models.PasswordResetToken;

import java.sql.ResultSet;

public class PasswordResetTokenDAO {

    public static PasswordResetToken create(ResultSet resultSet) {
        try {
            if (resultSet.next()) {
                return new PasswordResetToken(resultSet.getString("User"),
                        resultSet.getString("Token"), resultSet.getString("Email"));
            }
        }catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

    public static void create(PasswordResetToken token) {
        delete(token.getUser(), token.getEmail());
        String sql = "insert into PasswordResetToken(User, Token, Email) values('"+token.getUser()+"','"+token.getToken()+"','"+token.getEmail()+"')";
        DatabaseAccess.executeUpdate(sql);
    }

    public static PasswordResetToken fetch(String user, String token) {
        return create(DatabaseAccess.executeQuery("select * from PasswordResetToken where User ='"+user+"' and Token ='"+token+"'"));
    }

    public static void delete(String user , String email) {
        DatabaseAccess.executeUpdate("delete from PasswordResetToken where User ='"+user+"' and Email = '"+email+"'");
    }
}
