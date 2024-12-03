package fitnessapp;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Scanner;

public class FitnessApp {
    private HashMap<String, User> users = new HashMap<>();
    private HashMap<String, ArrayList<Workout>> userWorkouts = new HashMap<>();

    public void registerUser(String username, String password, int age, double weight, double height) {
        if (users.containsKey(username)) {
            System.out.println("Username already exists. Try another username.");
        } else {
            users.put(username, new User(username, password, age, weight, height));
            userWorkouts.put(username, new ArrayList<>());
            System.out.println("User registered successfully!");
        }
    }

    public boolean loginUser(String username, String password) {
        User user = users.get(username);
        if (user != null && user.checkPassword(password)) {
            System.out.println("Login successful!");
            return true;
        }
        System.out.println("Invalid username or password.");
        return false;
    }

    public void addWorkout(String username, String workoutType, int duration, int caloriesBurned) {
        Workout workout = new Workout(workoutType, duration, caloriesBurned);
        userWorkouts.get(username).add(workout);
        System.out.println("Workout added successfully!");
    }

    public void viewWorkouts(String username) {
        ArrayList<Workout> workouts = userWorkouts.get(username);
        if (workouts.isEmpty()) {
            System.out.println("No workouts found.");
        } else {
            System.out.println("Your Workouts:");
            for (Workout workout : workouts) {
                System.out.println(workout);
            }
        }
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        FitnessApp app = new FitnessApp();
        boolean loggedIn = false;
        String currentUser = "";

        while (true) {
            System.out.println("\n--- Online Fitness Application ---");
            System.out.println("1. Register");
            System.out.println("2. Login");
            System.out.println("3. Add Workout");
            System.out.println("4. View Workouts");
            System.out.println("5. Exit");
            System.out.print("Choose an option: ");
            int choice = scanner.nextInt();
            scanner.nextLine();  // Consume newline

            switch (choice) {
                case 1:
                    System.out.print("Enter username: ");
                    String username = scanner.nextLine();
                    System.out.print("Enter password: ");
                    String password = scanner.nextLine();
                    System.out.print("Enter age: ");
                    int age = scanner.nextInt();
                    System.out.print("Enter weight: ");
                    double weight = scanner.nextDouble();
                    System.out.print("Enter height: ");
                    double height = scanner.nextDouble();
                    app.registerUser(username, password, age, weight, height);
                    break;

                case 2:
                    System.out.print("Enter username: ");
                    username = scanner.nextLine();
                    System.out.print("Enter password: ");
                    password = scanner.nextLine();
                    if (app.loginUser(username, password)) {
                        loggedIn = true;
                        currentUser = username;
                    }
                    break;

                case 3:
                    if (loggedIn) {
                        System.out.print("Enter workout type: ");
                        String workoutType = scanner.nextLine();
                        System.out.print("Enter duration in minutes: ");
                        int duration = scanner.nextInt();
                        System.out.print("Enter calories burned: ");
                        int caloriesBurned = scanner.nextInt();
                        app.addWorkout(currentUser, workoutType, duration, caloriesBurned);
                    } else {
                        System.out.println("Please log in to add workouts.");
                    }
                    break;

                case 4:
                    if (loggedIn) {
                        app.viewWorkouts(currentUser);
                    } else {
                        System.out.println("Please log in to view workouts.");
                    }
                    break;

                case 5:
                    System.out.println("Exiting the application.");
                    return;

                default:
                    System.out.println("Invalid choice. Please try again.");
            }
        }
    }
}
