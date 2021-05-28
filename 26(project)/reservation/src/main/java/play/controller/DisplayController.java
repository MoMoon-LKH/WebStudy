package play.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import play.dto.Display;
import play.dto.ItemPrice;
import play.dto.UserComment;
import play.service.DisplayService;

import javax.servlet.http.HttpServletRequest;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Controller
public class DisplayController {
    @Autowired
    DisplayService displayService;

    @GetMapping("/detail/{displayId}")
    public String getDisplay(@PathVariable(name = "displayId") int id,
                                          Model model) {
        model.addAttribute("id", id);
        return "detail";
    }

    @GetMapping("/reservation/{displayId}")
    public String getReservation(@PathVariable(name = "displayId", required = true) int id,
                                 Model model) {
        model.addAttribute("id", id);
        return "reservation";
    }

    @GetMapping("/main")
    public String getMain(){
        return "products";
    }
}
