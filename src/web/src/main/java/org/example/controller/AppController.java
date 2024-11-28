package org.example.controller;

import org.example.model.AppModel;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class AppController {

    @RequestMapping("/")
    public String output(@RequestParam(name="values", required=false, defaultValue = "") String values,
            @RequestParam(name="method", required=false, defaultValue="-1") String method, Model model) {

        AppModel calcModel = new AppModel(values, method, false);
        calcModel.calculateData();

        model.addAttribute("isError", calcModel.getError());
        model.addAttribute("output", calcModel.getOperation());
        model.addAttribute("values", calcModel.getValues());
        return "index";
    }

}