package models.persistence.entities;

import javax.persistence.*;

@Table(name = "dbo.T_MODELS")
@Entity
public class Model
{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column(name = "brand", nullable = false)
    @ManyToOne
    private String brand;

    @Column(name = "name", nullable = false)
    private String name;

    @Column(name = "category", nullable = false)
    @ManyToOne
    private Category category;

    @Column(name = "barCode", nullable = false)
    private String barCode;

}
