package play.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import play.dao.ReservationDao;
import play.dto.ReservationInfo;
import play.dto.ReservationPrice;
import play.service.ReservationService;

import java.util.List;

@Service
public class ReservationImpl implements ReservationService {

    @Autowired
    ReservationDao reservationDao;

    @Override
    public void setReservationInfo(ReservationInfo reservationInfo, List<ReservationPrice> prices) {
        int productId = reservationDao.getProductId(reservationInfo.getDisplayInfoId());
        int reservationInfoId = reservationDao.insertReservationInfo(reservationInfo, productId);
        reservationDao.insertReservationPrice(reservationInfoId, productId, prices);

    }

    @Override
    public String getEmail(String email) {
        String get = reservationDao.getEmail(email);
        return get;
    }

    @Override
    public List<ReservationInfo> getReservationInfo(String email) {
        return reservationDao.getReservationInfo(email);
    }
}
