package org.IoCImplementation;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;


import java.util.Map;

@Component
public class EngineFactory {
    private final Map<String, Engine> engineMap;

    @Autowired
    public EngineFactory(Map<String,Engine> engineMap)
    {
        this.engineMap = engineMap;
        System.out.println("EngineFactory bean created with engines: " + engineMap.keySet());

    }

    public Engine getEngine(String engineType)
    {
        System.out.println("Fetching engine of type: " + engineType);
        Engine engine = this.engineMap.get(engineType);
        if(engine==null){
            throw new RuntimeException("No new engine found");
        }
        else {
            return engine;
        }
    }
}
