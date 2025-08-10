package org.IoCImplementation;

import org.springframework.stereotype.Component;

@Component("electricEngine")
public class ElectricEngine implements Engine{
    public ElectricEngine()
    {
        System.out.println("ElectricEngine bean created");
    }
    @Override
    public void start() {
        System.out.println("Electric Engine started");
    }
}
