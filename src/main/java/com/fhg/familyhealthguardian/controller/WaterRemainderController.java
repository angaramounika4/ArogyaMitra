package com.fhg.familyhealthguardian.controller;

import com.fhg.familyhealthguardian.entity.WaterRemainder;
import com.fhg.familyhealthguardian.repository.WaterRemainderRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
public class WaterRemainderController {

    @Autowired
    private WaterRemainderRepository waterRepository;

    @GetMapping("/water")
    public String viewWaterTracker(Model model) {
        List<WaterRemainder> logs = waterRepository.findAll();
        
        int totalMl = logs.stream().mapToInt(WaterRemainder::getAmountMl).sum();
        int dailyGoal = 3000;
        int percentage = Math.min((totalMl * 100) / dailyGoal, 100);

        model.addAttribute("waterLogs", logs);
        model.addAttribute("newWater", new WaterRemainder());
        model.addAttribute("totalMl", totalMl);
        model.addAttribute("dailyGoal", dailyGoal);
        model.addAttribute("percentage", percentage);
        
        return "water";
    }

    @PostMapping("/water/save")
    public String saveWaterLog(@ModelAttribute("newWater") WaterRemainder water) {
        waterRepository.save(water);
        return "redirect:/water";
    }

    @GetMapping("/water/delete/{id}")
    public String deleteWaterLog(@PathVariable("id") Long id) {
        waterRepository.deleteById(id);
        return "redirect:/water";
    }
}