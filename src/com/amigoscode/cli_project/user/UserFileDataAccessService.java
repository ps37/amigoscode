package com.amigoscode.cli_project.user;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;
import java.util.UUID;

public class UserFileDataAccessService implements UserDao {
    private static final String filePath = "src/com/amigoscode/cli_project/users.csv";

    static {
        File inputFile = new File(UserFileDataAccessService.filePath);
        Scanner fileScanner;
        try {
            fileScanner = new Scanner(inputFile);
        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        }
        while(fileScanner.hasNext()) {
            String currUsrStr = fileScanner.nextLine();
            String[] currUsrStrArr = currUsrStr.split(" ");
            users.add(new User(
                    UUID.fromString(currUsrStrArr[0]),
                    currUsrStrArr[1],
                    currUsrStrArr[2])
            );
        }
    }
}
