package org.example;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.Objects;

@Controller
public class AppController {

    @RequestMapping("/")
    public String output(@RequestParam(name="output", required=false, defaultValue = "Enter values below, then select an operation") String output,
            @RequestParam(name="values", required=false, defaultValue = "") String values,
            @RequestParam(name="isError", required=false, defaultValue="false") boolean isError,
            @RequestParam(name="method", required=false, defaultValue="0") String operation, Model model) {

        if(!values.isEmpty()) {
            isError = false;
        }   else {
            isError = true;
            output = "big fat failiure";
        }
        model.addAttribute("isError", isError);
        model.addAttribute("output", output);
        model.addAttribute("method", operation);
        return "index";
    }

}