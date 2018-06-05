package org.agoraspeakers.cms.controller;

import com.weddini.throttling.Throttling;
import com.weddini.throttling.ThrottlingType;
import org.agoraspeakers.cms.dao.UserRepository;
import org.agoraspeakers.cms.domain.AppUser;
import org.agoraspeakers.cms.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.inject.Inject;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.TimeUnit;
import java.util.stream.Stream;

@RestController
public class WebController {

    @Autowired
    UserService userService;


    @PutMapping(value = "/users/register")
    // @GetMapping(value = "/users/register")
    @Throttling(type = ThrottlingType.RemoteAddr, limit = 50, timeUnit = TimeUnit.HOURS)
    public ResponseEntity<Void> registerUser(@RequestBody AppUser appUser){

        boolean isExistUsername = userService.isExistUsername(appUser.getUsername());

        if (isExistUsername) {
            return new ResponseEntity<>(HttpStatus.CONFLICT);
        }

        boolean isExistEmail = userService.isExistEmail(appUser.getEmail());
        if (isExistEmail) {
            return new ResponseEntity<>(HttpStatus.CONFLICT);
        }

        userService.addUser(appUser);
        return new ResponseEntity<>(HttpStatus.OK);
    }


    @GetMapping(value = "/users/verifyusername")
    @Throttling(type = ThrottlingType.RemoteAddr, limit = 100, timeUnit = TimeUnit.HOURS)
    public ResponseEntity<Boolean> verifyUsername(@RequestParam String username){
        boolean isExistUsername = userService.isExistUsername(username);
        if (isExistUsername) {
            return new ResponseEntity<>(Boolean.TRUE, HttpStatus.OK);
        } else {
            return new ResponseEntity<Boolean>(Boolean.FALSE, HttpStatus.OK);
        }
    }

    @RequestMapping(value = "/users/sendresetpassword", method = RequestMethod.POST)
    @Throttling(type = ThrottlingType.RemoteAddr, limit = 5, timeUnit = TimeUnit.HOURS)
    public void sendResetPassword() {

    }

    @RequestMapping(value = "/users/login")
    public void login(){

    }

    @RequestMapping(value = "/secureecho")
    public void secureEcho() {

    }
}
