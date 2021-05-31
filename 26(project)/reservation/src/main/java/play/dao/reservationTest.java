package play.dao;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import play.config.ApplicationConfig;
import play.dto.ReservationInfo;

public class reservationTest {
    public static void main(String[] args) {
        ApplicationContext ac = new AnnotationConfigApplicationContext(ApplicationConfig.class);
        ReservationDao dao = ac.getBean(ReservationDao.class);

        ReservationInfo ri = new ReservationInfo();
        ri.setDisplayInfoId(1);
        ri.setReservationName("문박순");
        ri.setReservationTel("010-2321-1232");
        ri.setReservationEmail("naver@naver.com");
        ri.setReservationDate("2021.06.03");

        int id = dao.insertReservationInfo(ri);
        System.out.println("id = " + id);

    }
}
