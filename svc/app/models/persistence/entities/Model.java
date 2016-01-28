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

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getBrand() {
        return brand;
    }

    public void setBrand(String brand) {
        this.brand = brand;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Category getCategory() {
        return category;
    }

    public void setCategory(Category category) {
        this.category = category;
    }

    public String getBarCode() {
        return barCode;
    }

    public void setBarCode(String barCode) {
        this.barCode = barCode;
    }
}
