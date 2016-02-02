package models.persistence.entities;

import javax.persistence.*;

@Entity
@Table(name = "dbo.T_REF_DATA")
@Inheritance(strategy=InheritanceType.SINGLE_TABLE)
@DiscriminatorColumn(name="refDataType")
public class ValueObject
{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column(name = "value", nullable = false)
    private String value;

    @Column(name = "hpamId", nullable = false)
    private int hpamId;

    public ValueObject() {}

    public int getId()
    {
        return id;
    }

    public void setId(int id)
    {
        this.id = id;
    }

    public String getValue()
    {
        return value;
    }

    public void setValue(String value)
    {
        this.value = value;
    }

    public int getHpamId()
    {
        return hpamId;
    }

    public void setHpamId(int hpamId)
    {
        this.hpamId = hpamId;
    }
}
