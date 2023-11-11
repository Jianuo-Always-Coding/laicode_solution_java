import com.mchange.v2.c3p0.ComboPooledDataSource;
import org.junit.jupiter.api.Test;
import org.springframework.jdbc.core.JdbcTemplate;

import javax.sql.DataSource;

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

    @Test
    public void testSave2() {
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
