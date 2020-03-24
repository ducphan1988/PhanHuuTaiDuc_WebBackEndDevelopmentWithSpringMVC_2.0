package com.codegym.controller;

import com.codegym.service.ImageService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class ImageController {
    @Autowired
    ImageService imageService;

    @GetMapping("/image/{id}")
    public ModelAndView showEdit(@PathVariable Long id) {
        return new ModelAndView("image","image",imageService.findById(id));
    }



}
