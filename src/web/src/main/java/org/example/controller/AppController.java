package org.example.controller;

import org.example.model.AppModel;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class AppController {

    @RequestMapping("/")
    public String output(@RequestParam(name="output", required=false, defaultValue = "Enter values below, then select an operation") String output,
            @RequestParam(name="values", required=false, defaultValue = "") String values,
            @RequestParam(name="isError", required=false, defaultValue="false") boolean isError,
            @RequestParam(name="method", required=false, defaultValue="0") String operation, Model model) {

        AppModel calcModel = new AppModel(values, operation, false);
        calcModel.calculateData();

        model.addAttribute("isError", calcModel.isError());
        model.addAttribute("output", calcModel.getOperation());
        model.addAttribute("values", values);
        return "index";
    }

}