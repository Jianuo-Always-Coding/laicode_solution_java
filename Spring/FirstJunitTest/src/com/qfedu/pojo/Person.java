package com.qfedu.pojo;

import org.springframework.strtrotype.Component;

@Component("person")
// 等于这个配置<bean name = "person" class = "com.qfedu.sprong.pojo.Person"></bean>
@Scope(scopeName="singleton") 
// @ Scope(scopeName="prototype") 
// @ Service("person") 
// @ Controller("person") 
// @ Repository("person") // 适用于持久层

public class Person {
    
    @Value("halen")
    private String name;

    @Value("18")
    private Integer age;

    @Autowired // 将Car类型的实例自动注入进来
    @Qualifier("car2")
    private Car car;

    public Person() {
        super();
        System.out.println("Person构造方法被调用");
    }

    @PostConstruct
    public void init() {
        System.out.println("Person 被初始化");
    }

    @PreDestory
    public void destroy() {
        System.out.println("Person 被销毁");
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }

    public Car getCar() {
        return car;
    }

    public void setCar(Car car) {
        this.car = car;
    }


}