package play.dao;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import play.config.ApplicationConfig;
import play.dto.Display;
import play.dto.ReservationInfo;
import play.dto.ReservationPrice;
import play.dto.ReservationUser;

import java.util.ArrayList;
import java.util.List;

public class ReservationTest {
    public static void main(String[] args) {
        ApplicationContext ac = new AnnotationConfigApplicationContext(ApplicationConfig.class);
        ReservationDao dao = ac.getBean(ReservationDao.class);
/*
        ReservationInfo ri = new ReservationInfo();
        ri.setDisplayInfoId(1);
        ri.setReservationName("문박순");
        ri.setReservationTel("010-2321-1232");
        ri.setReservationEmail("naver@naver.com");
        ri.setReservationDate("2021.06.03");

        int productId = dao.getProductId(ri.getDisplayInfoId());

        int id = dao.insertReservationInfo(ri, productId);
        System.out.println("id = " + id);

        List<ReservationPrice> list = new ArrayList<>();
        ReservationPrice rs = new ReservationPrice();
        rs.setPriceTypeName("A");
        rs.setPrice("6000");
        rs.setCount(3);
        list.add(rs);

        ReservationPrice rs2 = new ReservationPrice();
        rs2.setPriceTypeName("Y");
        rs2.setPrice("3000");
        rs2.setCount(4);
        list.add(rs2);

        int num = dao.insertReservationPrice(id, 1, list);
        System.out.println("num = " + num);*/

        List<ReservationInfo> rs = dao.getReservationInfo("naver@naver.com");
        System.out.println("rs = " + rs);

    }
}
