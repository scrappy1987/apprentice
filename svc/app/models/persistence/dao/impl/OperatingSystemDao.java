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
}
