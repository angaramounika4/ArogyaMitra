package com.fhg.familyhealthguardian.controller;

import com.fhg.familyhealthguardian.entity.User;
import com.fhg.familyhealthguardian.repository.UserRepository;

import jakarta.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class LoginController {

    @Autowired
    private UserRepository userRepository;

    @GetMapping("/login")
    public String loginPage() {
        return "login";
    }

    @PostMapping("/login")
    public String loginUser(@RequestParam String email,
                            @RequestParam String password,
                            HttpSession session,
                            Model model) {

        User user = userRepository.findByEmail(email);

        if (user != null) {
            if (user.getPassword().equals(password)) {
                session.setAttribute("loggedInUser", user);
                return "redirect:/dashboard";
            }
        }

        model.addAttribute("message", "Invalid Email or Password");
        return "login";
    }

    @GetMapping("/dashboard")
    public String dashboardPage(HttpSession session) {
        if (session.getAttribute("loggedInUser") == null) {
            return "redirect:/login";
        }
        return "dashboard";
    }

    @GetMapping("/logout")
    public String logout(HttpSession session) {
        session.invalidate();
        return "redirect:/login";
    }
}
