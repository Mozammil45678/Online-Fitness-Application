package fitnessapp;

public class Workout {
    private String workoutType;
    private int duration;  // Duration in minutes
    private int caloriesBurned;

    public Workout(String workoutType, int duration, int caloriesBurned) {
        this.workoutType = workoutType;
        this.duration = duration;
        this.caloriesBurned = caloriesBurned;
    }

    @Override
    public String toString() {
        return "Workout Type: " + workoutType + ", Duration: " + duration + " mins, Calories Burned: " + caloriesBurned;
    }
}
