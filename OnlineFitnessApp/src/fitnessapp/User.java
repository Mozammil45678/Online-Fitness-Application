package fitnessapp;

public class User {
    private String username;
    private String password;
    private int age;
    private double weight;
    private double height;

    public User(String username, String password, int age, double weight, double height) {
        this.username = username;
        this.password = password;
        this.age = age;
        this.weight = weight;
        this.height = height;
    }

    public String getUsername() {
        return username;
    }

    public boolean checkPassword(String password) {
        return this.password.equals(password);
    }
}
