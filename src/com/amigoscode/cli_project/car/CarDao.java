package com.amigoscode.cli_project.car;

public class CarDao {
    private static final Car[] cars;

    static {
        cars = new Car[4];
        cars[0] = new Car(Make.TOYOTA);
        cars[1] = new Car(Make.TESLA);
        cars[2] = new Car(Make.HONDA);
        cars[3] = new Car(Make.LUCID);
    }

    public Car[] getAllCars() {
        return cars;
    }
}
