package com.codegym.controller;

import com.codegym.model.PhoneNumber;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.ModelAndView;

import javax.validation.Valid;

@Controller
public class PhoneController {

    @GetMapping("/phoneNumber")
    public ModelAndView showForm() {
        return new ModelAndView("/phoneNumber/index", "phoneNumber", new PhoneNumber());
    }

    @PostMapping("/phoneNumber")
    public ModelAndView checkValidation(@Valid @ModelAttribute("phoneNumber") PhoneNumber phoneNumber,
                                        BindingResult bindingResult) {
        new PhoneNumber().validate(phoneNumber, bindingResult);
        if (bindingResult.hasFieldErrors()) {
            return new ModelAndView("/phoneNumber/index");
        } else {
            return new ModelAndView("/phoneNumber/result", "phoneNumber", phoneNumber);
        }
    }
}
