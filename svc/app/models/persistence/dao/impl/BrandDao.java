package models.persistence.dao.impl;

import models.persistence.dao.GenericDao;
import models.persistence.dao.play.EntityManagerProvider;
import models.persistence.entities.Brand;

import javax.inject.Inject;

public class BrandDao extends GenericDao<Brand>
{
    @Inject
    public BrandDao(EntityManagerProvider entityManagerProvider)
    {
        super(entityManagerProvider);
    }
}
