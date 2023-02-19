package com.amigoscode.cli_project.main;

import java.util.Arrays;
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

public class Main {
    // Singletons
    public final static BookingDao bookingDao = new BookingDao();
    public static final UserDao userDao = new UserFileDataAccessService();
    public final static UserService userService = new UserService(userDao);
    public static final BookingService bookingService = new BookingService(bookingDao, userService);
    public final static CarDao carDao = new CarDao();
    public static final CarService carService = new CarService(carDao);
    // *********

    static Scanner ourScanner = new Scanner(System.in);
    private static final String ANSI_RED = "\u001B[31m";
    private static final String ANSI_RESET = "\u001B[0m";
    public static void main(String[] args) {
        System.out.println(
                "1️⃣ - Book Car\n" +
                "2️⃣ - View All User Booked Cars\n" +
                "3️⃣ - View All Bookings\n" +
                "4️⃣ - View Available Cars\n" +
                "5️⃣ - View Available Electric Cars\n" +
                "6️⃣ - View all users\n" +
                "8 - Add new user\n" +
                "7️⃣ - Exit"
        );
        while(true) {
            System.out.println("Enter input");
            String input = ourScanner.nextLine();
            if(input.equals("7")) break;
            try {
                processInput(input);
            } catch (Exception e) {
                System.out.println(ANSI_RED + e.getMessage() + ANSI_RESET);
            }
        }
    }

    private static void processInput(String input) throws Exception {
        switch (input) {
        case "1":
            bookCar();
            break;
        case "2":
            viewUserBookedCars();
            break;
        case "3":
            viewAllBookings();
            break;
        case "4":
            showAvailableCars();
            break;
        case "5":
            showElectricCars();
            break;
        case "6":
            showAllUsers();
            break;
        case "8":
            addUser();
            break;
        default:
            System.out.println("Please enter a valid input!");
        }
    }
    private static void addUser() {
        System.out.println("Enter First name");
        String firstName = ourScanner.nextLine();
        System.out.println("Enter Last name");
        String lastName = ourScanner.nextLine();
        userService.addUser(firstName, lastName);
    }

    private static void bookCar() {
        System.out.println("Enter a user id");
        String userId = ourScanner.nextLine();
        UUID userUUID = MyUuid.getUuid(userId);
        System.out.println("Enter make of the car");
        String carMake = ourScanner.nextLine();
        Make car_make = Make.valueOf(carMake.toUpperCase());
        Car car = carService.getCar(car_make);
        Booking newBooking = new Booking(userUUID, car);
        bookingService.save(newBooking);
    }

    private static void viewAllBookings() {
        var val = bookingService.getAll();
        System.out.println(Arrays.toString(val));
    }

    public static void viewUserBookedCars() {
        System.out.println("Enter the user id");
        String userId = ourScanner.nextLine();
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

    private static void showAvailableCars() {
        var cars = carService.getAll();
        System.out.println(Arrays.toString(cars));
    }

    private static void showElectricCars() {
        var cars = carService.getAllElectric();
        System.out.println(Arrays.toString(cars));
    }

    private static void showAllUsers() {
        var users = userService.getAll();
        for(User user : users) {
            if(user == null) {
                continue;
            }
            System.out.println(user);
        }
    }
}
