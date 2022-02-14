package lada.springCourse.config.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import javax.servlet.http.HttpServletRequest;

@Controller
@RequestMapping("/first")
public class FirstController {

    @GetMapping("/hello")
    public String helloPage(@RequestParam(value = "name", required = false) String name,
                            @RequestParam(value = "surname", required = false) String surname,
                            Model model) {
        model.addAttribute("message", "Hello, " + name + " " + surname);
        //System.out.println("Hello, " + name + " " + surname );
        return "first/hello";
    }

    @GetMapping("/goodbye")
    public String goodbyePage() {
        return "first/goodbye";
    }

    @GetMapping("/calculator")
    public String calculatorPage(@RequestParam(value = "a") double a,
                                 @RequestParam(value = "b") double b,
                                 @RequestParam(value = "action") String action,
                                 Model model) {
        switch (action) {
            case "multiplication":
                model.addAttribute("result", "result = " + a * b);
                break;
            case "addition":
                model.addAttribute("result", "result = " + a + b);
                break;
            case "subtraction":
                model.addAttribute("result", "result = " + (a - b));
                break;
            case "division":
                model.addAttribute("result", "result = " + a / b);
                break;
            default:
                model.addAttribute("result", "Invalid operation");

        }

        return "first/calculator";
    }
}
