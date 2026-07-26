package com.fhg.familyhealthguardian.controller;

import com.fhg.familyhealthguardian.entity.HealthTracker;
import com.fhg.familyhealthguardian.repository.HealthTrackerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
public class HealthController {

    @Autowired
    private HealthTrackerRepository healthTrackerRepository;

    @GetMapping("/healthtracker")
    public String showHealthTrackerPage(Model model) {
        List<HealthTracker> list = healthTrackerRepository.findAll();
        model.addAttribute("healthTrackerList", list);
        model.addAttribute("healthTracker", new HealthTracker());
        return "healthtracker";
    }

    @PostMapping("/healthtracker/save")
    public String saveHealthRecord(@ModelAttribute("healthTracker") HealthTracker healthTracker) {
        healthTrackerRepository.save(healthTracker);
        return "redirect:/healthtracker";
    }

    @GetMapping("/healthtracker/edit/{id}")
    public String showEditForm(@PathVariable("id") Long id, Model model) {
        HealthTracker record = healthTrackerRepository.findById(id).orElse(null);
        model.addAttribute("healthTracker", record);
        return "edit-healthtracker";
    }

    @PostMapping("/healthtracker/update")
    public String updateHealthRecord(@ModelAttribute("healthTracker") HealthTracker healthTracker) {
        healthTrackerRepository.save(healthTracker);
        return "redirect:/healthtracker";
    }

    @GetMapping("/healthtracker/delete/{id}")
    public String deleteHealthRecord(@PathVariable("id") Long id) {
        healthTrackerRepository.deleteById(id);
        return "redirect:/healthtracker";
    }
}