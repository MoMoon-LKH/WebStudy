package play.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import play.dto.Display;
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

    @GetMapping("/products/{displayId}")
    public String getDisplay(@PathVariable(name = "displayId") int id,
                                          Model model) {
        List<Display> display = displayService.getDisplay(id);
        List<UserComment> comments = displayService.getUserComment(id);
        String avgScore = displayService.getAverageScore(comments);

        model.addAttribute("display", display);
        model.addAttribute("comments", comments);
        model.addAttribute("avgScore", avgScore);
        return "detail";
    }
}
