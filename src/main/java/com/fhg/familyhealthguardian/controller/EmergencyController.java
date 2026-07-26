package com.fhg.familyhealthguardian.controller;

import com.fhg.familyhealthguardian.entity.EmergencyContact;
import com.fhg.familyhealthguardian.repository.EmergencyContactRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
public class EmergencyController {

    @Autowired
    private EmergencyContactRepository emergencyRepository;

    @GetMapping("/emergency")
    public String listEmergencyContacts(Model model) {
        model.addAttribute("contacts", emergencyRepository.findAll());
        model.addAttribute("newContact", new EmergencyContact());
        return "emergency";
    }

    @PostMapping("/emergency/save")
    public String saveEmergencyContact(@ModelAttribute("newContact") EmergencyContact contact) {
        emergencyRepository.save(contact);
        return "redirect:/emergency";
    }

    @GetMapping("/emergency/delete/{id}")
    public String deleteEmergencyContact(@PathVariable("id") Long id) {
        emergencyRepository.deleteById(id);
        return "redirect:/emergency";
    }
}
