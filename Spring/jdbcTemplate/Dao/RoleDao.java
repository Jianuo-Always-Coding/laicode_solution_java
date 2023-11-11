package src.com.qfedeu.spring.dao;

public interface RoleDao {
    void save(Role role);

    void delete(Integer id);

    void update(Role role);

    Role getById(Integer id);

    List<Role> getAll();

    int getTotalCount();
}
