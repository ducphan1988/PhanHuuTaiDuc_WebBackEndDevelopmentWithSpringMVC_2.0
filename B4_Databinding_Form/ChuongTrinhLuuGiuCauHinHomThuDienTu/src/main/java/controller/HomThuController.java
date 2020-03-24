package controller;

import model.HomThu;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
@RequestMapping("hom-thu/")
public class HomThuController {
    @RequestMapping(value = "showForm", method = RequestMethod.GET)
    public String showForm(ModelMap model) {
        model.addAttribute("homThu", new HomThu());
        return "hom-thu/create";
    }
    @RequestMapping(value = "/add", method = RequestMethod.POST)
    public String submit(@ModelAttribute("homThu") HomThu homThu, BindingResult result, ModelMap model) {
        model.addAttribute("lang", homThu.getLang());
        model.addAttribute("pageSize", homThu.getPageSize());
        model.addAttribute("signature", homThu.getSignature());
        return "hom-thu/detail";
    }
}
