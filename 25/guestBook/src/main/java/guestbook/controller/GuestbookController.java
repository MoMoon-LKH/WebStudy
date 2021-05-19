package guestbook.controller;

import guestbook.dto.Guestbook;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.*;
import guestbook.service.GuestbookService;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.ArrayList;
import java.util.List;

@Controller
public class GuestbookController {
    @Autowired
    GuestbookService guestbookService;


    @GetMapping(path="/list")
    public String list(@RequestParam(name="start", required=false, defaultValue="0") int start,
                       ModelMap model,
                       @CookieValue(value="count", defaultValue = "0",required = true) String value,
                       HttpServletResponse response) {


        try {
            int i = Integer.parseInt(value);
            value = Integer.toString(++i);
        } catch (Exception exception) {
            value = "1";
        }


        Cookie cookie = new Cookie("count", value);
        cookie.setMaxAge(60*60*24*365);
        cookie.setPath("/"); // 하위 경로에 쿠키 적용
        response.addCookie(cookie);

        List<Guestbook> list = guestbookService.getGuestbooks(start);

        int count = guestbookService.getCount();
        int pageCount = count / GuestbookService.LIMIT;
        if(count % GuestbookService.LIMIT > 0)
            pageCount++;

        List<Integer> pageStartList = new ArrayList<>();
        for(int i = 0; i < pageCount; i++) {
            pageStartList.add(i * GuestbookService.LIMIT);
        }

        model.addAttribute("list", list);
        model.addAttribute("count", count);
        model.addAttribute("pageStartList", pageStartList);
        model.addAttribute("cookieCount", value);

        return "list";
    }

    @PostMapping(path="/write")
    public String write(@ModelAttribute Guestbook guestbook,
                        HttpServletRequest request) {
        String clientIp = request.getRemoteAddr();
        System.out.println("clientIp : " + clientIp);
        guestbookService.addGuestbook(guestbook, clientIp);
        return "redirect:list";
    }
}
