package guestbook.dao;

import guestbook.config.ApplicationConfig;
import guestbook.dto.Log;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import java.util.Date;

public class GuestbookDaoTest {
    public static void main(String[] args) {
        ApplicationContext ac = new AnnotationConfigApplicationContext(ApplicationConfig.class);

        /*GuestbookDao guestbookDao = ac.getBean(GuestbookDao.class);

        Guestbook guestbook = new Guestbook();
        guestbook.setName("강경미");
        guestbook.setContent("반갑습니다. 여러분");
        guestbook.setRegdate(new Date());
        Long id = guestbookDao.insertRow(guestbook);
        System.out.println("id = " + id);*/

        LogDao logDao = ac.getBean(LogDao.class);
        Log log = new Log();
        log.setIp("127.0.0.1");
        log.setMethod("insert");
        log.setRegdate(new Date());
        logDao.insertRow(log);
    }
}
