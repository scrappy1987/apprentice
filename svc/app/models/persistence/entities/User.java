package models.persistence.entities;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "dbo.T_USER")
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)
    private Long id;

    @Column(name = "name", nullable = false)
    private String userId;

     @OneToMany
     @JoinColumn(name = "dbo.T_FO")
     private List<FunctionalOrganisation> functionalOrgs;

    public User() {}

    public Long getId()
    {
        return this.id;
    }

    public void setId(Long id)
    {
        this.id = id;
    }

    public String getUserId()
    {
        return this.userId;
    }

    public void setName(String name)
    {
        this.userId = name;
    }

    public List getFunctionalOrgs()
    {
        return this.functionalOrgs;
    }

    public void setFunctionalOrgs(List functionalOrgs)
    {
        this.functionalOrgs = functionalOrgs;
    }
}
