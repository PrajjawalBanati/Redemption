# Design Patterns

Design Patterns are certain type of conventions which developers usually follow to make sure that classes and object creation is more flexible and structural keeping in mind the communication between them is also seamless.

Mainly there are three categories in which we can divide design patterns

- Creational Design Patterns
    - These design patterns usually take care of the creation of objects and classes. 
    - These patterns basically tells us on how to create objects depending on the constraints and restrictions we have.
    - Best example is you need an object which is responsible to write log files and debug statements.
    - Since you will need to have this object in almost each statement we will not initialise and define it in every class we are calling. (That may lead to multiple file creations or you may end up getting a specific class level log lines.)
    - So here we have constraint to only have a single object of this class and that single object itself is called in every class and taking care of the debugging.
    - This is just one example. We can have multiple constraints and multiple requirements which we need to take care of so that our code is flexible.
    - And for that if we will make the creation for objects and classes flexible using Creational Design Patterns we will be in a good condition.

- Structural Design Patterns
    - Now you took care of creation of objects and classes, what else you need to take care of while designing the system ? Assembly. Think of it as we are putting all our classes and objects and assembling them to form a bigger structure which are extensible yet flexible.
    - These patterns usually takes care of assembling two or more classes with each other so that both classes structure also remains conserved and your assembled design also works.
    - Best Example is of SDKs of huge libraries. Suppose you have an SDK of langgraph and now you have to use its functions in your code. Will you call the langgraph module function directly to your code ? Assume you did that and used some ***xyz()*** function in your code. After sometime that ***xyz()*** is deprecated and they have changed its way of usage. Now your code won't work in the latest version of your SDK because that function is deprecated and is not used anymore.
    - If you are planning it to change the function at all the places, that's just bad design. Your design is not flexible at all to new changes. 
    - So in these cases these design patterns come to help you where you somehow assemble them in such a way that even these deprecations will not affect your design and you will be good in a one line change in your code.

- Behavioral Design Patterns
    - These design patterns help us in communicating with different objects and classes. 
    - You have a system, you have certain classes, you have certain objects, now you just need to communicate between them and decide how the objects should communicate.
    - These design patterns although seem worthless first but believe me they are very useful when it comes to interact with other classes functions and checking them.