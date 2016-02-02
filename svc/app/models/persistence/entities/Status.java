package models.persistence.entities;

import javax.persistence.*;

@Entity
@DiscriminatorValue("STATUS")
public class Status extends ValueObject
{
}
