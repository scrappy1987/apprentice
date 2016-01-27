package models.persistence.dao.impl;

import models.persistence.dao.GenericDao;
import models.persistence.dao.play.EntityManagerProvider;
import models.persistence.entities.CategoryType;

import javax.inject.Inject;

public class CategoryTypeDao extends GenericDao<CategoryType>
{
    @Inject
    public CategoryTypeDao(EntityManagerProvider entityManagerProvider)
    {
        super(entityManagerProvider);
    }
}
