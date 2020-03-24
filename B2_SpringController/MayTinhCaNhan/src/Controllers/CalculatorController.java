package Controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class CalculatorController {
    @GetMapping("/calculate")
    public String display() {
        return "calculator";
    }

    @PostMapping("/calculate")
    public String calculate(Model model, @RequestParam("soThuNhat") int soThuNhat, @RequestParam("soThuHai") int soThuHai, @RequestParam("phepTinh") String phepTinh) {
        switch (phepTinh) {
            case "+":
                model.addAttribute("ketQua", soThuNhat + soThuHai);
                break;
            case "-":
                model.addAttribute("ketQua", soThuNhat - soThuHai);
                break;
            case "*":
                model.addAttribute("ketQua", soThuNhat * soThuHai);
                break;
            case "/":
                model.addAttribute("ketQua", soThuNhat / soThuHai);
                break;
        }

        return "calculator";
    }
}
