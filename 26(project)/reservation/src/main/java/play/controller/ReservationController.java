package play.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import play.dto.Display;
import play.dto.ItemPrice;
import play.dto.ReservationInfo;
import play.service.DisplayService;
import play.service.ReservationService;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletResponse;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/reservationInfo")
public class ReservationController {
    @Autowired
    DisplayService displayService;

    @Autowired
    ReservationService reservationService;

    @GetMapping("/{displayId}")
    public Map<String, Object> getReservationInfo(@PathVariable(name = "displayId", required = true) int id) {
        List<Display> displays = displayService.getDisplay(id);
        List<ItemPrice> itemPrices = displayService.getPrice(id);
        List<String> images = displayService.getImages(id);
        String image = images.get(0);
        String reservationDate = displayService.getReservationDate();

        Map<String, Object> map = new HashMap<>();

        map.put("display", displays);
        map.put("itemPrices", itemPrices);
        map.put("image", image);
        map.put("reservationDate", reservationDate);

        return map;
    }

    @GetMapping("/myReservation")
    public Map<String, Object> getMyReservation(@RequestParam(name = "email") String email) {
        Map<String, Object> map = new HashMap<>();
        List<ReservationInfo> reservationInfos = reservationService.getReservationInfo(email);

        map.put("reservationInfo", reservationInfos);

        return map;
    }
}
