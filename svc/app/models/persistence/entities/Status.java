package models.persistence.entities;

import javax.persistence.*;

@Entity
@Table(name = "dbo.T_REF_DATA")
@DiscriminatorValue("STATUS")
public class Status extends ValueObject {}
