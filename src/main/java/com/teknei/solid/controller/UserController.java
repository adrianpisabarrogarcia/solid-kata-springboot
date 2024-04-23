package com.teknei.solid.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


@RestController
class UserController {

    private final UserService userService;
    private final NotificationService notificationService;

    public UserController(UserService userService, NotificationService notificationService) {
        this.userService = userService;
        this.notificationService = notificationService;
    }

    @GetMapping("/users")
    public List<String> getAllUsers() {
        return userService.retrieveUsers();
    }

    @GetMapping("/notify-users")
    public String notifyUsers() {
        notificationService.sendEmailToAllUsers("Reminder: Update your profile!");
        return "Notification sent!";
    }
}

@Service
class UserService {

    public List<String> retrieveUsers() {
        // This should contain logic to retrieve user data from a database
        return List.of("Alice", "Bob");
    }
}

@Service
class LoggingService {

    public void logAccess(String message) {
        // Logic to log access information
        System.out.println("Log entry: " + message);
    }
}

@Service
class NotificationService {

    public void sendEmailToAllUsers(String message) {
        // Logic to send email to all users
        System.out.println("Sending email: " + message);
    }
}

