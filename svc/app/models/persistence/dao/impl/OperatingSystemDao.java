package models.persistence.dao.impl;

import models.persistence.dao.GenericDao;
import models.persistence.dao.play.EntityManagerProvider;
import models.persistence.entities.OperatingSystem;

import javax.inject.Inject;

public class OperatingSystemDao extends GenericDao<OperatingSystem>
{
    @Inject
    public OperatingSystemDao(EntityManagerProvider entityManagerProvider)
    {
        super(entityManagerProvider);
    }
<<<<<<< HEAD
}
=======
}
>>>>>>> 6deadbe746ee20d4203467e07c086415a21cfe1c
