package models.persistence.dao.impl;

import javax.inject.Inject;
import models.persistence.dao.GenericDao;
import models.persistence.dao.play.EntityManagerProvider;
import models.persistence.entities.Status;

public class StatusDao extends GenericDao<Status>
{
    @Inject
    public StatusDao(EntityManagerProvider entityManagerProvider)
    {
        super(entityManagerProvider);
    }
}
