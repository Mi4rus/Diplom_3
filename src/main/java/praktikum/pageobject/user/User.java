package praktikum.pageobject.user;

import java.time.LocalDateTime;
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
    public static User randomUser(){
        return new User("email" + Math.random() + "@yandex.ru", "LkYThgf3211", "Michael");
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