1. 在src目录下创建db.properities文件，存储常量
```java
jdbc.driver=com.mysql.jdbc.Driver
jdbc.url=jdbc:mysql://localhost:3306/blog_gp1701
jdbc.username=root
hdbc.password=123456
```
2. 在applicationContext.xml文件中配置dataSource，和数据库进行连接，引用db.properities中的变量
```javascript
    <context:property-placeholder location="classpath:db.properties" />
    
    <!--连接池-->
    <bean name="dataSource" class="com.mchange.v2.c3p0.ComboPooledDataSource">
        <property name="driverClass" value="${jdbc.driver}"></property>
        <property name="jdbcUrl" value="${jdbc.url}"></property>
        <property name="user" value="${jdbc.username}"></property>
        <property name="password" value="${jdbc.password}"></property>
    </bean>
    
    <!--    JDBC Template    -->
    <bean name="jdbcTemplate" class="org.springframework.jdbc.core.JdbcTemplate">
        <property name="dataSource" ref="dataSource"></property>
    </bean>
    
    <!--    roleDao    -->
    <bean name="roleDao" class="src.com.qfedeu.spring.dao.RoleDaoImpl">
        <property name="jt" ref="jdbcTemplate"></property>
    </bean>
```

3. 创建test测试
```java
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("classpath:applicationContext.xml")
public class AopTest {

    @Resource(name="roleDao")
    private RoleDao roleDao;

    @Test
    public void testSave() {
        Role role = new Role();
        role.setRname("spring1");
        role.setAlias("spring2");
        roleDao.save(role);
    }

}
```