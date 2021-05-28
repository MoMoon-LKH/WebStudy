package play.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

@Controller
public class ReservationInfoController {

    @PostMapping("/reservations")
    public String setReservation(@RequestParam(name = "id" , required = true) int id,
                                 @RequestParam(name = "priceType[]") List<String> priceType,
                                 @RequestParam(name = "ticketNum[]") List<Integer> ticketNum,
                                 @RequestParam(name = "name") String name,
                                 @RequestParam(name = "tel") String tel,
                                 @RequestParam(name = "email") String email,
                                 @RequestParam(name = "regDate") String regDate){
        System.out.println("id = " + id);
        System.out.println("priceType = " + priceType);
        System.out.println("ticketNum = " + ticketNum);
        System.out.println("name = " + name);
        System.out.println("tel = " + tel);
        System.out.println("email = " + email);
        System.out.println("regDate = " + regDate);
        return "redirect:/main";
    }

    @GetMapping("/loginForm")
    public String loginForm(){

        return "loginForm";
    }
}
