package guestbook.service.impl;

import guestbook.config.ApplicationConfig;
import guestbook.dto.Guestbook;
import guestbook.service.GuestbookService;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import java.util.Date;

public class GuestbookServiceTest {
    public static void main(String[] args) {
        ApplicationContext ac = new AnnotationConfigApplicationContext(ApplicationConfig.class);
        GuestbookService gs = ac.getBean(GuestbookService.class);
        System.out.println("gs = " + gs);

        Guestbook guestbook = new Guestbook();
        guestbook.setName("guest3");
        guestbook.setContent("반갑습니다2.");
        guestbook.setRegdate(new Date());
        Guestbook result = gs.addGuestbook(guestbook, "127.0.0.1");
        System.out.println("result = " + result);
    }
}
