package models.persistence.entities;

import javax.persistence.DiscriminatorColumn;
import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;
import javax.persistence.Table;

@Entity
@Table(name = "dbo.T_REF_DATA")
@DiscriminatorValue("CATEGORY_TYPE")
@DiscriminatorColumn(name = "refDataType")
public class CategoryType extends ValueObject {}
