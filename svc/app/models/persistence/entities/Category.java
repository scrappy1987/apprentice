package models.persistence.entities;

import javax.persistence.*;

@Table(name = "dbo.T_CATEGORIES")
@Entity
public class Category
{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column(name = "category", nullable = false)
    private String category;

    @Column(name = "type", nullable = false)
    @ManyToOne
    private CategoryType categoryType;
}
