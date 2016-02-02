package models.persistence.entities;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "dbo.T_FO")
public class FunctionalOrganisation {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)
    private int id;

    @Column(name = "account", nullable = false)
    private String account;

    @Column(name = "smPlatform")
    private String smPlatform;

    @Column(name = "cmdbPlatform")
    private String cmdbPlatform;

    public FunctionalOrganisation() {}

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getAccount() {
        return account;
    }

    public void setAccount(String account) {
        this.account = account;
    }

    public String getSmPlatform() {
        return smPlatform;
    }

    public void setSmPlatform(String smPlatform) {
        this.smPlatform = smPlatform;
    }

    public String getCmdbPlatform() {
        return cmdbPlatform;
    }

    public void setCmdbPlatform(String cmdbPlatform) {
        this.cmdbPlatform = cmdbPlatform;
    }
}
