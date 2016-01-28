package models.persistence.entities;

import javax.persistence.*;
import java.math.BigDecimal;

@Table(name = "dbo.T_FO")
@Entity
public class FunctionalOrganisation
{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column(name = "account", nullable = false)
    private String account;

    @Column(name = "smPlatform", nullable = false)
    private String smPlatform;

    @Column(name = "cmdbPlatform", nullable = false)
    private String cmdbPlatform;
}
