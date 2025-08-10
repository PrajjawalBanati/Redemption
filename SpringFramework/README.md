## Introduction

- Spring Framework is the ultimate framework to write Java based Enterprise Applications. 
- It simplified development by introducing many new inbuilt features like
    - Dependency Injection
    - Inversion of Control
    - Aspect Oriented Programming
    - Transaction Management

**Dependency Injection**

- It is a famous design pattern which allows us to inject the dependecies of a class so that they could be passed/injected during execution time rather than defining the dependency in the dependent class itself.

**Example**: Refer to the example below

- In traditional approach without Dependency Injection an object is responsible for creating its own dependencies.

```java
// The dependency
class Engine {
    public void start() {
        System.out.println("Engine started! 🚗");
    }
}

// The dependent class
class Car {
    // The Car creates its OWN Engine instance. It has control.
    private final Engine engine = new Engine();

    public void drive() {
        engine.start();
        System.out.println("Car is moving...");
    }
}

// Main application
public class Main {
    public static void main(String[] args) {
        Car myCar = new Car();
        myCar.drive();
    }
}
```

- In the above example the `Car` class is tightly coupled to the `Engine` class. In other words, as soon as we create Car object it will create an Engine Object. 

**Problems**

- Suppose now you have a requirement to use a different type of engine suppose `v8Engine` then you have modify the `Car` class code to use another class of `v8Engine`. This will make the whole system very hard to test because our unit test will be written basis on the Engine class.

- This is a bad design which will make you difficult to test many cases. If you will need to add more engine types then you have to add other instances in your `Car` class.

**How Dependency Injection solves the Problem ?**

- Dependency Injection as the word says refers to injecting dependencies. Now how we will do that lets see with the help of following example:

```java
// An interface for flexibility
interface Engine {
    void start();
}

// Concrete implementations of the dependency
class V8Engine implements Engine {
    @Override
    public void start() {
        System.out.println("V6 Engine started! 🏎️");
    }
}

class ElectricEngine implements Engine {
    @Override
    public void start() {
        System.out.println("Electric Engine started! ⚡");
    }
}

// The dependent class now accepts the dependency
class Car {
    private final Engine engine;

    // The Engine is "injected" via the constructor.
    // The Car has lost control of creating its dependency.
    public Car(Engine engine) {
        this.engine = engine;
    }

    public void drive() {
        engine.start();
        System.out.println("Car is moving...");
    }
}

// Client application - now acts as the "injector" or container
public class Client {
    public static void main(String[] args) {
        // We decide WHICH engine to create and pass to the car.
        Engine myEngine = new V6Engine(); // Or new ElectricEngine()
        Car myCar = new Car(myEngine);
        myCar.drive();
    }
}
```

- The above example we take care of deciding which engine needs to be created. We create that engine instance and pass it as an argument to the constructor of the Car object. By following this principle you are loosely coupling your instances and its very easy to add another engine type.

**Inversion Of Control (IoC)**

- Inversion of Control is a principle which transfers the creation of objects or some portions of a program to a container. 
- If you see the definition of Client class, you see that we are creating Engine and Car Objects. So the transfer of object creation is done to an external class.

```java
// Client application - now acts as the "injector" or container
public class Client {
    public static void main(String[] args) {
        // We decide WHICH engine to create and pass to the car.
        Engine myEngine = new V6Engine(); // Or new ElectricEngine()
        Car myCar = new Car(myEngine);
        myCar.drive();
    }
}
```

- This principle is called as Inversion of Control and we are able to achieve it using many design patterns such as 
    - Dependency Injection 
    - Strategy Design Pattern
    - Service Locator Pattern
    - Factor Design Pattern

- This makes the whole system decoupled which makes it easier for us to:
    - execute tasks
    - switch between different objects to execute
    - break whole system into executable modules

**How Spring implements IoC ?**

This example demonstrates how to build a modular, flexible application where an object (`Car`) depends on an abstraction (`Engine`) and selects the desired implementation (`V8Engine` or `ElectricEngine`) dynamically at runtime using a factory, while still leveraging Spring's powerful IoC container.

---

**1. `Engine.java` – Interface**

```java
package org.IoCImplementation;

public interface Engine {
    void start();
}
```

---

**2. `V8Engine.java` – One implementation**

```java
package org.IoCImplementation;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

@Component("v8Engine")
public class V8Engine implements Engine {
    private static final Logger logger = LoggerFactory.getLogger(V8Engine.class);

    public V8Engine() {
        logger.info("V8Engine bean created");
    }

    @Override
    public void start() {
        logger.info("V8 Engine started");
    }
}
```

---

**3. `ElectricEngine.java` – Another implementation**

```java
package org.IoCImplementation;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

@Component("electricEngine")
public class ElectricEngine implements Engine {
    private static final Logger logger = LoggerFactory.getLogger(ElectricEngine.class);

    public ElectricEngine() {
        logger.info("ElectricEngine bean created");
    }

    @Override
    public void start() {
        logger.info("Electric Engine started");
    }
}
```

---

**4. `EngineFactory.java` – Factory to resolve engine by name**

```java
package org.IoCImplementation;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.Map;

@Component
public class EngineFactory {
    private static final Logger logger = LoggerFactory.getLogger(EngineFactory.class);
    private final Map<String, Engine> engineMap;

    @Autowired
    public EngineFactory(Map<String, Engine> engineMap) {
        this.engineMap = engineMap;
        logger.info("EngineFactory initialized with engines: {}", engineMap.keySet());
    }

    public Engine getEngine(String engineType) {
        logger.info("Fetching engine: {}", engineType);
        Engine engine = engineMap.get(engineType);
        if (engine == null) {
            logger.error("No engine found for type: {}", engineType);
            throw new RuntimeException("No engine found for type: " + engineType);
        }
        return engine;
    }
}
```

---

**5. `Car.java` – Depends on the factory, not engine directly**

```java
package org.IoCImplementation;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class Car {
    private static final Logger logger = LoggerFactory.getLogger(Car.class);
    private final EngineFactory engineFactory;

    @Autowired
    public Car(EngineFactory engineFactory) {
        this.engineFactory = engineFactory;
        logger.info("Car bean created with EngineFactory");
    }

    public void driveCar(String engineType) {
        logger.info("driveCar() called with engineType: {}", engineType);
        Engine engine = this.engineFactory.getEngine(engineType);
        engine.start();
        logger.info("Car driving...");
    }
}
```

---

**6. `AppConfig.java` – Configuration and component scan**

```java
package org.IoCImplementation;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

@Configuration
@ComponentScan(basePackages = "org.IoCImplementation")
public class AppConfig {
}
```

---

**7. `Client.java` – Main method to run the app**

```java
package org.IoCImplementation;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class Client {
    public static void main(String[] args) {
        ApplicationContext applicationContext = new AnnotationConfigApplicationContext(AppConfig.class);
        System.out.println("Spring Application Context initialized");
        Car myCar = applicationContext.getBean(Car.class);
        myCar.driveCar("v8Engine"); // Try changing to "electricEngine"
    }
}
```

---

**🔄 Execution Flow (How IoC Works Here)**

1. **Startup**: Spring creates an `AnnotationConfigApplicationContext` and scans the package `org.IoCImplementation`.

2. **Bean Registration**: It finds and instantiates:
   - `V8Engine` and `ElectricEngine` (as `Engine` beans)
   - `EngineFactory` (with a map of all `Engine` beans auto-injected)
   - `Car` (with `EngineFactory` injected)

3. **Runtime Execution**:  
   - `Client` fetches the `Car` bean from the Spring context.  
   - It calls `driveCar("v8Engine")`  
   - `Car` calls `engineFactory.getEngine("v8Engine")`  
   - The factory returns the appropriate `Engine` bean (`V8Engine`)  
   - `engine.start()` is executed → logs the action

4. **IoC in Action**:  
   All object creation and dependency wiring is **handled by Spring**.  
   You **only interact with the already-wired beans**, making the system modular and extensible.

---

**Introduction to Java Beans()**

- 