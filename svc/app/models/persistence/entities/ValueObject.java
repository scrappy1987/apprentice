package models.persistence.entities;

import javax.persistence.*;

@Table(name = "dbo.T_REF_DATA")
@Entity
public class ValueObject
{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column(name = "value", nullable = false)
    private String value;

    @Column(name = "refDataType", nullable = false)
    private String refDataType;

    @Column(name = "hpamId", nullable = false)
    private int hpamId;

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

    public String getRefDataType()
    {
        return refDataType;
    }

    public void setRefDataType(String refDataType)
    {
        this.refDataType = refDataType;
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
