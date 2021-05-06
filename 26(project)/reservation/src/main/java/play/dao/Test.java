package play.dao;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import play.config.ApplicationConfig;
import play.dto.Item;

import java.util.List;

public class Test {
    public static void main(String[] args) {
        ApplicationContext ac = new AnnotationConfigApplicationContext(ApplicationConfig.class);

        ProductDao pd = ac.getBean(ProductDao.class);

        List<Item> list = pd.products(0,31, 4);

        for (Item item : list) {
            System.out.println("item = " + item);
            System.out.println("==============================");

        }
    }
}
