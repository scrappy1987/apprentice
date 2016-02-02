package models.persistence.entities;

import javax.persistence.DiscriminatorColumn;
import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;
import javax.persistence.Table;

@Entity
@DiscriminatorValue("CATEGORY_TYPE")
public class CategoryType extends ValueObject
{
}
