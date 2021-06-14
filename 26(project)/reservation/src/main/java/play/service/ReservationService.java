package play.service;

import play.dto.ReservationInfo;
import play.dto.ReservationPrice;
import play.dto.ReservationUser;

import java.util.List;

public interface ReservationService {
    public void setReservationInfo(ReservationUser reservationUser, List<ReservationPrice> prices);
    public String getEmail(String email);
    public List<ReservationInfo> getReservationInfo(String email);
    public void updateCancelFlag(int reservationId);
    public String getEmailFromId(int reservationId);
}
