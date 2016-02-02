package models.persistence.dao.impl;

import com.google.inject.Inject;
import models.persistence.dao.GenericDao;
import models.persistence.dao.play.EntityManagerProvider;
import models.persistence.entities.Model;

public class ModelDao extends GenericDao<Model> {
    @Inject
    public ModelDao(EntityManagerProvider emp)
    {
        super(emp);
    }
}
