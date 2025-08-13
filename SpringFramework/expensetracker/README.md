# Learnings from the project

Using this project I am trying to learn how Spring Data JPA framework helps in ORM (Object Relation Mapping) using annotations like `@Entity` and make sure that we avoid writing boilerplate code to do CRUD operations by providing the support of JPA Repositories. 

Creating an Expense Tracker Project here.

Key Findings

- Create a class `Expense` whose instances can be instantiated as records in the table.(I have used PostgreSQL.)

```java
@Entity
@Table(name = "expense")
public class Expense {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer expense_id;
    @Column(name = "description", nullable = false)
    private String description;
    @Column(name = "amount", nullable = false)
    private Integer amount;
    @Column(name = "date_of_expenditure", nullable = false)
    private LocalDate localDate;
}
```

- Annotations that I have used and what does it mean here ?

    1. `@Entity` - this defines the following class as an Entity for which the table will be created in the Database. Any object which will have this annotation its table will be created. Moreover its object or a Bean will also be created in the IoC container. For any class to be an entity it should have 

        - NoArgsConstructor 
        - Primary Key attribute which brings us to another annotation named as @Id.

    2. `@Id` - this is an annotation which makes any class variable a  primary key attribute that makes it unique and non null. Defining a class variable as @Id we make sure when its table will be created in the Database we will automatically make this column as Primary Key. 

    3. `@GeneratedValue` - this annotation takes care to generate values automatically based on the generation type which is an argument that is supplied inside the annotation. It takes an argument named as `strategy` which takes an enum of the `GenerationType` either as 

        - **AUTO** - Automatically decides and puts unique non null value
        - **UUID** - Creates a Unique Identifier everytime.
        - **IDENTITY** - Most commonly used this strategy picks up the id = 1 if there are no records in the table and increments it going forward for other entries.
        - **SEQUENCE** - Follows a sequential pattern
        - **TABLE** - not explored it yet. 
    
    4. `@Column` -- this annotation defines any attribute as a column and is added in the table. There are certain arguments which can be supplied in order to control the behavior of the column.

        - `name` - explicitly mentioning the name of the column to create in the database.
        - `unique` - a boolean argument that decides if you want to keep the attribute unique.
        - `nullable` - a boolean argument that decides if you want to keep the attribute non null.
        - `length` - set a length for the attribute in the database

- Some more annotations for the which can be used with Spring data JPA.

    1. `@Transient` - Used when we do not want any of the field to persist in the database. Best example is `Age` parameter. If any class has `Age` parameter we generally will not store it in DB. (Because it could be calculated from DOB.)

    2. `@Temporal` - is used to specify the type of a `java.util.Date` or `java.util.Calendar` field when mapping it to a database column. It helps in converting Java date/time objects into compatible SQL types and vice versa.
    For modern date/time APIs like `java.time.LocalDate`, `java.time.LocalTime`, or `java.time.LocalDateTime`, `@Temporal` is not required, as these are directly supported by JPA.

    3. `@Enumerated` - is used to create and specify the behavior of Enums in Database. It controls the way that handles the way enum stores in the table.