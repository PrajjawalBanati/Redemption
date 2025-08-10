package org.IoCImplementation;

import org.springframework.stereotype.Component;

@Component("v8Engine")
public class V8Engine implements Engine{
    public V8Engine(){
        System.out.println("V8Engine bean created");
    }
    @Override
    public void start() {
        System.out.println("V8 Engine started");
    }
}
