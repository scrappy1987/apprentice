package models.persistence.dao.impl;

import models.persistence.dao.play.EntityManagerProvider;
import models.persistence.dao.GenericDao;
import models.persistence.entities.Asset;

import javax.inject.Inject;
import java.util.List;

public class AssetDao extends GenericDao<Asset>
{
    @Inject
    public AssetDao(EntityManagerProvider emp)
    {
        super(emp);
    }

    // public List<Asset> listForContact(Contact contact)
    // {
        // return getEntityManager().createNamedQuery("SELECT a FROM Asset a WHERE a.contact = " + contact).getResultList();
    // }
}
