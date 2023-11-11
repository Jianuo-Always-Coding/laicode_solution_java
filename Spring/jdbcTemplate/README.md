# JDBC

## Steps

1. 创建项目
2. 导包
3. 日志文件
4. 创建数据库表（ar_role）
5. 写测试类

### Method 1 直接连接 C3P0

```java
public class TestJdbcTemplate {
    @Test
    public void testSave1() {
        // 准备连接池
        ComboPooledDataSource dataSource = new ComboPooledDataSource();
        dataSource.setDriverClass("com.mysql.jdbc.Driver");
        dataSource.setJdbcUrl("jdbc:mysql://localhost:3306/spring");
        dataSource.setUser("root");
        dataSource.setPassword("123456");

        JdbcTemplate jt = new JdbcTemplate(dataSource);
        String sql = "INSERT INTO ar_role ( "
                + "rname,"
                + "alias"
                + ") VALUES (?, ?)";
        jt.update(sql, "test1", "test1");
    }
}
```

### Method 2： 使用 DataSourseUtil

> - 引入 C3P0 的配置文件
> - 拷贝 DataSourceUtil.java 类
> - 写测试用例

```java
public class TestJdbcTemplate {
    @Test
    public void testSave1() {
        // 准备连接池
        DataSource dataSource = DataSourceUtil.getDataSource();
        JdbcTemplate jt = new JdbcTemplate(dataSource);
        String sql = "INSERT INTO ar_role ( "
                + "rname,"
                + "alias"
                + ") VALUES (?, ?)";
        jt.update(sql, "test1", "test1");
    }
}
```

## 使用 Spring 管理 jdbcTemplate

<mark>JDBC 交给 Spring 去管理，不用 Dao 管理，Dao 只需要关注业务逻辑</mark>

1. 创建 pojo.Role.java

2. 创建 RoleDao.java 和 RoleDaoImpl.java

- 接口

```java
public interface RoleDao {
    void save(Role role);

    void delete(Integer id);

    void update(Role role);

    Role getById(Integer id);

    List<Role> getAll();

    int getTotalCount();
}

```

- 实现

```java
public class RoleDaoImpl implements RoleDao {

    // JDBC交给Spring去管理，不用Dao管理，Dao只需要关注业务逻辑
    JdbcTemplate jt;
    public void setJt(JdbcTemplate jt) {
        this.jt = jt;
    }

    @Override
    public void save(Role role) {
        String sql = "INSERT INTO ar_role ( "
                + "rname,"
                + "alias"
                + ") VALUES (?, ?)";
        jt.update(sql, role.getRname(), role.getAlias());
    }

    @Override
    public void delete(Integer id) {
        String sql = "DELETE FROM ar_role WHERE rid = ?";
        jt.update(sql, id);
    }

    @Override
    public void update(Role role) {
        String sql = "UPDATE ar_role SET rname = ?, alias = ?, where id = ?";
        jt.update(sql, role.getRname(), role.getAlias(), role.getRid());
    }

    @Override
    public Role getById(Integer id) {
        String sql = "SELECT * FROM ar_role WHERE rid = ?";
        Role role = jt.queryForObject(sql, new RowMapper<Role>() {
            @Override
            public Role mapRow(ResultSet rs, int index) throws SQLException {
                return mapRowHandler(rs);
            }
        }, id);
        return role;
    }

    @Override
    public List<Role> getAll() {
        String sql = "SELECT * FROM ar_role";
        List<Role> list = jt.query(sql, new RowMapper<Role>() {
            @Override
            public Role mapRow(ResultSet rs, int index) throws SQLException {
                return mapRowHandler(rs);
            }
        });
        return list;
    }

    @Override
    public int getTotalCount() {
        String sql = "SELECT COUNT(1) FROM ar_role";
        Integer count = jt.queryForObject(sql, Integer.class);
        return count;
    }


    private Role mapRowHandler(ResultSet rs) throws SQLException {
        Role role = new Role();
        role.setRname(rs.getString("rname"));
        role.setAlias(rs.getString("alias"));
        role.setRid(rs.getInt("rid"));
        return role;
    }
}

```
