package com.cal
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class CalculatorController {

    @GetMapping("/")
    public String greeting() {
        return "calculator";
    }

    @GetMapping("/calculate")
    public String calculate(@RequestParam int a, @RequestParam int b, @RequestParam String operation, Model model) {
        SimpleCalculator calculator = new SimpleCalculator();
        int result = switch (operation) {
            case "add" -> calculator.add(a, b);
            case "subtract" -> calculator.subtract(a, b);
            default -> 0;
        };
        model.addAttribute("result", result);
        return "calculator";
    }
}
