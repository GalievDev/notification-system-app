package dev.galiev.notificationsystem.controllers;

import dev.galiev.notificationsystem.models.User;
import dev.galiev.notificationsystem.repository.UsersRep;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RequestMapping("/api/v1")
@RestController
public class MainController {

    @Autowired
    private UsersRep usersRep;

    @GetMapping("user")
    public ResponseEntity<List<User>> allUsers() {
        return new ResponseEntity<>(usersRep.findAll(), HttpStatus.FOUND);
    }
}
