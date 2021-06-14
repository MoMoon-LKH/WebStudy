package play.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import play.dao.DisplayDao;
import play.dao.ReservationDao;
import play.dto.ReservationInfo;
import play.dto.ReservationPrice;
import play.dto.ReservationUser;
import play.service.ReservationService;

import java.util.List;

@Service
public class ReservationImpl implements ReservationService {

    @Autowired
    ReservationDao reservationDao;

    @Autowired
    DisplayDao displayDao;

    @Override
    public void setReservationInfo(ReservationUser reservationUser, List<ReservationPrice> prices) {
        int productId = reservationDao.getProductId(reservationUser.getDisplayInfoId());
        int reservationInfoId = reservationDao.insertReservationInfo(reservationUser, productId);
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

    @Override
    public void updateCancelFlag(int reservationId) {
        reservationDao.updateCancelFlag(reservationId);
    }

    @Override
    public String getEmailFromId(int reservationId) {
        return reservationDao.getEmailFromId(reservationId);
    }
}
