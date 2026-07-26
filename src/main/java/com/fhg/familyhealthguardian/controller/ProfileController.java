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
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

@Controller
public class ProfileController {

    @Autowired
    private UserRepository userRepository;

    @GetMapping("/profile")
    public String viewProfile(HttpSession session, Model model) {
        User loggedInUser = (User) session.getAttribute("loggedInUser");
        if (loggedInUser == null) {
            return "redirect:/login";
        }
        model.addAttribute("user", loggedInUser);
        return "profile";
    }

    // Safe Profile Update Method
    @PostMapping("/profile/update")
    public String updateProfile(@RequestParam(value = "name", required = false) String name,
                                HttpSession session,
                                RedirectAttributes redirectAttributes) {
        
        try {
            User sessionUser = (User) session.getAttribute("loggedInUser");
            if (sessionUser == null) {
                return "redirect:/login";
            }

            User dbUser = userRepository.findById(sessionUser.getId()).orElse(null);
            if (dbUser != null) {
                if (name != null && !name.trim().isEmpty()) {
                    dbUser.setName(name);
                }
                userRepository.save(dbUser);
                session.setAttribute("loggedInUser", dbUser);
                redirectAttributes.addFlashAttribute("successMessage", "Profile details updated successfully!");
            }
        } catch (Exception e) {
            e.printStackTrace();
            redirectAttributes.addFlashAttribute("error", "Error updating profile: " + e.getMessage());
        }

        return "redirect:/profile";
    }

    // Password Update Method
    @PostMapping("/profile/change-password")
    public String changePassword(@RequestParam("currentPassword") String currentPassword,
                                 @RequestParam("newPassword") String newPassword,
                                 @RequestParam("confirmPassword") String confirmPassword,
                                 HttpSession session,
                                 RedirectAttributes redirectAttributes) {

        try {
            User sessionUser = (User) session.getAttribute("loggedInUser");
            if (sessionUser == null) {
                return "redirect:/login";
            }

            User dbUser = userRepository.findById(sessionUser.getId()).orElse(null);

            if (dbUser != null) {
                if (!dbUser.getPassword().equals(currentPassword)) {
                    redirectAttributes.addFlashAttribute("error", "Current password is incorrect!");
                    return "redirect:/profile";
                }

                if (!newPassword.equals(confirmPassword)) {
                    redirectAttributes.addFlashAttribute("error", "New passwords do not match!");
                    return "redirect:/profile";
                }

                dbUser.setPassword(newPassword);
                userRepository.save(dbUser);

                session.setAttribute("loggedInUser", dbUser);

                redirectAttributes.addFlashAttribute("success", "Password updated successfully!");
            }
        } catch (Exception e) {
            e.printStackTrace();
            redirectAttributes.addFlashAttribute("error", "Error changing password: " + e.getMessage());
        }

        return "redirect:/profile";
    }
}