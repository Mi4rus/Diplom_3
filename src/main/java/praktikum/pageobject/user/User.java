package praktikum.pageobject.user;

import java.util.Random;

public class User {

    private String email;
    private String password;
    private String name;

    public User(String email, String password, String name){
        this.email = email;
        this.password = password;
        this.name = name;
    }
    public static User correctUser(){
        return new User("1test-data1-user@yandex.ru", "123456", "1Username1");
    }

    public static User nonExistentUser(){
        return new User("1test-data1-user@yandex.ru", "12345", "1Username1");
    }

    public String getEmail() {
        return email;
    }

    public String getPassword() {
        return password;
    }

    public String getName() {
        return name;
    }
}