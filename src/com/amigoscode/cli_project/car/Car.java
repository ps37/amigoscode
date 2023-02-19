package com.amigoscode.cli_project.car;

public class Car {
    private Make make;
    private double price;
    private EngineType engineType;

    @Override
    public String toString() {
        return "Car{" +
                "make='" + make + '\'' +
                ", price=" + price +
                ", engineType=" + engineType +
                '}';
    }

    public Car(Make make) {
        this.make = make;
        switch (make) {
            case TOYOTA -> {
                this.price = 10000;
                this.engineType = EngineType.PETROL;
            }
            case TESLA -> {
                this.price = 20000;
                this.engineType = EngineType.ELECTRIC;
            }
            case HONDA -> {
                this.price = 30000;
                this.engineType = EngineType.PETROL;
            }
            case LUCID -> {
                this.price = 40000;
                this.engineType = EngineType.ELECTRIC;
            }
        }
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public EngineType getEngineType() {
        return engineType;
    }

    public void setEngineType(EngineType engineType) {
        this.engineType = engineType;
    }

    public Make getMake() {
        return make;
    }

    public void setMake(Make make) {
        this.make = make;
    }
}
