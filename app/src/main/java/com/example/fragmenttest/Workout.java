package com.example.fragmenttest;

public class Workout {


    private String name;
    private String description;

    public static final Workout[] workouts = {
            new Workout("Core Agony","100 Pull-ups\n100 Push-ups\n100 Sit-ups\n100 Squats"),
            new Workout("Core Agony 2","200 Pull-ups\n100 Push-ups\n100 Sit-ups\n100 Squats"),
            new Workout("Core Agony 3","300 Pull-ups\n100 Push-ups\n100 Sit-ups\n100 Squats")
    };

    public Workout(String name, String description){
        this.name = name;
        this.description = description;
    }

    public String getName() {
        return name;
    }

    public String getDescription() {
        return description;
    }

    public String toString(){
        return this.name;
    }
}
