package play.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.SessionAttribute;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;
import play.service.ReservationService;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

@Controller
public class EmailLogin {

    @Autowired
    ReservationService reservationService;

    @GetMapping("/loginForm")
    public String loginForm() {

        return "loginForm";
    }

    @PostMapping("/login")
    public String login(@RequestParam(name = "email") String email,
                        HttpSession session,
                        RedirectAttributes redirectAttr,
                        ModelMap model,
                        HttpServletResponse response) {

        String getEmail = reservationService.getEmail(email);

        if (getEmail != null) {
            session.setAttribute("admin", "true");
        } else{
            redirectAttr.addFlashAttribute("errorMessage", "예약된 이메일이 아닙니다.");
            return "redirect:/loginForm";
        }

        Cookie cookie = new Cookie("email", email);
        cookie.setMaxAge(60 * 30);
        cookie.setPath("/");
        response.addCookie(cookie);

        model.addAttribute("email", email);

        return "myReservation";
    }

    @GetMapping("/logout")
    public String logout(HttpSession session) {
        session.removeAttribute("admin");
        return "redirect:/main";
    }
}
