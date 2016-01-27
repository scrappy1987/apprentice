package models.persistence.dao.impl;

import models.persistence.dao.GenericDao;
import models.persistence.dao.play.EntityManagerProvider;
import models.persistence.entities.PropertyType;

import javax.inject.Inject;

public class PropertyTypeDao extends GenericDao<PropertyType>
{
    @Inject
    public PropertyTypeDao(EntityManagerProvider entityManagerProvider)
    {
        super(entityManagerProvider);
    }
}
