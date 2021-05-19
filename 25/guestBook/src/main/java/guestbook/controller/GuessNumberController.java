package guestbook.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.view.InternalResourceViewResolver;

import javax.servlet.http.HttpSession;

@Controller
public class GuessNumberController {

    @GetMapping("/guess")
    public String guess(@RequestParam(name = "number", required = false) Integer number,
                        HttpSession session,
                        ModelMap model) {

        String message = null;

        if (number == null) {
            session.setAttribute("count", 0);
            session.setAttribute("randomNumber", (int) (Math.random() * 100) + 1);
            message = "내가 생각한 숫자를 맞춰보세요";

        } else{
            int count = (Integer) session.getAttribute("count");
            int randomNumber = (Integer) session.getAttribute("randomNumber");

            if (number < randomNumber) {
                message = "입력 값은 정답 값보다 작습니다.";
                session.setAttribute("count",++count);
            } else if (number > randomNumber) {
                message = "입력 값은 정답 값보다 큽니다.";
                session.setAttribute("count", ++count);
            } else {
                message = "OK " + ++count + "번째 맞췄습니다. 정답 값은 " + number + "입니다";
                session.removeAttribute("count");
                session.removeAttribute("randomNumber");

            }

        }
        model.addAttribute("message", message);

        return "guess";

    }
}
