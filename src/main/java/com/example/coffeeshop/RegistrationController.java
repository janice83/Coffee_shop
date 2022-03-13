package com.example.coffeeshop;

import javax.validation.Valid;

import com.example.coffeeshop.Services.RegistrationService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class RegistrationController {

    @Autowired
    private RegistrationRepository registrationRepository;

    @Autowired
    private RegistrationService registrationService;

    @ModelAttribute
    private Registration getRegistration() {
        return new Registration();
    }

    @GetMapping("/vip")
    public String view() {
        return "vip";
    }

    @PostMapping("/registrations")
    public String register(@Valid
            @ModelAttribute Registration registration,
            BindingResult bindingResult) {
                if (bindingResult.hasErrors()) {
                    return "vip";
                }
        registrationService.addVip(registration);
        return "redirect:/";
    }

}
