package models.persistence.entities;

import javax.persistence.DiscriminatorColumn;
import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;
import javax.persistence.Table;

@Entity
@Table(name = "dbo.T_REF_DATA")
@DiscriminatorValue("OPERATING_SYSTEM")
@DiscriminatorColumn(name = "refDataType")
<<<<<<< HEAD
public class OperatingSystem extends ValueObject {}
=======
public class OperatingSystem extends ValueObject {}
>>>>>>> 6deadbe746ee20d4203467e07c086415a21cfe1c
