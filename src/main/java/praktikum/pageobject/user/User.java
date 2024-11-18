package praktikum.pageobject.user;

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
        return new User("1test-data1@yandex.ru", "123456", "1Username1");
    }
    public static User nonExistentUser(){
        return new User("1test-data1@yandex.ru", "12345", "1Username1");
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