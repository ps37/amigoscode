package com.amigoscode.cli_project.main;

import java.util.Arrays;
import java.util.Optional;
import java.util.Scanner;
import java.util.UUID;

import com.amigoscode.cli_project.booking.Booking;
import com.amigoscode.cli_project.booking.BookingDao;
import com.amigoscode.cli_project.booking.BookingService;
import com.amigoscode.cli_project.car.Car;
import com.amigoscode.cli_project.car.CarDao;
import com.amigoscode.cli_project.car.CarService;
import com.amigoscode.cli_project.car.Make;
import com.amigoscode.cli_project.user.User;
import com.amigoscode.cli_project.user.UserDao;
import com.amigoscode.cli_project.user.UserFileDataAccessService;
import com.amigoscode.cli_project.user.UserService;
import com.amigoscode.cli_project.utils.MyUuid;

abstract public class MyMain {
    // Singletons
    public final static BookingDao bookingDao = new BookingDao();
    public static final UserDao userDao = new UserFileDataAccessService();
    public final static UserService userService = new UserService(userDao);
    public static final BookingService bookingService = new BookingService(bookingDao, userService);
    public final static CarDao carDao = new CarDao();
    public static final CarService carService = new CarService(carDao);
    // *********
    static Scanner ourScanner = new Scanner(System.in);
    
    protected static String getInput() {
        return ourScanner.nextLine();
    }

    protected static void addUser() {
        System.out.println("Enter First name");
        String firstName = getInput();
        System.out.println("Enter Last name");
        String lastName = getInput();
        userService.addUser(firstName, lastName);
    }

    protected static void bookCar() {
        System.out.println("Enter a user id");
        String userId = getInput();
        UUID userUUID = MyUuid.getUuid(userId);
        System.out.println("Enter make of the car");
        String carMake = getInput();
        Make car_make = Make.valueOf(carMake.toUpperCase());
        Car car = carService.getCar(car_make);
        Booking newBooking = new Booking(userUUID, car);
        bookingService.save(newBooking);
    }

    protected static void viewAllBookings() {
        var val = bookingService.getAll();
        System.out.println(Arrays.toString(val));
    }

    public static void viewUserBookedCars() {
        System.out.println("Enter the user id");
        String userId = getInput();
        UUID userUUID = MyUuid.getUuid(userId);
        final User user = userService.getUser(userUUID);
        UUID[] bookingIds = user.getBookings();
        var bookings = new Booking[user.getCurrBookIndex()];
        var currIndex = 0;
        for(UUID id : bookingIds) {
            if(id == null) {
                continue;
            }
            bookings[currIndex] = bookingService.get(id);
            currIndex++;
        }
        System.out.println(Arrays.toString(bookings));
    }

    protected static void showAvailableCars() {
        var cars = carService.getAll();
        System.out.println(Arrays.toString(cars));
    }

    protected static void showElectricCars() {
        var cars = carService.getAllElectric();
        System.out.println(Arrays.toString(cars));
    }

    protected static void showAllUsers() {
        var users = userService.getAll();
        for(User user : users) {
            Optional<User> optionalUser = Optional.ofNullable(user);
            optionalUser.ifPresentOrElse(System.out::println, () -> {});
        }
    }
}
