package play.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.bind.support.SessionStatus;
import play.dto.ReservationInfo;
import play.dto.ReservationPrice;
import play.service.ReservationService;

import javax.net.ssl.HttpsURLConnection;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpSession;
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

        ReservationInfo reservationInfo = new ReservationInfo();
        reservationInfo.setDisplayInfoId(id);
        reservationInfo.setReservationName(name);
        reservationInfo.setReservationTel(tel);
        reservationInfo.setReservationEmail(email);
        reservationInfo.setReservationDate(regDate);

        List<ReservationPrice> list = new ArrayList<>();
        for (int i = 0; i < priceType.size(); i++) {
            ReservationPrice reservationPrice = new ReservationPrice();
            reservationPrice.setPriceTypeName(priceType.get(i));
            reservationPrice.setCount(ticketNum.get(i));
            list.add(reservationPrice);
        }

        reservationService.setReservationInfo(reservationInfo, list);

        return "redirect:/main";
    }


}
