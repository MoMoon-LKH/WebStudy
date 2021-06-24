package play.service.impl;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import play.config.ApplicationConfig;
import play.service.DisplayService;

public class DisplayTest {
    public static void main(String[] args) {
        ApplicationContext ac = new AnnotationConfigApplicationContext(ApplicationConfig.class);

        DisplayService dis = ac.getBean(DisplayService.class);
/*
        List<UserComment> list = dis.getUserComment(1);
        System.out.println("list = " + list);*/
        /*String num = dis.getAverageScore(list);

        System.out.println("num = " + num);*/
        System.out.println(dis.getReservationDate());
    }
}
