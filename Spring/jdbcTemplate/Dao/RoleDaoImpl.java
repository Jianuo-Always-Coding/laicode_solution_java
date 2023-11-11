package src.com.qfedeu.spring.dao;

import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;

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
