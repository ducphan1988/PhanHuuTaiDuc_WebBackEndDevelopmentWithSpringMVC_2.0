package Controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.Arrays;

@Controller
public class SandwichController {
    @RequestMapping(value = "/save-sandwich", method = RequestMethod.GET)
    public String display() {
        return "sandwich";
    }
    @RequestMapping(value = "/save-sandwich", method = RequestMethod.POST)
    public String save(@RequestParam("condiment") String[] condiment, Model model) {
        model.addAttribute("condiment", Arrays.toString(condiment));
        return "sandwich";
    }
}
