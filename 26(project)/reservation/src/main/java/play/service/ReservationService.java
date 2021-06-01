package play.service;

import play.dto.ReservationInfo;
import play.dto.ReservationPrice;

import java.util.List;

public interface ReservationService {
    public void setReservationInfo(ReservationInfo reservationInfo, List<ReservationPrice> prices);
    public String getEmail(String email);
    public List<ReservationInfo> getReservationInfo(String email);
}
