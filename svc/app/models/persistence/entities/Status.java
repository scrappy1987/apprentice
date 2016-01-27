package models.persistence.entities;

import javax.persistence.*;

@Entity
@Table(name = "dbo.T_REF_DATA")
@DiscriminatorValue("STATUS")
@DiscriminatorColumn(name = "refDataType")
public class Status extends ValueObject {}
