package com.amigoscode.cli_project.utils;

import java.util.UUID;

public class MyUuid {
    public static UUID generate() {
        return UUID.randomUUID();
    }

    public static UUID getUuid(String id) {
        return UUID.fromString(id);
    }
}
