package com.fhg.familyhealthguardian.controller;
import com.fhg.familyhealthguardian.entity.FamilyMember;
import com.fhg.familyhealthguardian.repository.FamilyMemberRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class MemberController {

    @Autowired
    private FamilyMemberRepository repository;

    @GetMapping("/members")
    public String listMembers(Model model) {
        model.addAttribute("members", repository.findAll());
        model.addAttribute("newMember", new FamilyMember());
        return "members";
    }

    @PostMapping("/members/save")
    public String saveMember(@ModelAttribute("newMember") FamilyMember member) {
        repository.save(member);
        return "redirect:/members";
    }

    @GetMapping("/members/delete/{id}")
    public String deleteMember(@PathVariable("id") Long id) {
        repository.deleteById(id);
        return "redirect:/members";
    }
}