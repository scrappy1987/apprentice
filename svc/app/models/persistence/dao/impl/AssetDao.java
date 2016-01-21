package models.persistence.dao.impl;

import models.persistence.dao.play.EntityManagerProvider;
import models.persistence.dao.GenericDao;
import models.persistence.entities.Asset;

import javax.inject.Inject;

public class AssetDao extends GenericDao<Asset>
{
    @Inject
    public AssetDao(EntityManagerProvider emp)
    {
        super(emp);
    }

    //Add methods for any Asset specific database accesses here.
}
