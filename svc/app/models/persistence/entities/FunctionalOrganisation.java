package models.persistence.entities;

import javax.persistence.*;
import java.util.List;

/**
 * Created by a613794 on 28/01/2016.
 */
@Table(name = "dbo.T_FO")
@Entity
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

    @OneToMany
    @JoinColumn(name = "dbo.T_BUSINESS_UNITS")
    private List<BusinessUnit> businessUnits;

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

    public List<BusinessUnit> getBusinessUnits() {
        return businessUnits;
    }

    public void setBusinessUnits(List<BusinessUnit> businessUnits) {
        this.businessUnits = businessUnits;
    }
}
