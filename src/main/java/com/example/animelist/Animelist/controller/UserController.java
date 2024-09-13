package com.example.animelist.Animelist.controller;

import com.example.animelist.Animelist.Exception.ProfileException;
import com.example.animelist.Animelist.dto.SignupDto;
import com.example.animelist.Animelist.entity.Session;
import com.example.animelist.Animelist.entity.User;
import com.example.animelist.Animelist.service.SessionService;
import com.example.animelist.Animelist.service.UserService;
import jakarta.servlet.http.Cookie;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.List;
@RestController
@RequestMapping("/api/users")
public class UserController {

    private UserService userService;
    private SessionService sessionService;
    @Autowired
    public UserController(UserService userService) {
        this.userService = userService;
    }

    @GetMapping("/{id}")
    public User getUserById(@PathVariable String id) {
        User user = userService.getById(id);
        return user;
    }

    @DeleteMapping("/{id}")
    public void delete(HttpSession session,@PathVariable String id) {
        boolean isAllowed = sessionService.checkUserOrAdmin(session,id);

        if (!isAllowed) {
            throw new ProfileException("you cant access this profile");
        }
        userService.delete(id);
    }

    @PostMapping("")
    public User create(@RequestBody User user) {
        return userService.save(user);
    }

    @PatchMapping("")
    public User update(HttpSession session, @RequestBody User user) {

        boolean isAllowed = sessionService.checkUserOrAdmin(session,user.getId());
        if (!isAllowed) {
            throw new ProfileException("you cant access this profile");
        }
        return user;
    }

    @PostMapping("/login")
    public void login(@RequestBody SignupDto signInInfo,HttpServletRequest request) {

       User user = userService.login(signInInfo);

        setSession(request,user);



    }

    @PostMapping("/signup")
    public void Signup(@RequestBody SignupDto signupDto,HttpServletRequest request) {

        User user = userService.signup(signupDto);

        setSession(request,user);
    }

    private void setSession(HttpServletRequest request,User user) {
        HttpSession session = request.getSession(true);
        session.setAttribute("roles",user.getAuthorities());
        session.setAttribute("userId",user.getId());
    }





    private String getCookieValue(HttpServletRequest request, String cookieName) {
        Cookie[] cookies = request.getCookies();
        if (cookies != null) {
            for (Cookie cookie : cookies) {
                if (cookieName.equals(cookie.getName())) {
                    return cookie.getValue();
                }
            }
        }
        return null;
    }







}