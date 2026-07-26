package com.fhg.familyhealthguardian.controller;

import com.fhg.familyhealthguardian.entity.Medicine;
import com.fhg.familyhealthguardian.repository.MedicineRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
public class MedicineController {

    @Autowired
    private MedicineRepository medicineRepository;

    @GetMapping({"/reminders", "/medicine"})
    public String listReminders(Model model) {
        model.addAttribute("medicines", medicineRepository.findAll());
        model.addAttribute("newMedicine", new Medicine());
        return "medicine";
    }

    @PostMapping("/medicine/save")
    public String saveReminder(@ModelAttribute("newMedicine") Medicine medicine) {
        medicineRepository.save(medicine);
        return "redirect:/reminders";
    }

    @GetMapping("/medicine/edit/{id}")
    public String editReminder(@PathVariable("id") Long id, Model model) {
        model.addAttribute("medicines", medicineRepository.findAll());
        model.addAttribute("newMedicine", medicineRepository.findById(id).orElse(new Medicine()));
        return "medicine";
    }

    @GetMapping("/medicine/delete/{id}")
    public String deleteReminder(@PathVariable("id") Long id) {
        medicineRepository.deleteById(id);
        return "redirect:/reminders";
    }
}