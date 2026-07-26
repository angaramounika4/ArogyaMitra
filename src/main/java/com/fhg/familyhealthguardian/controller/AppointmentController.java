package com.fhg.familyhealthguardian.controller;

import com.fhg.familyhealthguardian.entity.Appointment;
import com.fhg.familyhealthguardian.repository.AppointmentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
public class AppointmentController {

    @Autowired
    private AppointmentRepository appointmentRepository;

    @GetMapping("/appointments")
    public String listAppointments(Model model) {
        model.addAttribute("appointments", appointmentRepository.findAll());
        model.addAttribute("newAppointment", new Appointment());
        return "appointments";
    }

    @PostMapping("/appointments/save")
    public String saveAppointment(@ModelAttribute("newAppointment") Appointment appointment) {
        appointmentRepository.save(appointment);
        return "redirect:/appointments";
    }

    @GetMapping("/appointments/delete/{id}")
    public String deleteAppointment(@PathVariable("id") Long id) {
        appointmentRepository.deleteById(id);
        return "redirect:/appointments";
    }
}