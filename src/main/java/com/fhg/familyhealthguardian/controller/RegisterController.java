package com.fhg.familyhealthguardian.controller;

import com.fhg.familyhealthguardian.entity.User;
import com.fhg.familyhealthguardian.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class RegisterController {

    @Autowired
    private UserRepository userRepository;

    @GetMapping("/register")
    public String showRegisterPage() {
        return "register";
    }

    @PostMapping("/register")
    public String handleRegistration(@RequestParam("name") String name,
                                     @RequestParam("email") String email,
                                     @RequestParam("password") String password,
                                     Model model) {
        
        // 1. Check if user already exists
        User existingUser = userRepository.findByEmail(email.trim());
        
        if (existingUser != null) {
            // Already registered error message sent to UI
            model.addAttribute("errorMessage", "You have already registered with this email!");
            return "register"; // Stay on register page with error
        }

        // 2. If new user, save to DB
        User newUser = new User();
        newUser.setName(name);
        newUser.setEmail(email.trim());
        newUser.setPassword(password.trim());
        userRepository.save(newUser);

        return "redirect:/login"; 
    }
}