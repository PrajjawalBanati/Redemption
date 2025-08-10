package org.IoCImplementation;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class Car {
    private final EngineFactory engineFactory;
    @Autowired
    public Car(EngineFactory engineFactory)
    {
        this.engineFactory = engineFactory;
        System.out.println("Car bean created with EngineFactory");
    }
    public void driveCar(String engineType){
        System.out.println("Car.driveCar() called with: " + engineType);
        Engine engine = this.engineFactory.getEngine(engineType);
        engine.start();
        System.out.println("Car driving");
    }
}
