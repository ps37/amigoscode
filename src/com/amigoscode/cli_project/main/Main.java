package com.amigoscode.cli_project.main;

public class Main extends MyMain {
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
            String input = getInput();
            if(input.equals("7")) break;
            try {
                processInput(input);
            } catch (Exception e) {
                System.out.println(ANSI_RED + e.getMessage() + ANSI_RESET);
            }
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
        default:
            System.out.println(ANSI_RED + "Please enter a valid input!" + ANSI_RESET);
        }
    }
}
