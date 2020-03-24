package Controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import java.util.HashMap;
import java.util.Map;

@Controller
public class DictionaryController {
    static Map<String, String> wordList;
    static {
        wordList = new HashMap<>();
        wordList.put("hello", "Xin chào");
        wordList.put("bye", "Tạm biệt");
    }
    @GetMapping("/dictionary")
    public ModelAndView display() {
        ModelAndView modelAndView = new ModelAndView("dictionary");
        return modelAndView;
    }
    @PostMapping("/dictionary")
    public ModelAndView search(@RequestParam("wordEN") String wordEN) {
        System.out.println(wordEN);
        String wordVI = wordList.get(wordEN);
        ModelAndView modelAndView = new ModelAndView("dictionary","wordVI", wordVI);

//        modelAndView.addObject("wordVI", wordVI);
        return modelAndView;
    }
}
