package kr.or.connect;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class AC04 {
    public static void main(String[] args) {
        ApplicationContext ac = new AnnotationConfigApplicationContext(ApplicationConfig2.class);

        Car car = (Car) ac.getBean(Car.class);
        car.run();

    }
}
