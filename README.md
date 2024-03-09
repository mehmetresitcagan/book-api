# springRoad

https://www.youtube.com/watch?v=Nv2DERaMx-4&list=WL&index=2&t=450s

https://www.youtube.com/watch?v=5rNk7m_zlAg&list=WL&index=4

0. Spring is an open source framework for building enterprise Java applications

1. Spring core features:

   - IOC(inversion on control container) -> logging, cacning, transaction management, authentication
   - AOP(aspect oriented programming)
   - Data Access Framework -> jdbc, hibernate, jpa
   - mvc

2. Spring beans

   - beans refers to an object that is managed by spring

3. Spring components

   - **@Component** as a general component annotation indicating that the class should be initialized, configured and managed by the core container.
   - **@Repository**, **@Service** and **@Controller** for **@Component** that allow to further re-fine components.

4. Bean naming

   - **@Bean("initialize")**: bean name i initialize olur.
   - **@Bean()** : bean name i method name i ne ise o olur.

5. Dependency Injection

   - Constructor injection
   - Field injection
   - Configuration methods
   - Setter methods injection

6. Bean scoping

   - singleton
   - prototype
   - request
   - session
   - application
   - websocket

7. Spring Boot
   - It is an approach to develop Spring based applications with very less or no configuration.
8. Spring initializr

   - https://start.spring.io/
   - maven seçildi
   - jar packaging seçildi

9. Dependencies

   - spring web -> build web, mvc, restful apis

10. Artifact id -> proje id

11. ui files places in resources/static folder

12. application.properties file
13. unit test, integration test, end to end test places in test folder.
14. pom.xml -> has info of metadata, properties of application, dependencies
15. maven -> it helps programmers manage their projects and all the things they need to build their programs.
16. spring vs spring boot -> spring boot, spring in üzerine yerleştirilmiş bir katmandır. spring boot bizim için çok fazla hazır konfigürasyona sahip. böylece spring boot ile daha hızlı application üretebiliyoruz. spring boot makes spring easier to use.
17. spring application layers:

    - persistence layer is to handle with database (model)
    - service layer's goal is to use all the fuctionality exposed by persistence layer (service)
    - presentation layer (view)

18. @Configuration component scanning phase inde bean leri arar.
19. Spring boot, springden farklı olarak default ayarları vardır. Bunu @EnableAutoConfiguration ile yapar.
20. JDBC -> (java database connectivity) interact with database by using sql queries. low level.
21. JPA -> (Java persistence API) interact with database by using java object. high level. actual implementation is called hibernate.
22. hibernate referred to orm. object relational mapper
23. database driver is to interact with a specific database. jdbc is to how to connect to database and query it using sql. jpa is how you would query database using java objects.
24. H2 -> in-memory database dependency.
25. Dao -> data access object
26. Unit test, bir yazılımın en küçük parçalarını (fonksiyon, metod) izole bir şekilde test ederken, integration test ise farklı bileşenlerin bir araya geldiğinde doğru çalıştığını kontrol eder.
27. jdbc kullanırken sql sorguları yazılıyor. çok fazla iş yükü oluyor.
28. Hibernate Auto dll -> Entity tablelarının otomatik olarak database de oluşmasını sağlıyor.
29. JPA methodları:
   - save() -> obje create etmek için.
   - findById()
