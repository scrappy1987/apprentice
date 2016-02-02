package models.persistence.entities;

import javax.persistence.*;

@Entity
@Table(name = "dbo.T_BUSINESS_UNITS")
public class BusinessUnit
{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @ManyToOne
    @JoinColumn(name = "functionalOrg")
    private FunctionalOrganisation functionalOrg;

    @Column(name = "fullName", nullable = false)
    private String accountNo;

    @Column(name = "name", nullable = false)
    private String name;

    @Column(name = "barCode", nullable = false)
    private String barCode;

    public BusinessUnit() {
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public FunctionalOrganisation getFunctionalOrg() {
        return functionalOrg;
    }

    public void setFunctionalOrg(FunctionalOrganisation functionalOrg) {
        this.functionalOrg = functionalOrg;
    }

    public String getAccountNo() {
        return accountNo;
    }

    public void setAccountNo(String accountNo) {
        this.accountNo = accountNo;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getBarCode() {
        return barCode;
    }

    public void setBarCode(String barCode) {
        this.barCode = barCode;
    }
}
