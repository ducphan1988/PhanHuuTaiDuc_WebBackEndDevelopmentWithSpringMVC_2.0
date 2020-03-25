package com.codegym.inotes.controller;

import com.codegym.inotes.model.NoteType;
import com.codegym.inotes.service.NoteTypeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class NoteTypeController {
    @Autowired
    private NoteTypeService noteTypeService;

    @GetMapping("/notetype/create")
    public ModelAndView showCreateNoteTypeForm(){
        ModelAndView modelAndView = new ModelAndView("notetype/create");
        modelAndView.addObject("notetype",new NoteType());
        return modelAndView;
    }
    @PostMapping("/notetype/create")
    public ModelAndView createNoteType(@Validated @ModelAttribute("notetype") NoteType noteType, BindingResult bindingResult){
        Iterable<NoteType> noteTypes = noteTypeService.findAll();

        if (bindingResult.hasFieldErrors()){
            ModelAndView modelAndView = new ModelAndView("notetype/create");
            modelAndView.addObject("notetype", new NoteType());
            modelAndView.addObject("notetypes", noteTypes);
            modelAndView.addAllObjects(bindingResult.getModel());
            return modelAndView;
        } else {
            noteTypeService.save(noteType);
            ModelAndView modelAndView = new ModelAndView("redirect:/");
            modelAndView.addObject("notetype", new NoteType());
            modelAndView.addObject("success","Da tao thanh cong");
            return modelAndView;
        }

    }

}
