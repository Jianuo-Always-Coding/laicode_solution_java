package src.com.qfedeu.spring.dao;

import javax.persistence.Id;
import java.io.Serializable;


public class Role implements Serializable {

    private static final long serialVersionUID = 8734140534986494039L;

    @Id
    private Integer Rid;

    private String Rname;

    private String Alias;

    public Integer getRid() {
        return Rid;
    }

    public void setRid(Integer rid) {
        Rid = rid;
    }

    public String getRname() {
        return Rname;
    }

    public void setRname(String rname) {
        Rname = rname;
    }

    public String getAlias() {
        return Alias;
    }

    public void setAlias(String alias) {
        Alias = alias;
    }
}