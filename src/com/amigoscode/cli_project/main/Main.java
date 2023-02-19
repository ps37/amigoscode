package com.amigoscode.cli_project.main;

import java.util.Arrays;
import java.util.Scanner;
import java.util.UUID;

import com.amigoscode.cli_project.booking.Booking;
import com.amigoscode.cli_project.booking.BookingService;
import com.amigoscode.cli_project.car.Car;
import com.amigoscode.cli_project.car.CarService;
import com.amigoscode.cli_project.car.Make;
import com.amigoscode.cli_project.user.User;
import com.amigoscode.cli_project.user.UserService;
import com.amigoscode.cli_project.utils.MyUuid;

public class Main {
    // Scan the input from user
    static Scanner ourScanner = new Scanner(System.in);
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
            int intInput = Integer.parseInt(input);
            if(intInput < 1 || intInput > 8) {
                throw new IllegalArgumentException("Enter a valid input");
            }
            if(intInput == 7) break;
            processInput(input);
        }
    }

    private static void processInput(String input) {
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
        }
    }
    private static void addUser() {
        System.out.println("Enter First name");
        String firstName = ourScanner.nextLine();
        System.out.println("Enter Last name");
        String lastName = ourScanner.nextLine();
        new UserService().addUser(firstName, lastName);
    }

    private static void bookCar() {
        System.out.println("Enter a user id");
        String userId = ourScanner.nextLine();
        UUID userUUID = MyUuid.getUuid(userId);
        System.out.println("Enter make of the car");
        String carMake = ourScanner.nextLine();
        Make car_make = Make.valueOf(carMake.toUpperCase());
        Car car = new CarService().getCar(car_make);
        new Booking(userUUID, car);
    }

    private static void viewAllBookings() {
        var val = new BookingService().getAll();
        System.out.println(Arrays.toString(val));
    }

    public static void viewUserBookedCars() {
        System.out.println("Enter the user id");
        String userId = ourScanner.nextLine();
        UUID userUUID = MyUuid.getUuid(userId);
        Booking[] val = new UserService().getUser(userUUID).getBookings();
        System.out.println(Arrays.toString(val));
    }

    private static void showAvailableCars() {
        var cars = new CarService().getAll();
        System.out.println(Arrays.toString(cars));
    }

    private static void showElectricCars() {
        var cars = new CarService().getAllElectric();
        System.out.println(Arrays.toString(cars));
    }

    private static void showAllUsers() {
        var users = new UserService().getAll();
        for(User user : users) {
            if(user == null) {
                continue;
            }
            System.out.println(user);
        }
    }
}
