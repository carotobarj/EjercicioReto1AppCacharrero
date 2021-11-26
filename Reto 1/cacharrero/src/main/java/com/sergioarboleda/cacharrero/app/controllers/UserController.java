package com.sergioarboleda.cacharrero.app.controllers;


import com.sergioarboleda.cacharrero.app.model.User;
import com.sergioarboleda.cacharrero.app.services.UserServices;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author Carotobarj
 */

@RestController
@CrossOrigin(origins = "*")
@RequestMapping("user")

public class UserController {

    @Autowired
    private UserServices service;

    /**
     *
     * @return
     */
    @GetMapping("/all")
    public List<User> getUsers(){
        return service.getAll();
    }

    /**
     *
     * @param user
     * @return
     */
    @PostMapping("/new")
    @ResponseStatus(HttpStatus.CREATED)
    public User save(@RequestBody User user){
        return service.save(user);

    }

    /**
     *
     * @param email
     * @return
     */
    @GetMapping("/{email}")
    public boolean existEmail(@PathVariable("email")String email){
        return service.getUserByEmail(email);
    }

    /**
     *
     * @param email
     * @param password
     * @return
     */
    @GetMapping("/{email}/{password}")
    public User existUser(@PathVariable("email")String email,@PathVariable("password")String password){
        return service.getByEmailPass(email, password);
    }


}
