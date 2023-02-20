package com.amigoscode.cli_project.car;

import java.util.ArrayList;
import java.util.List;

public class CarDao {
    private static final List<Car> cars;

    static {
        cars = new ArrayList<>();
        cars.add(new Car(Make.TOYOTA));
        cars.add(new Car(Make.TESLA));
        cars.add(new Car(Make.HONDA));
        cars.add(new Car(Make.LUCID));
    }

    public Car[] getAllCars() {
        return cars.toArray(new Car[0]);
    }
}
