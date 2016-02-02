package models.persistence.entities;

import javax.persistence.*;

@Entity
@DiscriminatorValue("PROPERTY_TYPE")
public class PropertyType extends ValueObject
{
}
