package models.persistence.entities;

import javax.persistence.*;
import java.math.BigDecimal;

@Table(name = "dbo.T_COST_CENTRES")
@Entity
public class CostCentre
{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column(name = "functionalOrg", nullable = false)
    @OneToOne
    private FunctionalOrganisation functionalOrg;

    @Column(name = "accountNo", nullable = false)
    private BigDecimal accountNo;

    @Column(name = "title", nullable = false)
    private String title;
}