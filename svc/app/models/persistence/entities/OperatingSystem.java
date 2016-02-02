package models.persistence.entities;

import javax.persistence.*;

@Entity
@DiscriminatorValue("OPERATING_SYSTEM")
public class OperatingSystem extends ValueObject
{
}
