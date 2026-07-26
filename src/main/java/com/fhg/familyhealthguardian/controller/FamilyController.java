package com.fhg.familyhealthguardian.controller;

import com.fhg.familyhealthguardian.entity.FamilyMember;
import com.fhg.familyhealthguardian.repository.FamilyMemberRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
public class FamilyController {

    @Autowired
    private FamilyMemberRepository repository;

    @GetMapping("/family")
    public String familyPage(Model model) {
        model.addAttribute("members", repository.findAll());
        return "family";
    }

    @PostMapping("/family")
    public String addMember(FamilyMember member, Model model) {

        repository.save(member);

        model.addAttribute("members", repository.findAll());
        model.addAttribute("message", "Family Member Added Successfully!");

        return "family";
    }
}
