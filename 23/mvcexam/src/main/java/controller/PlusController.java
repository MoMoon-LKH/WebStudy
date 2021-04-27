package controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class PlusController {
    @GetMapping(path = "/plusForm")
    public String plusFrom() {
        return "plusForm";
    }

    @PostMapping(path = "/plus")
    public String plus(@RequestParam(name = "value1") int value1,
                       @RequestParam(name = "value2") int value2, ModelMap model){
        int result = value1 + value2;

        model.addAttribute("value1", value1);
        model.addAttribute("value2", value2);
        model.addAttribute("result", result);

        return "plusResult";
    }



}
