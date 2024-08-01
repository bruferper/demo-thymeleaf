package com.bfz.demo_thymeleaf.infrastructure.adapter.in.web;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

/**
 * @author bruferper
 */

@Controller
@RequestMapping("/")
public class RootController {

    @GetMapping
    public String index() {
        return "redirect:/dashboard";
    }

}
