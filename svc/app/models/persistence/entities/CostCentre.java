package models.persistence.entities;

import javax.persistence.*;
import java.math.BigDecimal;

@Entity
@Table(name = "dbo.T_COST_CENTRES")
public class CostCentre
{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @JoinColumn(name = "functionalOrg")
    @OneToOne
    private FunctionalOrganisation functionalOrg;

    @Column(name = "accountNo", nullable = false)
    private BigDecimal accountNo;

    @Column(name = "title", nullable = false)
    private String title;

    public CostCentre()
    {

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

    public BigDecimal getAccountNo() {
        return accountNo;
    }

    public void setAccountNo(BigDecimal accountNo) {
        this.accountNo = accountNo;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }
}