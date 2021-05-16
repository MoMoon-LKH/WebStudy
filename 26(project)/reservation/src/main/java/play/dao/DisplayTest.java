package play.dao;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import play.config.ApplicationConfig;
import play.dto.Display;
import play.dto.UserComment;

import java.util.List;

public class DisplayTest {
    public static void main(String[] args) {

        ApplicationContext ac = new AnnotationConfigApplicationContext(ApplicationConfig.class);
        DisplayDao dao = ac.getBean(DisplayDao.class);
/*

        List<Display> dis = dao.getDisplay(1);
        System.out.println("dis = " + dis);
*/

/*
        List<UserComment> us = dao.getUserComment(1);
        System.out.println("us = " + us);
*/
        List<String> list = dao.getImages(50);
        System.out.println("list = " + list);

        String st = dao.getMap(50);
        System.out.println("st = " + st);

    }
}
