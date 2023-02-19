package com.amigoscode.cli_project.car;

public class CarService {
    private static CarDao carDao;
    public CarService() {
        carDao = new CarDao();
    }

    public Car getCar(Make make) {
        var cars = getAll();
        for(Car car : cars) {
            if(car.getMake() == make) {
                return car;
            }
        }
        return null;
    }
    public Car[] getAll() {
        return carDao.getAllCars();
    }
    public Car[] getAllElectric() {
        var cars = this.getAll();
        var electricCars = new Car[5];
        var currIndex = 0;
        for(Car car : cars) {
            if(car.getEngineType() == EngineType.ELECTRIC) {
                electricCars[currIndex] = car;
                currIndex++;
            }
        }
        return electricCars;
    }
}
