package controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestHeader;

import javax.servlet.http.HttpServletRequest;

@Controller
public class GoodsController {

    @GetMapping("/goods/{id}")
    public String getGoodsbyId(@PathVariable(name = "id") int id,
                               @RequestHeader(value = "User-Agent", defaultValue = "myBrowser") String userAgent,
                               HttpServletRequest request,
                               ModelMap modelMap) {

        String path = request.getServletPath();

        System.out.println("id : " + id);
        System.out.println("user-agent : " + userAgent);
        System.out.println("path : " + path);

        modelMap.addAttribute("id", id);
        modelMap.addAttribute("userAgent", userAgent);
        modelMap.addAttribute("path", path);

        return "goodsById";
    }
}
