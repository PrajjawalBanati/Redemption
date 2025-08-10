package org.IoCImplementation;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class Client {
    public static void main(String[] args) {
        /**
         * Engine v8Engine = new V8Engine();
         * Car carObj = new Car(v8Engine);
         * carObj.driveCar();
         */
        ApplicationContext applicationContext = new AnnotationConfigApplicationContext(AppConfig.class);
        System.out.println("Spring Application Context initialized");
        Car myCar = applicationContext.getBean(Car.class);
        myCar.driveCar("v8Engine");
    }
}
