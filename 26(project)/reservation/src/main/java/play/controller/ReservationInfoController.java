package play.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import play.dto.ReservationPrice;
import play.dto.ReservationUser;
import play.service.ReservationService;
import java.util.ArrayList;
import java.util.List;

@Controller
public class ReservationInfoController {

    @Autowired
    ReservationService reservationService;

    @PostMapping("/reservations")
    public String setReservation(@RequestParam(name = "id", required = true) int id,
                                 @RequestParam(name = "priceType[]") List<String> priceType,
                                 @RequestParam(name = "ticketNum[]") List<Integer> ticketNum,
                                 @RequestParam(name = "name") String name,
                                 @RequestParam(name = "tel") String tel,
                                 @RequestParam(name = "email") String email,
                                 @RequestParam(name = "regDate") String regDate) {

        ReservationUser reservationUser = new ReservationUser();
        reservationUser.setDisplayInfoId(id);
        reservationUser.setReservationName(name);
        reservationUser.setReservationTel(tel);
        reservationUser.setReservationEmail(email);
        reservationUser.setReservationDate(regDate);

        List<ReservationPrice> list = new ArrayList<>();
        for (int i = 0; i < priceType.size(); i++) {
            if (ticketNum.get(i) != 0) {
                ReservationPrice reservationPrice = new ReservationPrice();
                reservationPrice.setPriceTypeName(priceType.get(i));
                reservationPrice.setCount(ticketNum.get(i));
                list.add(reservationPrice);
            }
        }

        reservationService.setReservationInfo(reservationUser, list);

        return "redirect:/main";
    }


}
