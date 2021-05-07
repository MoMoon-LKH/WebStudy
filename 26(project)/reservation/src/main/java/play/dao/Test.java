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

        List<Integer> list = pd.productCount();
        int count = 0;
        int tabNum = 0;
        if(tabNum > 0 ){
            count = list.get(tabNum - 1);
        } else{
            for (int i = 0; i < list.size(); i++) {
                count += list.get(i);
            }
        }
        System.out.println("count = " + count);
        /*List<Item> list = pd.products(5,0, 4);
        System.out.println("list = " + list);
*/
    }
}
