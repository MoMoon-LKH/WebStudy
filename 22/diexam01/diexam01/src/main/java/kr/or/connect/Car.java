package kr.or.connect;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class Car {
    @Autowired
    private Engine v8;

    public Car(){
        System.out.println("Car 생성자");
    }

    public void setEngine(Engine e){
        this.v8 = e;
    }

    public void run(){
        System.out.println("run");
        v8.exec();
    }

    /*public static void main(String[] args){
        Engine e = new Engine();
        Car c = new Car();
        c.setEngine(e);
        c.run();
    }*/
}
